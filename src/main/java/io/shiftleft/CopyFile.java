package oata;

import java.io.*;
 
/**
 * This program demonstrates how to copy a file using the
 * FileInputStream and FileOutputStream classes with a
 * byte array as a buffer.
 * @author Giriraj
 */
public class CopyFile {
    private static final int BUFFER_SIZE = 4096;
	private static final String str = "JENKINS";
 
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        }
 
        String inputFile = args[0];
        String outputFile = args[1];
 
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
 
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            System.out.println("Exception occured");
        }
    }
}