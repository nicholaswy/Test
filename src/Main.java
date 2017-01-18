
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicholas.yount
 */
public class Main {
    public static void main (String [] args){
        
        final int ROW_COUNT = 106;
        final int COLUMN_COUNT = 91;
        
        String [][] input = new String[ROW_COUNT][COLUMN_COUNT]; 
        //read a line into 2d matrix
        //input[0][4-...] into results[]
        
        Scanner scanFile = null;
        String fileName = "input.csv"; 
            
try{
	//open file
	//String file = "input.csv"
	File records = new File(fileName);
            scanFile = new Scanner(records); 
	
	//Reading the file
	
	
	for(int i = 0; i < ROW_COUNT; i++){
		String string = scanFile.nextLine(); 
                String [] splitted = string.split(","); 
		for(int b = 0; b < COLUMN_COUNT; b++){
		input[i][b] = splitted[b]; 
		
		}
	}

	/*Things to consider String[0][i] = Name
	String [1][i] = lastName
	String [i][0] where i >1 is the date*/
	
	//write to file
        
        File output = new File("output.csv");
        PrintWriter fout = null; 
	try{
	
	//open output file

            fout = new PrintWriter(output);
	//FileWriter fout = new FileWriter();
	
	
	//write output
	for(int i = 2; i < ROW_COUNT; i++){
            String name = input[0][i]; 
            String lastName = input [1][i]; 
            String dob = input[2][i]; 
            
		for(int b = 2; b < COLUMN_COUNT; b++){
                    String date = input[0][b]; 
			String out = name +"," + lastName +"," 
			+ dob + "," + date + "," + input[i][b]; 
			System.out.println(out); 
			//needs to print to outfile; 
			fout.println(out); 
		}
	}
	} catch (IOException io){
		System.out.println(io.getMessage()); 
	}
	
	
	
	
} catch (IOException io){

	System.out.println(io.getMessage()); 
}


//copy name, and dob and replicate down the first three columns for length of each line - 3

//then copy each date and status into appropriate columns 4 & 5.

//repeat for all people
        
    }
    
}
