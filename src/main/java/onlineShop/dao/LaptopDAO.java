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

import onlineShop.models.Laptop;

@Component
public class LaptopDAO {
	
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
	
	public List<Laptop> getAllLaptops() {
		List<Laptop> laptops = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			String SQL = "Select * from \"Laptops\"";
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				Laptop laptop = new Laptop();
				
				laptop.setId(resultSet.getInt("id"));
				laptop.setManufacturer(resultSet.getString("manufacturer"));
				laptop.setModel(resultSet.getString("model"));
				laptop.setScreen(resultSet.getDouble("screen"));
				laptop.setProcessor(resultSet.getDouble("processor"));
				laptop.setRam(resultSet.getInt("ram"));
				laptop.setRamGpu(resultSet.getInt("ramGpu"));
				laptop.setCountUsb(resultSet.getInt("countUsb"));
				laptop.setCost(resultSet.getDouble("cost"));
				
				laptops.add(laptop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return laptops;
	}
	
	public Laptop getLaptopById(int id) {
		Laptop laptop = new Laptop();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from \"Laptops\" where id =?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				laptop.setManufacturer(resultSet.getString("manufacturer"));
				laptop.setModel(resultSet.getString("model"));
				laptop.setScreen(resultSet.getDouble("screen"));
				laptop.setProcessor(resultSet.getDouble("processor"));
				laptop.setRam(resultSet.getInt("ram"));
				laptop.setRamGpu(resultSet.getInt("ramGpu"));
				laptop.setCountUsb(resultSet.getInt("countUsb"));
				laptop.setCost(resultSet.getDouble("cost"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return laptop;
	}
	
	public void deleteLaptop(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Delete from \"Laptops\" where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateLaptop(Laptop laptop, int id) {
		System.out.println(laptop.getCountUsb());
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("Update \"Laptops\" Set manufacturer=?, model=?, screen=?, ram=?, processor=?, \"ramGpu\"=?, \"countUsb\"=?, cost=? where id=?");
			
			preparedStatement.setString(1, laptop.getManufacturer());
			preparedStatement.setString(2, laptop.getModel());
			preparedStatement.setDouble(3, laptop.getScreen());
			preparedStatement.setInt(4, laptop.getRam());
			preparedStatement.setDouble(5, laptop.getProcessor());
			preparedStatement.setInt(6, laptop.getRamGpu());
			preparedStatement.setInt(7, laptop.getCountUsb());
			preparedStatement.setDouble(8, laptop.getCost());
			preparedStatement.setInt(9, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createLaptop(Laptop laptop) {
		System.out.println(laptop.getRamGpu());
		try {
			PreparedStatement preparedStatement = 
					connection.prepareStatement("Insert into \"Laptops\"(manufacturer, model, screen, ram, processor, \"ramGpu\", \"countUsb\", cost) values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, laptop.getManufacturer());
			preparedStatement.setString(2, laptop.getModel());
			preparedStatement.setDouble(3, laptop.getScreen());
			preparedStatement.setInt(4, laptop.getRam());
			preparedStatement.setDouble(5, laptop.getProcessor());
			preparedStatement.setInt(6, laptop.getRamGpu());
			preparedStatement.setInt(7, laptop.getCountUsb());
			preparedStatement.setDouble(8, laptop.getCost());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
