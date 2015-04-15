package com.faiz.rest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/v3/status")
public class V3_Param {
	
	
	private String api_version ="3.0";
	
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String getStatus(){
		return "<p> This is Parameter examples For Restful Services </p>";
	}
	
	@GET
	@Path("/version")
	@Produces (MediaType.TEXT_HTML)
	public String getVersion(){
		return "Version = " + api_version;
	}
	
	@GET
	@Path("pp/{userid}")
	public String getUser(@PathParam("userid") String userId){
		return "Path Parameter Userid = " + userId;
	}

}
