import java.util.Scanner;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		String [][] table;
		Scanner scanner;
		File list = new File("list.txt");
		int fileLength = 0;
		try {
			scanner = new Scanner(list);
			//check length of file
			while(scanner.hasNext()){
				scanner.nextLine();
				fileLength++;
			}
			//restart scanner to beginning of file
			scanner.close();
			scanner = new Scanner(list);
			//setup table array values
			table = new String[fileLength][3];
			for(int i = 0; i < fileLength; i++){
				table[i] = scanner.nextLine().split(" ");
			}
			
			
			for(int i = 0; i < table.length; i++){
				for(int j = 0; j < 3; j++){
					System.out.println(table[i][j]);	
				}
			}
			
		} 
		//handle file not found
		catch (FileNotFoundException e) {
			System.out.println("File \"mylist.txt\"not Found");
			
		}
	}

}
