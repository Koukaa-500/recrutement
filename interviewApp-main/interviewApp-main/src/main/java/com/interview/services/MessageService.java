package com.interview.services;

import com.interview.model.dto.MessageDto;

public interface MessageService {
	public MessageDto sendMessage(MessageDto message,long idEmetteur,long recepteurId);
	
	public void deleteOneMessage(long id);
	

}
