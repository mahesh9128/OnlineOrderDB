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


@WebServlet("/loginDb")
public class loginDb  extends HttpServlet{



	public void doPost (HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("testing db");
		InputStream inputstr = request.getInputStream();
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputstr, writer, "UTF-8");
		String input = writer.toString();

		try {
			String toSend = authenticateUser(input);
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

	public static String authenticateUser(String logindetails){
		try {
			JSONObject logininfo =new JSONObject(logindetails);
			Connection conn = getConnection();
			PreparedStatement stmt = null;
			ResultSet rset=null;
			stmt = conn.prepareStatement(QueryFile.loginquery);
			stmt.setString(1,(String) logininfo.getString("userid"));
			stmt.setString(2,(String)logininfo.getString("pwd"));
			rset = stmt.executeQuery();
			if(rset.next()){
				return rset.getString("privilege");
			}
			else{
				return "Invalid password or user name!!";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid password or user name!!";
		}

	}



}
