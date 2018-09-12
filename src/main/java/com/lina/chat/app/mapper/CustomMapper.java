package com.lina.chat.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.lina.chat.app.domain.CbIntentParameters;
import com.lina.chat.app.domain.User;
import com.lina.chat.app.dto.CbIntentParametersDto;
import com.lina.chat.app.dto.UserDto;

@Mapper(componentModel = "spring")
public interface CustomMapper {

	UserDto userToUserDto(User user);

	@Mappings({ @Mapping(source = "parameterName", target = "textBoxName"),
			@Mapping(source = "parameterName", target = "textBoxLabel"),
			@Mapping(source = "parameterPrompt", target = "placeholder") })
	CbIntentParametersDto cbIntentParametersToCbIntentParametersDto(CbIntentParameters cbIntentParameters);
	
	List<CbIntentParametersDto> cbIntentParametersToCbIntentParametersDto(List<CbIntentParameters> cbIntentParameters);
	
}
