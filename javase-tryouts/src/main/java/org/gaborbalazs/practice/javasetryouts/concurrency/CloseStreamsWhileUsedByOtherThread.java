package org.gaborbalazs.practice.javasetryouts.concurrency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CloseStreamsWhileUsedByOtherThread {

	public static void main(String[] args) {

		System.out.println("Begin");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		File source = new File("C:\\MyFolder\\MyXFolder\\Videos Under Editing\\937182.mp4");
		File dest = new File("dest.mp4");
		
		System.out.println("Source exists: " + source.exists());
		
		InputStream sourceIn = null;
		OutputStream destOut = null;
		
		try {
			InputStream finalSourceIn = new FileInputStream(source);
			OutputStream finalDestOut = new FileOutputStream(dest);
			sourceIn = finalSourceIn;
			destOut = finalDestOut;
			service.submit(() -> copy(finalSourceIn, finalDestOut));
			service.shutdownNow();
			System.out.println("Main is waiting");
			Thread.sleep(3000);
			System.out.println("Main is not waiting any more");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException in main");
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in main");
		} finally {
			if(sourceIn != null) {
				try {
					sourceIn.close();
					sourceIn.close();
				} catch (IOException e) {
					System.out.println("IOException in main");
				} finally {
					if(destOut != null) {
						try {
							destOut.close();
							destOut.close();
						} catch (IOException e) {
							System.out.println("IOException in main");
						}
					}
				}
			}
		}
		
		System.out.println("End");
		
	}

	public static void copy(InputStream in, OutputStream out) {
		System.out.println("Start copying");
		int b = 0;
		try {
			while((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (IOException e) {
			System.out.println("IOException in copy()");
		} finally {
			System.out.println("End copying");
		}
	}
}
