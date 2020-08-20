package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vladirius.classicmodel.data.models.ContactEntity;
import org.vladirius.classicmodel.data.repositories.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	//Create message
	@Transactional
	public void addMessage(ContactEntity message) {
		contactRepository.save(message);
	}
	
	//Retrieve all message
	public List<ContactEntity> getMessages(){
		List<ContactEntity> messageList = new ArrayList<ContactEntity>();
		for(ContactEntity message:contactRepository.findAll()) {
			messageList.add(message);
		}
		return messageList;
	}
	
	//Retrieve message by ID
	public ContactEntity getMessage(int id) {
		return contactRepository.findById(id).get();
	}
	
	//Delete message by ID
	public void deleteMessage(int id) {
		contactRepository.deleteById(id);
	}
}
