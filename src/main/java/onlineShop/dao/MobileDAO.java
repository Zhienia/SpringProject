package onlineShop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import onlineShop.models.Mobile;

@Component
public class MobileDAO {

	private static final String URL = "jdbc:postgresql://localhost:5432/onlineShop";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "root";
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Mobile> getAllMobiles() {
		List<Mobile> mobiles = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			String SQL = "Select * from \"Mobiles\"";
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				Mobile mobile = new Mobile();
				
				mobile.setId(resultSet.getInt("id"));
				mobile.setManufacturer(resultSet.getString("manufacturer"));
				mobile.setModel(resultSet.getString("model"));
				mobile.setScreen(resultSet.getDouble("screen"));
				mobile.setRam(resultSet.getInt("ram"));
				mobile.setProcessor(resultSet.getDouble("processor"));
				mobile.setCamera(resultSet.getInt("camera"));
				mobile.setCost(resultSet.getDouble("cost"));
				
				mobiles.add(mobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mobiles;
	}
	
	
	public Mobile getMobileById(int id) {
		
		Mobile mobile = new Mobile();
		
		try {
			Statement statement = connection.createStatement();
			String SQL = "Select * from \"Mobiles\" where id =" + id;
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				mobile.setId(resultSet.getInt("id"));
				mobile.setManufacturer(resultSet.getString("manufacturer"));
				mobile.setModel(resultSet.getString("model"));
				mobile.setScreen(resultSet.getDouble("screen"));
				mobile.setRam(resultSet.getInt("ram"));
				mobile.setProcessor(resultSet.getDouble("processor"));
				mobile.setCamera(resultSet.getInt("camera"));
				mobile.setCost(resultSet.getDouble("cost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(mobile.getManufacturer());
		return mobile;
	}
	
	
	public void deleteMobile(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from \"Mobiles\" where id =?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMobile(Mobile mobile, int id) {
		try {
			System.out.println(id);
			System.out.println(mobile.getScreen());
			PreparedStatement preparedStatement = 
					connection.prepareStatement("Update \"Mobiles\" Set manufacturer=?, model=?, screen=?, ram=?, processor=?, camera=?, cost=? where id=?");
			
			preparedStatement.setString(1, mobile.getManufacturer());
			preparedStatement.setString(2, mobile.getModel());
			preparedStatement.setDouble(3, mobile.getScreen());
			preparedStatement.setInt(4, mobile.getRam());
			preparedStatement.setDouble(5, mobile.getProcessor());
			preparedStatement.setInt(6, mobile.getCamera());
			preparedStatement.setDouble(7, mobile.getCost());
			preparedStatement.setInt(8, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createMobile(Mobile mobile) {
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("Insert into \"Mobiles\"(manufacturer, model, screen, ram, processor, camera, cost) values(?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, mobile.getManufacturer());
			preparedStatement.setString(2, mobile.getModel());
			preparedStatement.setDouble(3, mobile.getScreen());
			preparedStatement.setInt(4, mobile.getRam());
			preparedStatement.setDouble(5, mobile.getProcessor());
			preparedStatement.setInt(6, mobile.getCamera());
			preparedStatement.setDouble(7, mobile.getCost());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
