package com.iot.dcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.dcs.client.DCSClient;
import com.iot.dcs.model.DCSDto;
import com.iot.dcs.service.DCSService;

@Service
public class DCSServiceImpl implements DCSService {

	@Autowired
	DCSClient dcsClient;

	@Override
	public boolean deviceConfiguration(DCSDto dto) {
		return dcsClient.deviceConfiguration(dto);
	}

}
