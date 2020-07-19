package com.crud.controllers;

import org.apache.logging.log4j.Logger;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.business.UserBO;
import com.crud.errors.ApiException;
import com.crud.models.UserMO;

@RestController
@RequestMapping("/users")
public class UserCO {
	
	final static Logger logger = LogManager.getLogger(UserCO.class);
	
	@Autowired
	UserBO userBO;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsers(){
		try {
			return new ResponseEntity<Iterable<UserMO>>(userBO.findAll(),HttpStatus.OK);
		}catch(Exception ex) {
			logger.error("Erro ao buscar os usuários", ex);
			return new ResponseEntity<ApiException>(new ApiException(500, "Erro ao buscar os usuários.", ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUser(@PathVariable int id){
		try {
			return new ResponseEntity<Optional<UserMO>>(userBO.findById(id), HttpStatus.OK);
		}catch(IllegalArgumentException ex) {
			logger.warn("Erro ao buscar usuário, pois o id do usuário é nulo.", ex);
			return new ResponseEntity<ApiException>(new ApiException(404, "Erro ao buscar usuário, pois o id do usuário é nulo.", ex), HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			logger.error("Erro ao buscar o usuário.", ex);
			return new ResponseEntity<ApiException>(new ApiException(500, "Erro ao buscar o usuário.", ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody UserMO user){
		try {
			return new ResponseEntity<UserMO>(userBO.save(user), HttpStatus.CREATED);
		}catch(Exception ex) {
			logger.error("Erro ao salvar o usuário.", ex);
			return new ResponseEntity<ApiException>(new ApiException(500, "Erro ao salvar o usuário.", ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody UserMO user){
		try {
			return new ResponseEntity<UserMO>(userBO.update(id, user), HttpStatus.OK);
		}catch(Exception ex) {
			logger.error("Erro ao alterar o usuário.", ex);
			return new ResponseEntity<ApiException>(new ApiException(500, "Erro ao alterar o usuário.", ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable long id){
		try {
			userBO.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(IllegalArgumentException ex) {
			logger.warn("Erro ao deletar usuário, pois o id do usuário é nulo.", ex);
			return new ResponseEntity<ApiException>(new ApiException(404, "Erro ao deletar usuário, pois o id do usuário é nulo.", ex), HttpStatus.NOT_FOUND);
		}catch(Exception ex) {
			logger.error("Erro ao deletar usuário.", ex);
			return new ResponseEntity<ApiException>(new ApiException(500, "Erro ao deletar usuário.", ex), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
