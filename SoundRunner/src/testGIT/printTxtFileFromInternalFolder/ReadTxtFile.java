package testGIT.printTxtFileFromInternalFolder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader("src/filesFolder/testFile1.txt"))) {
	         String sCurrentLine;
	         
	         while ((sCurrentLine = br.readLine()) != null) {
	            System.out.println(sCurrentLine);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }

	}

}
