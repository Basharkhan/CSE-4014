/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package age.calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class AgeCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        //read inputs
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date of birth(DD-MM-YYYY)");
        String input = scanner.next();
        
        //convert string into date format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Date date = simpleDateFormat.parse(input);
        
        Date systemDate = new Date();
        
        //calculate age
        long ms = System.currentTimeMillis() - date.getTime();
        long age = (long)((long)ms / (1000.0 * 60 * 60 * 24 * 365));
        
        System.out.println("Current age: " + age);
    }
    
}
