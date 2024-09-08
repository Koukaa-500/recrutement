package com.interview.services.impl;

import org.springframework.stereotype.Service;

import com.interview.model.dto.MessageDto;
import com.interview.model.entity.Message;
import com.interview.model.entity.Utilisateur;
import com.interview.model.mappers.MessageMapper;
import com.interview.repositories.MessageRepository;
import com.interview.repositories.UtilisateurRepository;
import com.interview.services.MessageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;
	private final UtilisateurRepository utilisateurRepository;
	
	
	@Override
	public MessageDto sendMessage(MessageDto message, long idEmetteur, long recepteurId) {
		// TODO Auto-generated method stub
		Message msg=MessageMapper.convertToEntity(message);
		Utilisateur emetteur=utilisateurRepository.findById(idEmetteur).orElse(null);
		Utilisateur recepteur=utilisateurRepository.findById(recepteurId).orElse(null);
		if(emetteur==null|| recepteur ==null)
			return null;
		else
		{
			msg.setEmetteur(emetteur);
			msg.setRecepteur(recepteur);
		return MessageMapper.convertToDTO(messageRepository.save(msg));
		}
	}

	@Override
	public void deleteOneMessage(long id) {
		// TODO Auto-generated method stub
		messageRepository.deleteById(id);

	}

}
