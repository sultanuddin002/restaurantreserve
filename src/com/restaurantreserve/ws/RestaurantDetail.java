package com.restaurantreserve.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

@Path("/restaurantdetail")
public class RestaurantDetail {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray restaurantDetail(@QueryParam("rid") int rId) throws JSONException, Exception {
		JSONArray array = new JSONArray();
		try {
			array = DBConnection.getRestaurantDetail(rId);
		} catch (JSONException e) {
			throw e;

		} catch (Exception e) {
			throw e;
		}
		return array;
	}

}
