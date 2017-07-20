package tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Utility {

	public static void fillIntArrayFromFile(int[] array, String path) {
		InputStream is = Utility.class.getResourceAsStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = br.readLine();
			String[] numbers = line.split(", ");
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(numbers[i]);
			}
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeToFile(int[] array, String filename) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename, "UTF-8");

		String numbers = array[0] + "";
		for (int i = 1; i < array.length; i++) numbers += (", " + array[i]);

		writer.println(numbers);
		writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
