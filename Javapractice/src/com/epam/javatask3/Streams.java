package com.epam.javatask3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Streams {

	public void readAndWriteFile() throws IOException {
		BufferedReader inputstream = null;
		PrintWriter outputstream = null;
		try {
			inputstream = new BufferedReader(new FileReader("D:/Minsk_Training/Stream files/source.txt"));
			outputstream = new PrintWriter(new FileWriter("D:/Minsk_Training/Stream files/destination.txt"));
			String data;
			while ((data = inputstream.readLine()) != null) {
				outputstream.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputstream != null) {
				inputstream.close();
			}
			if (outputstream != null) {
				outputstream.close();
			}
		}
	}
	
	public void writeFile(String message) throws IOException
	{
		try {

			final File file = new File("D:/Minsk_Training/Stream files/destination.txt");
			final FileWriter filewrite = new FileWriter(file, true);
			final BufferedWriter bufferAppend = new BufferedWriter(filewrite);

			bufferAppend.append(message);

			filewrite.write("\r\n");

			bufferAppend.close();
		}

		catch (IOException e) {
		  e.printStackTrace();
		}
	}
}
