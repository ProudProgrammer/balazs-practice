package hu.gaborbalazs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_test?useSSL=false", "root", "root");
		Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT * FROM person2");
		List<Person> personList = new ArrayList<>();
		System.out.println("DB Rows:");
		while(rs.next()) {
			for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.print(rs.getString(i) + ", ");
			}
			Person p = new Person(rs.getInt(1), rs.getString(2), LocalDateTime.parse(rs.getString(3), Person.FORMATTER));
			personList.add(p);
			p = new Person(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime());
			personList.add(p);
			System.out.println();
		}
		System.out.println("Person List:");
		personList.forEach(System.out::println);
		
//		Person p = new Person(6, "Steiner János", ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime());
//		System.out.println(p);
//		String sql = MessageFormat.format("INSERT INTO person2 VALUES ({0}, ''{1}'', ''{2}'')", p.getId(), p.getName(), p.getRegistration());
//		System.out.println(sql);
//		stmt.executeUpdate(sql);

		
		Person p = new Person(10, "Steiner Ede", LocalDateTime.parse("2039-10-10 12:00:01.123456000", Person.FORMATTER));
		System.out.println(p);
		String sql = MessageFormat.format("INSERT INTO person2 VALUES ({0}, ''{1}'', ''{2}'')", p.getId(), p.getName(), p.getRegistration());
		System.out.println(sql);
		stmt.executeUpdate(sql);
	}
}
