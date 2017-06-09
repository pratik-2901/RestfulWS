package com.pratik.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.pratik.messenger.datamodel.Message;
import com.pratik.messenger.datamodel.Profiles;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profiles> profiles = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profiles> getProfiles(){
		return profiles;
	}
	
}
