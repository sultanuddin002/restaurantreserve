package com.restaurantreserve.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

@Path("/getrestaurantdetail")
public class GetRestaurantDetail {

	// Http Get Method
	@GET
	// Path: http://localhost/<app-folder-name>/getrestaurantdetail
	@Path("/get")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are:
	// http://localhost/<app-folder-name>/getrestaurantdetail/get?resid=1

	public JSONArray searchNow(@QueryParam("resid") int restaurantId)
			throws JSONException, Exception {
		JSONArray array = new JSONArray();

		try {
			array = DBConnection.getRestaurantDetail(restaurantId);

		} catch (JSONException e) {
			throw e;

		} catch (Exception e) {
			throw e;
		}
		return array;
	}
}
