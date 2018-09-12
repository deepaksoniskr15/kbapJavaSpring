package com.lina.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lina.chat.app.domain.CbIntentParameters;
import com.lina.chat.app.dto.ApInvoiceDetailsIntentDataDto;
import com.lina.chat.app.dto.ApiResponseDto;
import com.lina.chat.app.dto.ApiResponseDto.ApiResponseDtoBuilder;
import com.lina.chat.app.dto.CbIntentParametersDto;
import com.lina.chat.app.dto.TableResponseData;
import com.lina.chat.app.mapper.CustomMapper;
import com.lina.chat.app.service.IIntentService;

@RestController
@RequestMapping("/api")
public class IntentController {

	@Autowired
	IIntentService intentService;

	@Autowired
	private CustomMapper mapper;

	@RequestMapping(value = "/getIntentDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ApiResponseDto getIntentDetails(@RequestParam("key") String key) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		List<CbIntentParameters> listOfCbIntentParameters = intentService.getIntentData(key);
		List<CbIntentParametersDto> listOfIntentParametersDto = mapper
				.cbIntentParametersToCbIntentParametersDto(listOfCbIntentParameters);
		String requestForMessage = intentService.findIntentNameBy(key);
		apiResponseDtoBuilder.withData(listOfIntentParametersDto).withMessage(requestForMessage)
				.withStatus(HttpStatus.OK);
		return apiResponseDtoBuilder.build();
	}

	@RequestMapping(value = "/getTableDataByParams", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ApiResponseDto getTableDataByParams(@RequestBody ApInvoiceDetailsIntentDataDto intentRequestDataDto) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		TableResponseData tableResponseData = intentService.getTableDataByRequestParams(intentRequestDataDto);
		if(tableResponseData == null){
			apiResponseDtoBuilder.withMessage("No data available").withStatus(HttpStatus.OK);
		}else{
			apiResponseDtoBuilder.withData(tableResponseData).withStatus(HttpStatus.OK);
		}
		return apiResponseDtoBuilder.build();
	}

	@RequestMapping(value = "/getAllIntentNameList", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ApiResponseDto getAllIntentNameList() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		List<String> listOfUtteranceDescription = intentService.findUtteranceDescription();
		apiResponseDtoBuilder.withData(listOfUtteranceDescription).withStatus(HttpStatus.OK);
		return apiResponseDtoBuilder.build();
	}

}
