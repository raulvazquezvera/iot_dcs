package com.iot.dcs.client.impl;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iot.dcs.client.DCSClient;
import com.iot.dcs.model.DCSDto;

@Service
public class DCSClientImpl implements DCSClient {

	@Value("${wi.url}")
	private String url;

	@Value("${wi.configuredevice}")
	private String configuredevice;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean deviceConfiguration(DCSDto dto) {
		StringBuilder urlSb = new StringBuilder(url).append(configuredevice);

		List<Charset> acceptCharset = new ArrayList<>();
		acceptCharset.add(StandardCharsets.UTF_8);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAcceptCharset(acceptCharset);

		HttpEntity<DCSDto> entity = new HttpEntity<>(dto, headers);

		ResponseEntity<Boolean> response = restTemplate.exchange(urlSb.toString(), HttpMethod.POST, entity,
				new ParameterizedTypeReference<Boolean>() {
				});

		return response.getBody();
	}

}
