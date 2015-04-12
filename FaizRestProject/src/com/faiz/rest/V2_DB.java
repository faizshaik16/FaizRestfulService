package com.faiz.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.faiz.conn.AccessDB;

@Path("/v2/status")
public class V2_DB {

	
	private static final String api_version ="2.0";
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String getMessage(){
		return "<p> This is Faiz Rest Service Access Database to get the data </p>";
	}
	
	@Path("/version")
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String secondaryPath(){
		return " Version = " + api_version ;
	}
	
	
	@Path("/empdb")
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String getEmpData(){
		Connection conn= null;

	    try
	    {

	    	conn= AccessDB.getAccessDBConnection();
	        Statement stment = conn.createStatement();
	        String qry = "SELECT * FROM Emp";

	        ResultSet rs = stment.executeQuery(qry);
	        while(rs.next())
	        {
	            String id    = rs.getString("EmpId") ;
	            String fname = rs.getString("FirstName");

	            System.out.println(id + fname);
	        }
	    }
	    catch(Exception err)
	    {
	        System.out.println(err);
	    }
	    finally{
	    	try{
	    		if (conn != null){
		    		conn.close();
		    	}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    }//end of finally block

	    return "DB Data";
	}
}
