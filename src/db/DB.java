package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnetion() {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}
	
	public static void closeStatent (Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				throw new DBException(e.getMessage());
			}
		}
	}
}
