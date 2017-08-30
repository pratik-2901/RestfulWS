/**
 * 
 */
package com.pratik.messenger.resources;

import java.util.ArrayList;
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

import com.pratik.messenger.datamodel.Profiles;
import com.pratik.messenger.service.ProfileService;

/**
 * @author pratiksrivastava
 *
 */

@Path("/profiles")
//@Produces(value={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})		//content negotiation
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profServ = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profiles> getJsonAllProfiles(){
		System.out.println("JSON Method Called...");
		return profServ.getAllProfiles();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Profiles> getXmlAllProfiles(){
		System.out.println("XML Method Called...");
		return profServ.getAllProfiles();
	}
	
	
	@GET
	@Path("/{profileName}")
	public Profiles getProfile(@PathParam("profileName") String profileName){
		return profServ.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Profiles addJsonProfile(Profiles newProfile){
		System.out.println("JSON Method Called...");
		return profServ.addProfile(newProfile);
	}
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	public Profiles addXmlProfile(Profiles newProfile){
		System.out.println("XML Method Called...");
		return profServ.addProfile(newProfile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profiles updateProfile(@PathParam("profileName") String profName, Profiles profile){
		profile.setProfileName(profName);
		return profServ.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profName){
		profServ.removeProfile(profName);
	}
	
}
