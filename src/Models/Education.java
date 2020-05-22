package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class Education {
	private int id;
	private String university_name;
	private String faculty;
	private String specialization;
	private int date_in;
	private int date_out;
	private int user_id;
	public Education(int id, String university_name, String faculty, String specialization, int date_in, int date_out,
			int user_id) {
		super();
		this.id = id;
		this.university_name = university_name;
		this.faculty = faculty;
		this.specialization = specialization;
		this.date_in = date_in;
		this.date_out = date_out;
		this.user_id = user_id;
	}
	
	public static Education getEducation() {
		Education education = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// регистрируем драйвер
			String url = "jdbc:mysql://localhost/VisitCard?serverTimezone=" + TimeZone.getDefault().getID();
			Connection connect = DriverManager.getConnection(url, "root", "");
			stmt = connect.createStatement();// создали объект для возможности делать запросы к базе данных
			rs = stmt.executeQuery("select * from education where id_user = 1");
			if (rs.next()) {// if берёт только первое значение
				education = new Education(rs.getInt("id"), rs.getString("university_name"), rs.getString("faculty"),
						rs.getString("specialization"), rs.getInt("date_in"), rs.getInt("date_out"), rs.getInt("id_user"));
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
		System.out.println(education);
		return education;
	}

	public int getId() {
		return id;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getSpecialization() {
		return specialization;
	}

	public int getDate_in() {
		return date_in;
	}

	public int getDate_out() {
		return date_out;
	}

	public int getUser_id() {
		return user_id;
	}

}
