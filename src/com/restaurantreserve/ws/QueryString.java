package com.restaurantreserve.ws;

public class QueryString {

	// for all result query

	/**
	 * @return
	 */
	public static String getRestaurantList() {

		String query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info on restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id";

		return query;
	}

	// for any single search query

	/**
	 * @param anySingleQuery
	 * @param stringPosition
	 * @return
	 */
	public static String getRestaurantList(String anySingleQuery, int stringPosition) {
		String query = new String();
		switch (stringPosition) {
		case 0:
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "on restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE restaurant_info.r_type_of_res "
					+ "LIKE '%" + anySingleQuery + "%'";
			break;
		case 1:
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "on restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE restaurant_info.r_name "
					+ "LIKE '%" + anySingleQuery + "%'";
			break;
		case 2:
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "on restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE "
					+ "restaurant_address.r_area_address LIKE '%" + anySingleQuery + "%'";
			break;
		default:
			break;
		}

		return query;
	}
	// for any 2 search query

	/**
	 * @param firstString
	 * @param secondString
	 * @param stringPosition1
	 * @param stringPosition2
	 * @return
	 */
	public static String getRestaurantList(String firstString, String secondString,
			int stringPosition1, int stringPosition2) {
		// there are 3 possibility like of below
		String query = new String();

		// 1. res type + res name
		if (stringPosition1 == 0 && stringPosition2 == 1) {
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "ON restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE "
					+ "restaurant_info.r_type_of_res LIKE '%" + firstString
					+ "%' AND restaurant_info.r_name LIKE '%" + secondString + "%'";
		}
		// 2. res type + res location
		if (stringPosition1 == 0 && stringPosition2 == 2) {
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "ON restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE "
					+ "restaurant_info.r_type_of_res LIKE '%" + firstString
					+ "%' AND restaurant_address.r_area_address LIKE '%" + secondString + "%'";
		}
		// 3. res name + res location
		if (stringPosition1 == 1 && stringPosition2 == 2) {
			query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
					+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
					+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
					+ "ON restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE "
					+ "restaurant_info.r_name LIKE '%" + firstString
					+ "%' AND restaurant_address.r_area_address LIKE '%" + secondString + "%'";
		}

		return query;
	}

	// for all search query

	/**
	 * @param typeOfRes
	 * @param nameOfRes
	 * @param areaOfLocation
	 * @return
	 */
	public static String getRestaurantList(String typeOfRes, String nameOfRes,
			String areaOfLocation) {

		String query = "SELECT restaurant_info.r_id, restaurant_info.r_name, restaurant_address.r_address, "
				+ "restaurant_contact_info.r_phone_number FROM restaurant_info INNER JOIN restaurant_address "
				+ "ON restaurant_address.restaurant_info_r_id=restaurant_info.r_id INNER JOIN restaurant_contact_info "
				+ "ON restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id WHERE "
				+ "restaurant_info.r_type_of_res LIKE '%" + typeOfRes
				+ "%' AND restaurant_info.r_name LIKE '%" + nameOfRes
				+ "%' AND restaurant_address.r_area_address LIKE '%" + areaOfLocation + "%'";

		return query;
	}

	// get restaurant details by passing restaurant id

	/**
	 * 
	 * @param restaurantId
	 * @return
	 */
	public static String getRestaurantDetail(int restaurantId) {
		String query = "SELECT restaurant_info.r_name, restaurant_info.r_type_of_res, restaurant_info.r_days_open_per_week,"
				+ " restaurant_info.r_rating, restaurant_info.r_menu_uploaded, restaurant_info.r_has_special_offer,"
				+ " restaurant_address.r_address, restaurant_address.r_area_address, restaurant_address.r_gps_loc, "
				+ "restaurant_contact_info.r_email, restaurant_contact_info.r_facebook_page_link,"
				+ "restaurant_contact_info.r_phone_number, restaurant_contact_info.r_website "
				+ "FROM restaurant_info INNER JOIN restaurant_address ON "
				+ "restaurant_address.restaurant_info_r_id=restaurant_info.r_id "
				+ "INNER JOIN restaurant_contact_info ON restaurant_contact_info.restaurant_info_r_id=restaurant_info.r_id "
				+ "WHERE restaurant_info.r_id='" + restaurantId + "'";

		return query;
	}


	public static String setUserData(String fullName, String phoneNumber, String email,
			String comment) {
		String query = "INSERT INTO user_data VALUES (null,'" + fullName + "','" + phoneNumber
				+ "','" + email + "','" + comment + "');";

		return query;
	}

	public static String setRestaurantBooking(String date, String time, String partySize,
			String fullName, String phoneNumber, int restaurantId, String restaurantName) {
		String query = "INSERT INTO user_booking VALUES ('" + time + "','" + date + "',false,"
				+ partySize + ",null,false,false,false,"
				+ "(SELECT user_data.u_id FROM user_data WHERE user_data.u_full_name = '" + fullName
				+ "' AND user_data.u_phone_number = '" + phoneNumber + "')" + ",'" + phoneNumber
				+ "'," + restaurantId + ",'" + restaurantName + "');";
		
		return query;
	}

	public static String getBookingId(String date, String time, String phoneNumber) {
		String query = "SELECT user_booking.b_no FROM user_booking WHERE user_booking.b_date LIKE '"
				+ date + "' AND user_booking.b_time LIKE '" + time + "' AND "
				+ "user_booking.user_data_u_phone_number LIKE '" + phoneNumber + "'";

		return query;
	}
}
