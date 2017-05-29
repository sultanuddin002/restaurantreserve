package com.restaurantreserve.ws;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Utility {

	/**
	 * Null check method
	 * 
	 * @param text
	 * @return
	 */

	public static boolean isNotNull(String text) {
		return text != null && text.trim().length() > 0 ? true : false;
	}

	/**
	 * Method to construct JSON
	 * 
	 * @param tag
	 * @param status
	 * @return
	 */

	public static String constructJSON(String tag, boolean status) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("tag", tag);
			jsonObject.put("status", new Boolean(status));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonObject.toString();
	}

	/**
	 * Method to construct JSON with error message
	 * 
	 * @param tag
	 * @param status
	 * @param err_msg
	 * @return
	 */
	public static String constructJSON(String tag, boolean status, String err_msg) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", status);
			obj.put("error_msg", err_msg);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return obj.toString();
	}

	public static JSONArray convert(ResultSet resultSet) throws SQLException, JSONException {
		JSONArray array = new JSONArray();
		ResultSetMetaData metaData = resultSet.getMetaData();

		while (resultSet.next()) {
			int nextColumn = metaData.getColumnCount();
			JSONObject jsonObject = new JSONObject();

			for (int i = 1; i < nextColumn + 1; i++) {
				String column_name = metaData.getColumnName(i);
				if (metaData.getColumnType(i) == Types.ARRAY) {
					jsonObject.put(column_name, resultSet.getArray(i));
				} else if (metaData.getColumnType(i) == Types.BIGINT) {
					jsonObject.put(column_name, resultSet.getInt(i));

				} else if (metaData.getColumnType(i) == Types.INTEGER) {
					jsonObject.put(column_name, resultSet.getInt(i));
				} else if (metaData.getColumnType(i) == Types.VARCHAR) {
					jsonObject.put(column_name, resultSet.getString(i));
				} else if (metaData.getColumnType(i) == Types.BOOLEAN) {
					jsonObject.put(column_name, resultSet.getBoolean(i));
				} else if (metaData.getColumnType(i) == Types.BLOB) {
					jsonObject.put(column_name, resultSet.getBlob(i));
				} else if (metaData.getColumnType(i) == Types.DOUBLE) {
					jsonObject.put(column_name, resultSet.getDouble(i));
				} else if (metaData.getColumnType(i) == Types.FLOAT) {
					jsonObject.put(column_name, resultSet.getFloat(i));
				} else if (metaData.getColumnType(i) == Types.NVARCHAR) {
					jsonObject.put(column_name, resultSet.getNString(i));
				} else if (metaData.getColumnType(i) == Types.TINYINT) {
					jsonObject.put(column_name, resultSet.getInt(i));
				} else if (metaData.getColumnType(i) == Types.SMALLINT) {
					jsonObject.put(column_name, resultSet.getInt(i));
				} else if (metaData.getColumnType(i) == Types.DATE) {
					jsonObject.put(column_name, resultSet.getDate(i));
				} else if (metaData.getColumnType(i) == Types.TIMESTAMP) {
					jsonObject.put(column_name, resultSet.getTimestamp(i));
				} else {
					jsonObject.put(column_name, resultSet.getObject(i));
				}
			}
			array.put(jsonObject);
		}
		return array;
	}

}
