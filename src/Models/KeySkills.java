package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class KeySkills {
	private String skill_description;
	private int id;
	private int id_users;
	public KeySkills(String skill_description, int id, int id_users) {
		super();
		this.skill_description = skill_description;
		this.id = id;
		this.id_users = id_users;
	}
	
	public static KeySkills getKeySkills() {
		KeySkills keySkills = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// регистрируем драйвер
			String url = "jdbc:mysql://localhost/VisitCard?serverTimezone=" + TimeZone.getDefault().getID();
			Connection connect = DriverManager.getConnection(url, "root", "");
			stmt = connect.createStatement();// создали объект для возможности делать запросы к базе данных
			rs = stmt.executeQuery("select * from key_skills where id_user = 1");
			if (rs.next()) {// if берёт только первое значение
				keySkills = new KeySkills(rs.getString("skill_description"), rs.getInt("id"), rs.getInt("id_user"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		return keySkills;
	}

	public int getId() {
		return id;
	}

	public String getSkill_description() {
		return skill_description;
	}

	public int getId_users() {
		return id_users;
	}

}
