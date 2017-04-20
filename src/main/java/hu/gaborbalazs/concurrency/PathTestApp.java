package hu.gaborbalazs.concurrency;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTestApp {

	public static void main(String[] args) throws URISyntaxException {
		
		Path p = Paths.get("test.txt");
		System.out.println("path: " + p);
		System.out.println("name0 :" + p.getName(0));
		System.out.println("namecount: " + p.getNameCount());
		System.out.println("parent: " + p.getParent());
		System.out.println("root: " + p.getRoot());
		System.out.println("absolute: " + p.isAbsolute());
		System.out.println("toabsolute: " + p.toAbsolutePath());
	}
}
