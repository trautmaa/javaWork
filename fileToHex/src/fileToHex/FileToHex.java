package fileToHex;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileToHex {
	public static void main(String [] args) throws IOException {
		
		int value = 0;
		InputStream is = new FileInputStream("myfile.txt");
		
		
		/*
		 * loop reads through each byte in the file
		 */
		while( (value = is.read()) != -1){
//			counter++;
//			System.out.println(value);
			System.out.println(decimalToHex(value));
		}
		
		
		is.close();
	}
	
	
	/*
	 * decimalToHex function takes as input an integer in decimal notation
	 * and returns a string denoting that integer in hex notation
	 */
	public static StringBuilder decimalToHex(int decimalForm){
		StringBuilder hexForm = new StringBuilder();
		int sixteensPlaceInt = decimalForm/16;
		int onesPlaceInt = decimalForm%16;
		String sixteensPlaceStr = "";
		String onesPlaceStr = "";
		
		
		
		/*
		 * Convert values above 9 into letters
		 * We are assuming both sixteensPlaceInt and onesPlaceInt are >-1 and <16
		 */
		
		/*
		 * handle sixteens place
		 */
		if (sixteensPlaceInt>9) {
			if (sixteensPlaceInt == 10) {
				hexForm.append("A");
			}
			else if (sixteensPlaceInt == 11) {
				hexForm.append("B");
			}
			else if (sixteensPlaceInt == 12) {
				hexForm.append("C");
			}
			else if (sixteensPlaceInt == 13) {
				hexForm.append("D");
			}
			else if (sixteensPlaceInt == 14) {
				hexForm.append("E");
			}
			else if (sixteensPlaceInt == 15) {
				hexForm.append("F");
			}
		}
		else { //it was <10
			hexForm.append(Integer.toString(sixteensPlaceInt));
		}
			
		
		
		/*
		 * handles ones place
		 */
		if (onesPlaceInt>9) {
			if (onesPlaceInt == 10) {
				hexForm.append("A");
			}
			else if (onesPlaceInt == 11) {
				hexForm.append("B");
			}
			else if (onesPlaceInt == 12) {
				hexForm.append("C");
			}
			else if (onesPlaceInt == 13) {
				hexForm.append("D");
			}
			else if (onesPlaceInt == 14) {
				hexForm.append("E");
			}
			else if (onesPlaceInt == 15) {
				hexForm.append("F");
			}
		}
		else { //it was <10
			hexForm.append(Integer.toString(onesPlaceInt));
		}
				
		
		//Now hexform has all the relevant information
		return hexForm;
		
	}
}
