package com.restaurantreserve.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONArray;

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
			con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPassword);
		} catch (Exception e) {
			// TODO: handle exception
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

	public static JSONArray getRestaurantList(String typeOfRes, String nameOfRes, String areaOfLocation)
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

	public static JSONArray getResturantList(String anySingleQuery, int stringPosition) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getResturantList(anySingleQuery, stringPosition);
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

	public static JSONArray getResturantList(String firstString, String secondString, int stringPosition1,
			int stringPosition2) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getResturantList(firstString, secondString, stringPosition1, stringPosition2);
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

	public static JSONArray getRestaurantDetail(int rId) throws Exception, SQLException {
		JSONArray array = new JSONArray();
		Connection dbCon = null;
		try {
			try {
				dbCon = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Statement statement = dbCon.createStatement();
			String query = QueryString.getRestaurantDetail(rId);
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
}
