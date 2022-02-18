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
 * @pseudocode holds a set of numbers that have been verified as a magic square, 
 * had fields that hold the magic constant, order of the magic square, etc
 * and has a toString method that prints out all the information.
 */
public class MagicSquare {
    
    //setting varibles 
    private int [] magicSquare;
    private Integer ConstantMagic = 15;
    private int Orders;

    
    /**
     * getting the sum of all the number in the 2D array
     * @param Nums
     * @param length 
     */
    public MagicSquare(int [][] Nums, int length){
        magicSquare = new int[length * length];
        int counting = 0;
        for (int i =0; i< length; i++){
            int sum =0;
            for (int j =0; j < length; j++){
                magicSquare[counting++] = Nums[i][j];
                sum += Nums[i][j];
            }
            if(ConstantMagic == null){
                ConstantMagic = sum;
            }
        }
        Orders = length;
    }
    
    
    
    /**
     * getting the magic square
     * @return the magicSquare 
     */
    public int[] getMagicSquare() {
        return magicSquare;
    }

    /**
     * getting the constant
     * @return constant
     */
    public int getConstantMagic() {
        return ConstantMagic;
    }

    /**
     * getting the order of the numbers in the 2D array 
     * @return  orders
     */
    public String getNumOrders() {
        String Num = " ";
        for(int i = 0; i < magicSquare.length; i++){
            Num = Num + magicSquare[i] + " ";
        }
        return Num ;
    }

    /**
     * setting the privative array to the parameter magicSquare   
     * @param magicSquare 
     */
    public void setMagicSquare(int[] magicSquare) {
        this.magicSquare = magicSquare;
    }

    /**
     * setting the privative constant to the parameter constant 
     * @param ConstantMagic 
     */
    public void setConstantMagic(int ConstantMagic) {
        this.ConstantMagic = ConstantMagic;
    }

    /**
     * setting the privative order to the parameter order 
     * @param orders 
     */
    public void setOrders(int orders) {
        this.Orders = orders;
    }

    /**
     * 
     * @return how the message to the user should be displayed 
     */
    @Override
    public String toString() {
        return "The combination of numbers " + getNumOrders() + "is a magic square of order " 
                + getNumOrders() + ". " + "The Magic Constant is " + getConstantMagic();
    }
    
    
    
}
