package com.pratik.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pratik.messenger.datamodel.Message;
import com.pratik.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgServc = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)    //supported in pom.xml
	public List<Message> getAllMessages(){
		return msgServc.getAllMessages();
	}
	
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id){			//injecting uri parameter to method as argument
		return msgServc.getMessage(id);
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg){			//Jersey converts the input json to message format
		return msgServc.addMessage(msg);
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long msgId, Message msg){
		msg.setId(msgId);
		return msgServc.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long msgId){
		msgServc.removeMessage(msgId);
	}

	
}
