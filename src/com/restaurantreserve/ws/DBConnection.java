package com.restaurantreserve.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class DBConnection {

	/*
	 * Method to create DB Connection
	 */

	/**
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("finally")
	public static Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName(Constants.dbClass);
			con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser,
					Constants.dbPassword);
		} catch (Exception e) {

		} finally {
			return con;
		}
	}

	/*
	 * Method to get list of resturant name as your preferences (type of res,
	 * name of res, area_location of res)
	 */

	/**
	 * @param typeOfRes
	 * @param nameOfRes
	 * @param areaOfLocation
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public static JSONArray getRestaurantList(String typeOfRes, String nameOfRes,
			String areaOfLocation) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantList(typeOfRes, nameOfRes, areaOfLocation);
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return array;

	}

	public static JSONArray getRestaurantList(String anySingleQuery, int stringPosition)
			throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();

			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantList(anySingleQuery, stringPosition);
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return array;
	}

	public static JSONArray getRestaurantList(String firstString, String secondString,
			int stringPosition1, int stringPosition2) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();

			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantList(firstString, secondString, stringPosition1,
					stringPosition2);
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return array;
	}

	public static JSONArray getRestaurantList() throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantList();
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return array;

	}

	public static JSONArray getRestaurantDetail(int restaurantId) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantDetail(restaurantId);
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return array;

	}


	public static String setUserData(String fullName, String phoneNumber, String email,
			String comment, String date, String time, String partySize, int restaurantId,
			String restaurantName) throws Exception, SQLException {
		String response = new String();
		boolean success = false;
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.setUserData(fullName, phoneNumber, email, comment);
			int value = statement.executeUpdate(query);
			if (value != 0) {
				success = true;
				response = "success";
			}
//			response = Utility.constructJSON("Success", success);

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return response;

	}


	public static String setRestaurantBooking(String date, String time, String partySize,
			String fullName, String phoneNumber, int restaurantId, String restaurantName)
			throws Exception, SQLException {
		String response = new String();
		boolean success = false;
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.setRestaurantBooking(date, time, partySize, fullName,
					phoneNumber, restaurantId, restaurantName);
			int value = statement.executeUpdate(query);
			if (value != 0) {
				success = true;
				response = "success";
			}
//			response = Utility.constructJSON("Success", success);

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return response;

	}

	public static JSONObject getBookingId(String date, String time, String phoneNumber)
			throws Exception, SQLException {
		String response = new String();
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		boolean isSuccess = false;
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getBookingId(date, time, phoneNumber);
			ResultSet resultSet = statement.executeQuery(query);
			array = Utility.convert(resultSet);
			if(array.length() == 1){
			object = array.getJSONObject(0);	
			}			

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			if (dbCon != null) {
				dbCon.close();
			}
			throw e;
		} finally {
			if (dbCon != null) {
				dbCon.close();
			}
		}
		return object;

	}
}
