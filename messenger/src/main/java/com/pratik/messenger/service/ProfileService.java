/**
 * 
 */
package com.pratik.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.tools.profiler.Profile;

import com.pratik.messenger.database.DatabaseClass;
import com.pratik.messenger.datamodel.Profiles;

/**
 * @author pratiksrivastava
 *
 */
public class ProfileService {

	private Map<String, Profiles> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("pratik", new Profiles(1L, "pratik", "Pratik", "Kumar"));
		profiles.put("shruti", new Profiles(2L, "shruti", "Shruti", "Jain"));
	}

	public List<Profiles> getAllProfiles(){
		return new ArrayList<Profiles>(profiles.values());
	}
	
	public Profiles getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profiles addProfile(Profiles newProfile){
		newProfile.setId(profiles.size() + 1);
		profiles.put(newProfile.getProfileName(), newProfile);
		return newProfile;
	}
	
	public Profiles updateProfile(Profiles profile){
		if(profile.getId() <= 0 )
			return null;
		else{
			profiles.put(profile.getProfileName(), profile);
		}
		return profile;
	}
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}
	
}
