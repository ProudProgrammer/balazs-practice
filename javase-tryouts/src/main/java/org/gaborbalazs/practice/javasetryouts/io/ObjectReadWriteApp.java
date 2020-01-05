package org.gaborbalazs.practice.javasetryouts.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObjectReadWriteApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		List<Somebody> somebodyList = new ArrayList<>();
		Somebody bob = new Somebody(ZonedDateTime.of(1970, 3, 18, 0, 0, 0, 0, ZoneId.of("Europe/Budapest")).toInstant(), "Bob");
		Somebody alice = new Somebody(ZonedDateTime.of(1981, 5, 21, 0, 0, 0, 0, ZoneId.of("Europe/Budapest")).toInstant(), "Alice");
		somebodyList.add(bob);
		somebodyList.add(alice);
		Somebody.setC('G');
		System.out.println(somebodyList);
		
		File file = new File("somebody.dat");
		write(somebodyList, file);
		System.out.println(read(file));
	}
	
	public static void write(List<Somebody> somebodyList, File file) throws FileNotFoundException, IOException {
		try (ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			for(Somebody s : somebodyList) {
				os.writeObject(s);
			}
		}
	}
	
	public static List<Somebody> read(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Somebody> list = new ArrayList<>();
		try (ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			while(true) {
				Object o = is.readObject();
				if(o instanceof Somebody) {
					list.add((Somebody)o);
				} else {
					System.out.println("The given file contains not just Somebody objects");
				}
			}
		} catch (EOFException e) {
			System.out.println("End of file is reached");
		}
		return list;
	}

}

class X{
	X() {
		System.out.println("hello X");
	}
}

class Somebody extends X implements Serializable {
	
	private static final long serialVersionUID = 3L;
	
	private Instant birth;
	private transient String name;
	private static char c;
	
	public Somebody(Instant birth, String name) {
		this.birth = birth;
		this.name = name;
	}
	
	public Instant getBirth() {
		return birth;
	}

	public void setBirth(Instant birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static char getC() {
		return c;
	}

	public static void setC(char c) {
		Somebody.c = c;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return MessageFormat.format("[Somebody [name={0}, birth={1}, c={2}]]", name, ZonedDateTime.ofInstant(birth, ZoneOffset.UTC), c);
	}
}
