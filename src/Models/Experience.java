package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;

public class Experience {
	private int id;
	private String company_name;
	private String position;
	private String description;
	private String day_in;
	private String day_out;
	private int id_user;

	public Experience(int id, String company_name, String position, String description, String day_in, String day_out,
			int id_user) {
		super();
		this.id = id;
		this.company_name = company_name;
		this.position = position;
		this.description = description;
		this.day_in = day_in;
		this.day_out = day_out;
		this.id_user = id_user;
	}

	public static ArrayList<Experience> getExperience() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Experience> experiens = new ArrayList<Experience>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// регистрируем драйвер
			String url = "jdbc:mysql://localhost/VisitCard?serverTimezone=" + TimeZone.getDefault().getID();
			Connection connect = DriverManager.getConnection(url, "root", "");
			stmt = connect.createStatement();// создали объект для возможности делать запросы к базе данных
			rs = stmt.executeQuery("select * from experience where id_user = 1");
			while (rs.next()) {// if берёт только первое значение
				Experience Experience = new Experience(rs.getInt("id"), rs.getString("company_name"),
						rs.getString("position"), rs.getString("description"), rs.getString("day_in"),
						rs.getString("day_out"), rs.getInt("id_user"));
				System.out.println("test2");
				experiens.add(Experience);
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

		return experiens;

	}

	public int getId() {
		return id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public String getPosition() {
		return position;
	}

	public String getDescription() {
		return description;
	}

	public String getDay_in() {
		return day_in;
	}

	public String getDay_out() {
		return day_out;
	}

	public int getId_user() {
		return id_user;
	}

}
