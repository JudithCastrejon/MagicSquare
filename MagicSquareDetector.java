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
 * @pseudocode determines if a 2D array  of integers (int) is a magic square 
 */
public class MagicSquareDetector {
    
    //private array varible and private size integer (int) size varible 
    private int [][] Array2D = null;
    private int size = 0;
    
    
    /**
     * initializing the 2D array and size 
     */
    public MagicSquareDetector(){
        Array2D = new int[10][];
        size = 0;
    }

    /**
     * getting the 2D array
     * @return the 2D array
     */
    public int[][] getArray2D() {
        return Array2D;
    }

    /**
     * getting the size
     * @return the size
     */
    public int getSize() {
        return size;
    }

    
    
    /**
     * setting the private 2D array equal to the parameter Array variable 
     * @param Array2D 
     */
    public void setArray2D(int[][] Array2D) {
        this.Array2D = Array2D;
    }

    /**
     * setting the private size variable equal to the parameter size variable 
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
     * getting the numbers in the array by looping through both of the arrays (looking through the 2D array)
     * @return the number that the array
     */
    public String getNums(){
         String Num = " ";
        for (int i = 0; i < size; i ++){
            for(int j = 0; j < Array2D[i].length; j++){
                Num += Num + Array2D[i][j] + " .";
            }
        }
        
        return Num;
    }
    
    
    /**
     * getting numbers in a single row of an array
     * @param rowInfo 
     */
    public void Rows(int[] rowInfo){
        Array2D[size] = rowInfo;
        size++;
    }
    
    
    /**
     * method to check if the 2D array is a square 
     * @return 
     */
    private boolean is2D(){
        boolean YesorNo = true;
        for(int i = 0; i < size; i++){
            if (Array2D[i].length != size){
                YesorNo = false;
                break;
            }
        }
        return YesorNo;
    }
   
    
    /**
     * counting the numbers in the 2D array 
     * @param numbers
     * @return 
     */
    public int NumCount(int numbers){
        int count = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < Array2D[i].length; j++){
                if(Array2D[i][j] == numbers){
                    count++;
                }
            }
        }
        return count;
    }
       
        
    /**
     * getting the numbers in the array 
     * @return true or false/ boolean 
     */
    public boolean Num(){
        boolean check = true;
        int num;
        for(int i = 0; i < size; i++){
            for(int j=0; j < Array2D[i].length; j++){
                num = Array2D[i][j];
                if(NumCount(num)> 1){
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    
    
    /**
     * 
     * getting the sum of the diagonal (left and right) and then the column of the array 
     * this method checks 
     * @return the sum of all the numbers 
     */
    private boolean Sum(){
        //thecking to see if the array to 2D
        if(is2D()){
            int ArraySums[] = new int[2 * size +2];
            int count = 0;
            int sum = 0;
            
            //getting the sum of the rows in the array 
            for (int i = 0; i < size; i++){
                sum = 0;
                for (int j = 0; j < size; j++){
                    sum += Array2D[i][j];
                }
                ArraySums[count++] = sum;
            }
            
            //gettng the information of a coloum 
            for (int i = 0; i < size; i++){
                sum =0;
                for(int j = 0; j< size; j++){
                    sum += Array2D[j][i];
                }
                ArraySums[count++] = sum;
            }
            
            //getting the sum of the left diagonal 
            sum = 0;
            for(int i = 0; i < size; i++){
                sum+= Array2D[i][i];
            }
            ArraySums[count] = sum;
            
            
            //getting the diagonal to the right 
            sum = 0; 
            for(int i = 0; i < size; i++){
                sum += Array2D[i][size-1-i];
            }
            ArraySums[count] = sum;
            
            int countCurrent = ArraySums[0];
            boolean result = true;
            for(int i = 1; i < size; i++){
                if(ArraySums[i] != countCurrent){
                    result = false;
                    break;
                }
            }
            return result;
            
        }
        return false;
        
    }
    
    
    /**
     * checking to see if all the criteria for a magic square is true or not 
     * @return TF to see if the square is magic or not 
     */
    public boolean isMagic(){
        boolean TF = false;
        if(is2D() && Num() && Sum() ){
            TF = true;
        }
        return TF;
    }
        
     
}


