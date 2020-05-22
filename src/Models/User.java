package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class User {
	private int id_user;
	private String first_name;
	private String second_name;
	private String birthday;
	private String info;
	private String image;
	
	public User(int id_user, String first_name, String second_name, String birthday, String info, String image) {
		super();
		this.id_user = id_user;
		this.first_name = first_name;
		this.second_name = second_name;
		this.birthday = birthday;
		this.info = info;
		this.image = image;
	}
	
	public static User getUser() {
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//регистрируем драйвер
			String url = "jdbc:mysql://localhost/VisitCard?serverTimezone="+TimeZone.getDefault().getID();
			Connection connect = DriverManager.getConnection(url, "root",""); 
			stmt = connect.createStatement();//создали объект для возможности делать запросы к базе данных
			rs = stmt.executeQuery("select * from users where id_user = 1");
			if(rs.next()) {//if берёт только первое значение
				user = new User(rs.getInt("id_user"), rs.getString("first_name"), rs.getString("second_name"), rs.getString("birthday"),
						rs.getString("info"), rs.getString("image"));
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return user;
		
		
	}

	public int getId_user() {
		return id_user;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getInfo() {
		return info;
	}

	public String getImage() {
		return image;
	}
	
 

}
