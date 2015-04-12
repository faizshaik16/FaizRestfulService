package com.faiz.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.*;

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
		JSONArray jsonArray = new JSONArray();

	    try
	    {

	    	conn= AccessDB.getAccessDBConnection();
	        Statement stment = conn.createStatement();
	        String qry = "SELECT * FROM Emp";

	        ResultSet rs = stment.executeQuery(qry);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        while(rs.next())
	        {
	        	int columns = rsmd.getColumnCount();
	        	JSONObject jsonObject = new JSONObject();
	        	for(int i=1 ; i < columns; i++){
	        		String columnName = rsmd.getColumnName(i);
	        		String columnVal = rs.getString(columnName);
	        		jsonObject.put(columnName, columnVal);
	        		System.out.println(columnName +"  " +  columnName);
	        	}
	     
	        	jsonArray.put(jsonObject);
	            
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

	    return "DB Data = " +  jsonArray;
	}
}
