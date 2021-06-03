package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.config.RestTemplateConfig;
import com.app.util.Constans;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RestTemplateService implements IService {

	private final RestTemplateConfig restTemplateConfig;

	@Override
	public Object getAll() {

		final String uri = Constans.URI_USERS;
		
		RestTemplate restTemplate = restTemplateConfig.restTemplate();
		HttpHeaders headers = restTemplateConfig.httpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		Object response = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);

		return response;
	}

	@Override
	public Object getFindById(int id) {

		final String uri = Constans.URI_USER.concat(String.valueOf(id));
		
		RestTemplate restTemplate = restTemplateConfig.restTemplate();
		HttpHeaders headers = restTemplateConfig.httpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		Object response = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);
		
		return response;
	}

}
