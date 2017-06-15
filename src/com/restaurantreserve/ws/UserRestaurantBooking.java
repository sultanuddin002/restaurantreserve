package com.restaurantreserve.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/setrestaurantbooking")
public class UserRestaurantBooking {

	// Http Get Method
	@GET
	// Path: http://localhost/<app-folder-name>/setrestaurantbooking
	@Path("/set")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON)
	// Query parameters are:
	// http://localhost/<app-folder-name>/setrestaurantbooking/set?resid=1

	public JSONObject SetRestaurantBooking(@QueryParam("fullname") String fullName,
			@QueryParam("phonenumber") String phoneNumber, @QueryParam("email") String email,
			@QueryParam("comment") String comment, @QueryParam("date") String date,
			@QueryParam("time") String time, @QueryParam("partysize") String partySize,
			@QueryParam("restaurantid") int restaurantId,
			@QueryParam("restaurantname") String restaurantName) throws JSONException, Exception {
		JSONObject jsonObject = new JSONObject();
		String newString = new String();
		String otherString = new String();
		try {
			newString = DBConnection.setUserData(fullName, phoneNumber, email, comment, date, time,
					partySize, restaurantId, restaurantName);
			otherString = DBConnection.setRestaurantBooking(date, time, partySize, fullName,
					phoneNumber, restaurantId, restaurantName);
			if (newString.contains("success") && otherString.contains("success")) {
				jsonObject = DBConnection.getBookingId(date, time, phoneNumber);
			} else{
				jsonObject.put("error", false);
			}
		} catch (JSONException e) {
			throw e;

		} catch (Exception e) {
			throw e;
		}
		return jsonObject;
	}

}
