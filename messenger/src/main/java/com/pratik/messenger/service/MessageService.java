package com.pratik.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pratik.messenger.database.DatabaseClass;
import com.pratik.messenger.datamodel.Message;
import com.pratik.messenger.datamodel.Profiles;
import com.pratik.messenger.exception.DataException;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		// TODO Auto-generated constructor stub
		messages.put(1L, new Message(1, "Message 1", "Pratik"));
		messages.put(2L, new Message(2, "Message 2", "Shruti"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id){
		Message msg = messages.get(id);
		if(null == msg){
			throw new DataException("Message with Id: " + id + " not found...!");
		}
		return msg;
	}
	
	public Message addMessage(Message msg){
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(msg.getId()<=0)
			return null;
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
