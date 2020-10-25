package com.stoom.dsilva.api.service;


import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stoom.dsilva.api.exception.GoogleApiInvalidAddressInfo;
import com.stoom.dsilva.api.google.service.GoogleModelApi;
import com.stoom.dsilva.api.google.service.GoogleServiceAPI;
import com.stoom.dsilva.api.model.Cadastro;
import com.stoom.dsilva.api.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	GoogleServiceAPI googleAPI;
	
	
	public Cadastro atualizar(Long id, Cadastro cadastro) throws GoogleApiInvalidAddressInfo, IOException {
		
		Cadastro cadastroSalvo = this.buscarCadastroByCodigo(id);
		BeanUtils.copyProperties(cadastro, cadastroSalvo, "codigo");		
		return cadastroRepository.save(handleLatitudeAndLongitude(new Cadastro().fromModelToEntity(cadastro)));
	}
	
	public Cadastro criar(Cadastro cadastro) throws GoogleApiInvalidAddressInfo, IOException {
	
		return cadastroRepository.save(handleLatitudeAndLongitude(new Cadastro().fromModelToEntity(cadastro)));
	}



	public Cadastro buscarCadastroByCodigo(Long id) {
		Cadastro cadastroSalvo = cadastroRepository.getOne(id);
		if(cadastroSalvo==null) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadastroSalvo;
		
	}
	
	private Cadastro handleLatitudeAndLongitude(Cadastro cadastro) throws GoogleApiInvalidAddressInfo, IOException {

		GoogleModelApi googleAPIModel;

		if (cadastro.getLatitude().isBlank() || cadastro.getLongitude().isBlank()) {
		
			googleAPIModel = googleAPI.getLatAndLng(cadastro);
			cadastro.setLatitude(googleAPIModel.getLatitude());
			cadastro.setLongitude(googleAPIModel.getLongitute());
		}

		return cadastro;
	}

}
