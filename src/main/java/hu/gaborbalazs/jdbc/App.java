package hu.gaborbalazs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class App {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_test?useSSL=false", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM person3");
		
		rs.next();
		System.out.println(new Person(rs.getInt("id"), rs.getString("name"), LocalDateTime.parse(rs.getString("registration"), Person.FORMATTER)));
		rs.next();
		System.out.println(new Person(rs.getInt("id"), rs.getString("name"), LocalDateTime.parse(rs.getString("registration"), Person.FORMATTER)));
		rs.previous();
		System.out.println(new Person(rs.getInt("id"), rs.getString("name"), LocalDateTime.parse(rs.getString("registration"), Person.FORMATTER)));
		rs.afterLast();
		rs.previous();
		System.out.println(new Person(rs.getInt("id"), rs.getString("name"), LocalDateTime.parse(rs.getString("registration"), Person.FORMATTER)));
		
//		List<Person> personList = new ArrayList<>();
//		System.out.println("DB Rows:");
//		while(rs.next()) {
//			for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//				System.out.print(rs.getString(i) + ", ");
//			}
//			Person p = new Person(rs.getInt(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), Person.FORMATTER));
//			personList.add(p);
//			System.out.println();
//		}
//		System.out.println("Person List:");
//		personList.forEach(System.out::println);
		
//		Person p = new Person(33, "Steiner János", LocalDateTime.parse("2040-10-10 12:00:01.123456000", Person.FORMATTER));
//		System.out.println(p);
//		String sql = MessageFormat.format("INSERT INTO person4 VALUES ({0}, ''{1}'', ''{2}'')", p.getId(), p.getName(), p.getRegistration());
//		System.out.println(sql);
//		stmt.executeUpdate(sql);

		
//		Person p = new Person(10, "Steiner Ede", LocalDateTime.parse("2039-10-10 12:00:01.123456000", Person.FORMATTER));
//		System.out.println(p);
//		String sql = MessageFormat.format("INSERT INTO person2 VALUES ({0}, ''{1}'', ''{2}'')", p.getId(), p.getName(), p.getRegistration());
//		System.out.println(sql);
//		stmt.executeUpdate(sql);
	}
}
