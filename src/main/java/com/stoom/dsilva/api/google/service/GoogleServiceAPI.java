package com.stoom.dsilva.api.google.service;

import java.io.IOException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stoom.dsilva.api.exception.GoogleApiInvalidAddressInfo;
import com.stoom.dsilva.api.model.Cadastro;

import lombok.extern.slf4j.Slf4j;





@Service
public class GoogleServiceAPI {
	
	

	@Autowired
	private StoomHttpClient stoomHttpClient;

	@Value("https://maps.googleapis.com/maps/api/geocode/json?")
	private String URL;

	@Value("AIzaSyBm3xh9oZP1ksMWcMzVaZQevWlrtb8tIgc")
	private String apiKey;

	public GoogleModelApi getLatAndLng(Cadastro cadastro) throws GoogleApiInvalidAddressInfo, IOException {
		return this.callGeocodingApi(cadastro).map(this::getGeoLocation).orElseThrow(GoogleApiInvalidAddressInfo::new);
	}

	private GoogleModelApi getGeoLocation(JsonNode jsonNode) {
		GoogleModelApi googleAPIModel = new GoogleModelApi();
		googleAPIModel.setLatitude(jsonNode.get("results").get(0).get("geometry").get("location").get("lat").asText());
		googleAPIModel.setLongitute(jsonNode.get("results").get(0).get("geometry").get("location").get("lng").asText());


		return googleAPIModel;
	}

	private Optional<JsonNode> callGeocodingApi(Cadastro cadastro) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;

		try {
			rootNode = mapper.readTree(stoomHttpClient.callHttpClient(this.createUrl(cadastro)));
		} catch (JsonProcessingException e) {
			throw new GoogleApiInvalidAddressInfo();
		}

		return Optional.ofNullable(rootNode);
	}

	private String createUrl(Cadastro cadastro) {
		StringBuffer sb = new StringBuffer();
		sb.append(URL);
		sb.append(this.createParams(cadastro));
		sb.append(apiKey);

		return sb.toString();

	}

	private String createParams(Cadastro cadastro) {

		StringBuffer sb = new StringBuffer();
		sb.append("address=");
		sb.append(cadastro.getStreetname());
		sb.append("+");
		sb.append(cadastro.getNumber());
		sb.append("+");
		sb.append(cadastro.getCity());
		sb.append("+");
		sb.append(cadastro.getState());
		sb.append("+");
		sb.append(cadastro.getCountry());
		sb.append("+");
		sb.append(cadastro.getZipcode());
		sb.append("&key=");

		return sb.toString().replaceAll(" ", "+");
	}
}
