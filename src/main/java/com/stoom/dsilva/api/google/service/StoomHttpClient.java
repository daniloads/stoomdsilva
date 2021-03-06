package com.stoom.dsilva.api.google.service;


import java.io.IOException;
import java.net.URI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import lombok.var;
import lombok.extern.slf4j.Slf4j;


@Service
public class StoomHttpClient {
	
	public String callHttpClient(String URL) {

		var request = HttpRequest.newBuilder().uri(URI.create(URL)).GET().build();
		var client = HttpClient.newHttpClient();
		HttpResponse<String> response = null;

		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return response.body();
	}

}
