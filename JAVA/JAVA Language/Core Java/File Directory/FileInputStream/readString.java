package FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readString {
	public static void main(String[] args) throws IOException {

		try {
			FileInputStream fin = new FileInputStream("E:\\JAVA Language\\Core Java\\File Directory\\MyFile\\testout.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
