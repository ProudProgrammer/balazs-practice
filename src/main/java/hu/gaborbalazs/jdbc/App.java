package hu.gaborbalazs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_test?useSSL=false", "root", "root");
		Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_FORWARD_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT * FROM person2");
		List<Person> personList = new ArrayList<>();
		System.out.println("DB Rows:");
		while(rs.next()) {
			for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.print(rs.getString(i) + ", ");
			}
			Person p = new Person(rs.getInt(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), Person.FORMATTER));
			personList.add(p);
			System.out.println();
		}
		System.out.println("Person List:");
		personList.forEach(System.out::println);
	}
}
