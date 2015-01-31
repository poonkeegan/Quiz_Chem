import java.util.Scanner;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		String [] values = {"atomic number", "chemical element", "name"};
		String [][] table;
		Scanner scanner;
		File list = new File("list.txt");
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
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
			
			//generate random questions
			boolean run = true;
			while(run){
				//figure out which value to quiz on
				int randNum = (int)(Math.random()*3.0);
				//which value to present
				int randNumTwo = randNum;
				while(randNumTwo == randNum)
					randNumTwo = (int)(Math.random()*3.0);
				//which element to quiz on
				int randNumThree = (int)(Math.random()*(double)fileLength);
				//ask quiz question
				System.out.println("What is the "+values[randNum]+" of "+table[randNumThree][randNumTwo]);
				String input = null;
				try {
					input = read.readLine();
				} catch (IOException e) {
					System.out.println("IO ERROR EXITING PROGRAM");
					System.exit(1);
				}
				//read input, set everything to upper case
				if(input.toUpperCase().equals(table[randNumThree][randNum].toUpperCase())){
					System.out.println("Correct!");
				}else{
					System.out.println("Incorrect! The answer was "+table[randNumThree][randNum]);	
				}
			}
			
			
		} 
		//handle file not found
		catch (FileNotFoundException e) {
			System.out.println("File \"mylist.txt\"not Found");
			
		}
	}
}
