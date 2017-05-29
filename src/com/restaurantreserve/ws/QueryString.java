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

//	for any single search query
	
	/**
	 * @param anySingleQuery
	 * @param stringPosition
	 * @return
	 */
	public static String getResturantList(String anySingleQuery, int stringPosition) {
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
	public static String getResturantList(String firstString, String secondString,
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

}
