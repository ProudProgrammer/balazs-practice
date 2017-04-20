package hu.gaborbalazs.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {
		
		System.out.println("Begin\n");
		
		Path path = Paths.get(new URI("file:///c:/GaborBalazs/WorkspaceFolder/SpringToolSuiteWS/balazs-practice/test.txt"));
		
		System.out.println("isAbsolute(): " + path.isAbsolute());
		System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
		try (BufferedReader is = new BufferedReader(new FileReader(path.toFile()))) {
			System.out.println("ready(): " + is.ready());
			is.mark((int)(path.toFile().length()+1));
			String line = "";
			while((line = is.readLine()) != null) {
				System.out.print(line);
			}
			System.out.println();
			System.out.println("ready(): " + is.ready());
			while((line = is.readLine()) != null) {
				System.out.print(line);
			}
			is.reset();
			System.out.println("ready(): " + is.ready());
			while((line = is.readLine()) != null) {
				System.out.print(line);
			}
			System.out.println();
			is.reset();
			is.lines().forEach(System.out::println);
		}
		
		System.out.println("\nEnd");

	}

}