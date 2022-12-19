package com.iot.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iot.dcs.model.DCSDto;
import com.iot.dcs.service.DCSService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;

@Api(value = "DeviceConfiguration")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST })
@RestController
public class DCSController {

	@Autowired
	DCSService dcsService;

	/**
	 * Method to configure a device
	 * 
	 * @return DCDto
	 */
	@RequestMapping(value = "/deviceConfiguration", method = RequestMethod.POST)
	public ResponseEntity<?> deviceConfiguration(
			@ApiParam(value = "Input value object", required = true) @RequestBody @Valid DCSDto dto) {
		if (!dcsService.deviceConfiguration(dto)) {
			return ResponseEntity.badRequest().body(HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
