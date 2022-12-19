package com.iot.dcs.client;

import com.iot.dcs.model.DCSDto;

public interface DCSClient {

	boolean deviceConfiguration(DCSDto dto);

}
