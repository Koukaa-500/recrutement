package com.interview.model.mappers;

import org.modelmapper.ModelMapper;

import com.interview.model.dto.MessageDto;
import com.interview.model.entity.Message;

public class MessageMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static MessageDto convertToDTO(Message message)
	{
	return modelMapper.map(message, MessageDto.class);
	}

	public static Message convertToEntity(MessageDto messageDTO)
	{
	return modelMapper.map(messageDTO, Message.class);	
	}

}
