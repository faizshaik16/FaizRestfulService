package com.faiz.rest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class V1_Status {

	private static final String api_version ="1.0";
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String getMessage(){
		return "<p> This is Faiz Rest Service Get Method </p>";
	}
	
	@Path("/version")
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String secondaryPath(){
		return " Version = " + api_version ;
	}
	
	
	@Path("/welcome")
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String thirdMethod(){
		return " Welcome Faiz "  ;
	}
}
