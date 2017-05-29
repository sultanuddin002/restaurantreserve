package com.restaurantreserve.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

@Path("/searchrestaurant")
public class SearchRestaurant {

	// Http Get Method
	@GET
	// Path: http://localhost/<app-folder-name>/searchrestaurant
	@Path("/searchnow")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are:
	// http://localhost/<app-folder-name>/searchrestaurant/searchnow?typeofres=mehmood&nameofres=jama&areaofres=gulshan

	public JSONArray searchNow(@QueryParam("typeofres") String typeOfRes, @QueryParam("nameofres") String nameOfRes,
			@QueryParam("areaofloc") String areaOfLocation) throws JSONException, Exception {
		JSONArray array = new JSONArray();
		if (Utility.isNotNull(typeOfRes) && Utility.isNotNull(nameOfRes) && Utility.isNotNull(areaOfLocation)) {
			try {
				array = DBConnection.getRestaurantList(typeOfRes, nameOfRes, areaOfLocation);

			} catch (JSONException e) {
				throw e;

			} catch (Exception e) {
				throw e;
			}
		}
		return array;
	}
	
	// To get all search values
	@GET
	@Path("/searchall")
	@Produces(MediaType.APPLICATION_JSON)
	
	public JSONArray searchNow() throws JSONException, Exception {
		JSONArray array = new JSONArray();
			try {
				array = DBConnection.getRestaurantList();

			} catch (JSONException e) {
				throw e;

			} catch (Exception e) {
				throw e;
			}
		return array;
	}
	
	
	// test the REST WS
	@GET
	@Path("/welcome")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello() {
		return "Howdey Partner";
	}

}