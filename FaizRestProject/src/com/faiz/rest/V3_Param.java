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
	@Path("/pp/{userid}")
	@Produces (MediaType.TEXT_HTML)
	public String getUser(@PathParam("userid") String userId){
		//http://localhost:8080/FaizRestProject/api/v3/status/pp/faiz
		return "Path Parameter Userid = " + userId;
	}
	
	@GET
	@Path("/qp")
	@Produces (MediaType.TEXT_HTML)
	public String getQueryParam( @QueryParam("fname") String firstName){
		
		//http://localhost:8080/FaizRestProject/api/v3/status/qp?fname=faiz
		return "Query Param FirstName =" + firstName;
	}
	
	
	@GET
	@Path("/hp")
	@Produces (MediaType.TEXT_HTML)
	public String getHeaderParam( @HeaderParam("Host") String clientName){
		
		//http://localhost:8080/FaizRestProject/api/v3/status/hp
		return "Header Param client name =" + clientName;
	}
	
	@POST
	@Path("/fp")
	public String getFormParam( @FormParam("username") String username,
			@CookieParam ("email") String cook){
		
		System.out.println(" Form Parameter = " + username);
		//http://localhost:8080/FaizRestProject/api/v3/status/hp
		return "Form Param user name =" + username + "  Cookie email = " + cook;
	}


}
