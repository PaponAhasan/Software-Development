package FileOutputStream;

import java.io.FileOutputStream;

public class writeString {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("E:\\JAVA Language\\Core Java\\File Directory\\MyFile\\testout.txt");
			String string = "My name is papon";
			byte b[] = string.getBytes();
			fout.write(b);
			fout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
