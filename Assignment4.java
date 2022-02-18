/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author judithcastrejon
 * @version 12-9-2020
 * @pseudocode holds the main method, prompts the user for filename, reads in numbers from a file, 
 * creates objects of other classes, and prints out final results back to the user

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       //creating scanner to read user input 
       Scanner reader = new Scanner(System.in);
      
           try{
       //asking the user to input a file name
        System.out.println("Please enter the file name ");
        //saving the filename in a string 
        String FileName = reader.nextLine();
        //reading the file name that the user input 
            reader = new Scanner(new File(FileName + ".txt"));
            //if the file name cannot be found then a message is displayed 
        } catch(FileNotFoundException e){
            System.out.println("The file cannot be found -> " + e);
        } //end of catch 
       
        
           //creating a magic square detector object 
       MagicSquareDetector MagicSq = new MagicSquareDetector();
       //while the scanner has a line to read,
       while (reader.hasNextLine()){
           String lines = reader.nextLine();
           // save the numbers as a that are seperated by a space 
           String [] dataArr = lines.split(" ");
           //saving the data as a integer and getting the length of the array 
           int [] datas = new int[dataArr.length];
           
           //looking throught the array and saving the data as a integer 
           for(int i = 0; i < dataArr.length; i++){
               datas[i] = Integer.parseInt(dataArr[i]);
       }
          //using the method rows to get the iformation in a single row 
        MagicSq.Rows(datas);
        
       }
       
          
       //if the magic square passes all the critiria then print out the information to the user, weather it is a magic square or not 
       if(MagicSq.isMagic()){
          MagicSquare magic = new MagicSquare(MagicSq.getArray2D(), MagicSq.getSize());
           System.out.println(magic);
       } else{
           System.out.println("The combination of numbers " + MagicSq.getNums() + " is not a magic square" );
       }
       
       //close the scanner that is reading the file 
      reader.close();
      
      //end of while 
       
        
        
    }//end of MagicSSquare class 
    
    
    
} 