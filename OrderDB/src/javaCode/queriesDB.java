package javaCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/queryDb")
public class queriesDB  extends HttpServlet{



	public void doPost (HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException 
	{
		InputStream inputstr = request.getInputStream();
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputstr, writer, "UTF-8");
		String input = writer.toString();

		try {
			String toSend = getRest(input);
			System.out.println(toSend);
			PrintWriter resp = response.getWriter();
			response.setContentType("text/html");
			resp.write(toSend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://dbprojectinstance.cedhv367x2qc.us-west-2.rds.amazonaws.com:3306/dbproject","mahesh","mahesh9128");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static String getRest(String input){
		JSONObject jsonObj;
		String result=null;
		try {
			jsonObj = new JSONObject(input);
			int queryno = (int) jsonObj.getInt("queryno");
			switch(queryno) {
			case 1 : result= getquery1(input);
			break;
			case 2 : result= getquery2(input);
			break; 
			case 3 : result= getquery3(input);
			break; 
			case 4 : result= getquery4(input);
			break; 
			case 5 : result= getquery5();
			break; 
			case 6: result= getquery6(input);
			break; 
			case 7: result= getquery7();
			break; 
			case 8: result= getquery8();
			break; 
			case 9: result= getquery9(input);
			break; 
			case 10: result= getquery10(input);
			break; 
			case 11: result= getquery11(input);
			break; 
			default : break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	public static String getquery1(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query1);
			stmt.setString(1, "%"+(String) jsonObj.getString("area")+"%");
			stmt.setString(2, (String) jsonObj.getString("cuisine"));
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Name</th><th>Cuisine</th><th>Status</th><th>Addr</th><th>OpenTime</th><th>CloseTime</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("cuisine")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("address")+"</td><td>"+rset.getString("openTime")+"</td><td>"+rset.getString("closeTime")+"</td></tr>");

			}else{
				return "No data found for the search criteria !!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("cuisine")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("address")+"</td><td>"+rset.getString("openTime")+"</td><td>"+rset.getString("closeTime")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery2(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null,stmt2=null;
		ResultSet rset=null;
		try {
			stmt2= conn.prepareStatement("SET time_zone = '-06:00';");
			stmt2.executeQuery();
			stmt = conn.prepareStatement(QueryFile.query2);
			stmt.setString(1, (String) jsonObj.getString("cuisine2"));
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Name</th><th>Cuisine</th><th>Status</th><th>Addr</th><th>OpenTime</th><th>CloseTime</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("cuisine")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("address")+"</td><td>"+rset.getString("openTime")+"</td><td>"+rset.getString("closeTime")+"</td></tr>");
			}else{
				return "No "+jsonObj.getString("cuisine2")+" restaurants open!!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("cuisine")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("address")+"</td><td>"+rset.getString("openTime")+"</td><td>"+rset.getString("closeTime")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No "+jsonObj.getString("cuisine2")+" restaurants open!!";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery3(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query3);
			stmt.setString(1,(String) jsonObj.getString("cuisine3"));
			stmt.setInt(2, Integer.parseInt(jsonObj.getString("price3")));
			rset = stmt.executeQuery();
			
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Name</th><th>ComboId</th><th>Appetizer</th><th>MainCourse</th><th>Dessert</th><th>Price</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("appetizer")+"</td><td>"+rset.getString("mainCourse")+"</td><td>"+rset.getString("dessert")+"</td><td>"+rset.getString("price")+"</td></tr>");
			}else{
				return "No data found for the search criteria !!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("appetizer")+"</td><td>"+rset.getString("mainCourse")+"</td><td>"+rset.getString("dessert")+"</td><td>"+rset.getString("price")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery4(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query4);
			stmt.setString(1,(String) jsonObj.getString("name4"));
			stmt.setInt(2, Integer.parseInt(jsonObj.getString("comboid4")));
			stmt.setString(3,(String) jsonObj.getString("day4"));
			rset = stmt.executeQuery();
			
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Name</th><th>ComboId</th><th>Discount</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("discount")+"</td></tr>");
			}else{
				return "No discount on this day!!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("name")+"</td><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("discount")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No discount on this day!!";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery5() throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query5);
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Name</th><th>Rating</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("RESTAURANT")+"</td><td>"+rset.getString("OVERALL_RATING")+"</td></tr>");

			}else{
				return "No data found for the search criteria !!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("RESTAURANT")+"</td><td>"+rset.getString("OVERALL_RATING")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery6(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query6);
			stmt.setInt(1,Integer.parseInt(jsonObj.getString("order6")));
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Customer Name</th><th>Address</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("fname")+"</td><td>"+rset.getString("address")+"</td></tr>");
			}else{
				return "No data found for the search criteria !! ";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("fname")+"</td><td>"+rset.getString("address")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery7() throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null,stmtorder=null;
		ResultSet rset=null,rsetorder=null;
		try {
			stmtorder= conn.prepareStatement(QueryFile.query7_2);
			stmt = conn.prepareStatement(QueryFile.query7);
			rset = stmt.executeQuery();
			rsetorder=stmtorder.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Number of Pending orders</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("No_of_pending_orders")+"</td></tr>");
				resultStr.append("</tbody></table>");
			}else{
				return "No data found for the search criteria !!";
			}
			if(rsetorder.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Order Numbers of pending Orders</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rsetorder.getString("orderNum")+"</td></tr>");
			}
			while(rsetorder.next()){
				resultStr.append("<tr><td>"+rsetorder.getString("orderNum")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery8() throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query8);
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Restaurant Name</th><th>Rating</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("RESTAURANT_NAME")+"</td><td>"+rset.getString("Rating")+"</td></tr>");

			}else{
				return "No data found for the search criteria !!";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("RESTAURANT_NAME")+"</td><td>"+rset.getString("Rating")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery9(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query9);
			stmt.setString(1,"%"+jsonObj.getString("addr9")+"%");
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Combo ID</th><th>Customer ID</th><th>Order Num</th><th>Restaurant ID</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("custId")+"</td><td>"+rset.getString("orderNum")+"</td><td>"+rset.getString("restId")+"</td></tr>");
			}else{
				return "No data found for the search criteria !! ";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("comboId")+"</td><td>"+rset.getString("custId")+"</td><td>"+rset.getString("orderNum")+"</td><td>"+rset.getString("restId")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery10(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareStatement(QueryFile.query10);
			stmt.setString(1,jsonObj.getString("name10"));
			rset = stmt.executeQuery();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Customer ID</th><th>Restaurant Name</th><th>Comment</th><th>Rating</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("custId")+"</td><td>"+rset.getString("name")+"</td><td>"+rset.getString("comment")+"</td><td>"+rset.getString("rating")+"</td></tr>");
			}else{
				return "No data found for the search criteria !! ";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("custId")+"</td><td>"+rset.getString("name")+"</td><td>"+rset.getString("comment")+"</td><td>"+rset.getString("rating")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
	
	public static String getquery11(String input) throws SQLException, JSONException{
		System.out.println("Welcome to db test!!");
		JSONObject jsonObj = new JSONObject(input);
		StringBuilder resultStr = new StringBuilder();
		Connection conn = getConnection();
		CallableStatement stmt = null;
		ResultSet rset=null;
		try {
			stmt = conn.prepareCall(QueryFile.query11);
			stmt.setInt(1,Integer.parseInt(jsonObj.getString("order11")));
			stmt.execute();
			rset = stmt.getResultSet();
			if(rset.next()){
				resultStr.append("<table class=\"table\">");
				resultStr.append("<thead><tr><th>Order Num</th><th>Status</th><th>Cust ID</th><th>Rest ID</th><th>Combo ID</th></tr></thead>");
				resultStr.append("<tbody>");
				resultStr.append("<tr><td>"+rset.getString("orderNum")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("custId")+"</td><td>"+rset.getString("restId")+"</td><td>"+rset.getString("comboId")+"</td></tr>");
			}else{
				return "No data found for the search criteria !! ";
			}
			while(rset.next()){
				resultStr.append("<tr><td>"+rset.getString("orderNum")+"</td><td>"+rset.getString("status")+"</td><td>"+rset.getString("custId")+"</td><td>"+rset.getString("restId")+"</td><td>"+rset.getString("comboId")+"</td></tr>");
			}
			resultStr.append("</tbody></table>");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "No data found for the search criteria !! ";
		}
		finally{
			conn.close();
		}
		return resultStr.toString();
	} 
}
