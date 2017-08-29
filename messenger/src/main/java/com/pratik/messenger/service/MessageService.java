package com.pratik.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pratik.messenger.database.DatabaseClass;
import com.pratik.messenger.datamodel.ErrorMessage;
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
		
		ErrorMessage erMsg = new ErrorMessage("404", "Data is not found", "www.google.com" );
		Response resp =  Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(erMsg)
				.build();
		
		Message msg = messages.get(id);
		if(null == msg){
			//throw new DataException("Message with Id: " + id + " not found...!");  -- customized exception message using excepyion mapper
			
			//throw new WebApplicationException(Status.NOT_FOUND);
			//throw new WebApplicationException(resp);
			throw new NotFoundException(resp);
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
