package com.viacep.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viacep.model.CepVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CepService {

	@Value("${via_cep}")
	private String viaCep;
	
	private final RestTemplate rest;
	
	public CepVO getCep(String cep) throws Exception {

		String url = viaCep + cep + "/json/";

		ResponseEntity<CepVO> retornoViaCep = null;
		try {
			retornoViaCep = rest.exchange(url, HttpMethod.GET, null, CepVO.class);
		} catch (Exception e) {
			throw new Exception("O formato do CEP " + cep + "é inválido");
		}

		return retornoViaCep.getBody();

	}
	
}
