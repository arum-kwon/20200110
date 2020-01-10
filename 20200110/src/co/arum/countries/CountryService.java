package co.arum.countries;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class CountryService {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public CountryService() {
		dbconfigration(); //외부 설정 파일을 읽어옴
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	private void dbconfigration() {
		try {
			Reader reader = new FileReader("config/db.properties");
			Properties properties = new Properties();
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Object 잘 안 씀. 편리하지만 변수 타입을 가늠하기 어려움
	public abstract List<CountryDto> allSelect();
	public abstract CountryDto select(CountryDto dto);
	public abstract int insert(CountryDto dto);
	public abstract int update(CountryDto dto);
	public abstract int delete(CountryDto dto);
}
