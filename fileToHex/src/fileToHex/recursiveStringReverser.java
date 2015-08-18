package fileToHex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public class recursiveStringReverser {

	public static void main(String[] args) throws IOException{
		String filename = "simpleString.txt";
		StringBuilder chars = getString(filename);
		StringBuilder reversedChars = reverse(chars);
		System.out.println(chars);
		System.out.print("Recursive reverse: ");
		System.out.println(reversedChars);
		StringBuilder stackReverse = stackReverse(reversedChars);
		System.out.print("Stack unreverse: ");
		System.out.println(stackReverse);
		
		//Write it
		writer("paperback.txt", stackReverse);
	}

	
	/*
	 * Write a StringBuilder to a file
	 */
	public static void writer(String filename, StringBuilder charsToWrite) {
		File f=new File(filename);
		
		StringBuffer sb = new StringBuffer(charsToWrite);
		try{
			FileWriter fwriter = new FileWriter(f);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(sb.toString());
			bwriter.close();			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static StringBuilder stackReverse(StringBuilder charString) {
		Stack<StringBuilder> charStack = new Stack<StringBuilder>();
	
		//Loads the stack with the characters
		while (charString.length() > 0){
			StringBuilder charToPush = new StringBuilder();
			charToPush.append(charString.charAt(0));
			charStack.push(charToPush);
			charString.deleteCharAt(0);
			}
		
		while (!charStack.empty()) {
			charString.append(charStack.pop());
			}
		
		return charString;
		}
	

	
		
	
	public static StringBuilder reverse(StringBuilder charString){
		
		StringBuilder reversedCharString = new StringBuilder();
		
		/*
		 * Base case:  when string has length 1
		 */
		if (charString.length() < 1) {
			return charString;
		}
		
		/*
		 * Recursive step: call reverse and append that after the last character in charString
		 */
		
		//Put last character at the beginning
		reversedCharString.append(charString.charAt(charString.length()-1));
		
		//Append reversed rest of word
		StringBuilder orderedSubString = new StringBuilder();
		orderedSubString.append(charString.substring(0, charString.length()-1));
		reversedCharString.append(reverse(orderedSubString));
		
		return reversedCharString;
	}
	
	
	/*
	 * getString function takes as input a filename and returns
	 * a StringBuilder object 'chars'
	 */
	public static StringBuilder getString(String filename) throws IOException{
		InputStream is = new FileInputStream(filename);
		
		StringBuilder chars = new StringBuilder();
		int value = 0;
		while((value = is.read()) != -1) {
			chars.append((char)value);
		}
		is.close();
		return chars;
		
	}
	
	
}
