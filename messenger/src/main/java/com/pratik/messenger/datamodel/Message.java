package com.pratik.messenger.datamodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	
	private List<Links> link = new ArrayList<>();

	public Message(){
		
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Links> getLink() {
		return link;
	}

	public void setLink(List<Links> link) {
		this.link = link;
	}
	
	
	public void addLink(String uri, String rel){
		Links links = new Links();
		links.setRelation(rel);
		links.setUri(uri);
		link.add(links);
	}
	
}
