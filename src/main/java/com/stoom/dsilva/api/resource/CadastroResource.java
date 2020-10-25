package com.stoom.dsilva.api.resource;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stoom.dsilva.api.event.RecursoCriadoEvent;
import com.stoom.dsilva.api.exception.GoogleApiInvalidAddressInfo;
import com.stoom.dsilva.api.model.Cadastro;
import com.stoom.dsilva.api.repository.CadastroRepository;
import com.stoom.dsilva.api.service.CadastroService;


@RestController
@RequestMapping("/cadastro")
public class CadastroResource {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private CadastroService cadastroService;
	
	
	@GetMapping
	public List<Cadastro> listar(){
		return cadastroRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Cadastro> criar(@Valid @RequestBody Cadastro cadastro, HttpServletResponse response) throws GoogleApiInvalidAddressInfo, IOException{
		Cadastro cadastroSalvo = cadastroService.criar(cadastro);		
		publisher.publishEvent(new RecursoCriadoEvent(this,response, cadastroSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastroSalvo);		
	}
	
	@GetMapping("/{cadastro}")
	public ResponseEntity<Cadastro> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Cadastro> cadastro = cadastroRepository.findById(codigo);
		
	    if (cadastro.isPresent()) {
			return ResponseEntity.ok(cadastro.get());
		
	    }else {
			return ResponseEntity.notFound().build();
	    }		
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		Cadastro cadastro = new Cadastro();
		cadastro = cadastroRepository.getOne(codigo);
		cadastroRepository.delete(cadastro);
		
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cadastro> atualizar(@PathVariable Long id, @Valid @RequestBody Cadastro cadastro) throws GoogleApiInvalidAddressInfo, IOException{		
		Cadastro cadastroSalvo = cadastroService.atualizar(id, cadastro);
		return ResponseEntity.ok(cadastroSalvo);		
	}
	


}
