/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

//Gian Mauricio - X_22; 11839651 - IET-GDS
// Carlo Tongco - X_22; 11712147 - CS-GDS
public class MatrixTester
{
    //Test area
    public static double getTranslateInputX(){
        
        double translateX;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how much to translate in x: ");
        translateX = scan.nextDouble();
        
        return translateX;
    }
    
    public static double getTranslateInputY(){
        
        double translateY;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how much to translate in y: ");
        translateY = scan.nextDouble();
        
        return translateY;
    }
    
    public static double getTranslateInputZ(){
        
        double translateZ;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how much to translate in y: ");
        translateZ = scan.nextDouble();
        
        return translateZ;
    }
    
    public static ArrayList<String> readFromFile(File file) throws Exception{
        
        Scanner sc = new Scanner(file); 
        ArrayList<String> values = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            String i = sc.nextLine(); 
            values.add(i);
        }
        
        FileReader fr = new FileReader(file); 
        LineNumberReader lnr = new LineNumberReader(fr);
        int lines = 0;
 
        while (lnr.readLine() != null) {
            lines++;
        }  
        
        return values;
    }
    
    private static void writeToFile(String data) {
        
        File file = new File("C:\\Users\\user\\Desktop\\output.txt");
        try{    
            FileWriter fw = new FileWriter(file);    
            fw.write(data);    
            fw.close();    
        }catch(Exception e){
            System.out.println(e);
        }    
    } 
    
    public static void main(String[] args) throws Exception
    {
//        File filename = new File("C:\\Users\\user\\Desktop\\input.txt"); 
//        ArrayList<String> val = new ArrayList<>();
//        
//        val = readFile(filename);
//        
//        for(int i = 0; i< val.size(); i++){
//            System.out.println(val.get(i));
//        }            
        
        double[][] newValues7 = {{1},{2},{3},{1}};
        matrix m = new matrix(4, 1, newValues7);
        
        System.out.println("Input matrix: ");
        m.toString();

        matrix n = new matrix(4);
        matrix trans = n.createTranslate(3, 4, 5);
        System.out.println("Translate matrix: ");
        trans.toString();
        
        matrix result = trans.mult(m);
        result = result.transpose();
        System.out.println("Result matrix: ");
        String output = result.toString();
        System.out.println(output);
        writeToFile(output);
//        
//        double[][] newValues8 = {{0, 1, 0, 1},{0, 0, 1, 0},{0, 0, 0, 1},{1, 1, 1, 1}};
//        matrix m1 = new matrix(4, 4, newValues8);
//        matrix squeeze = m1.createSqueeze(0.5);
//        System.out.println("Squeeze matrix: ");
//        squeeze.toString();
//        
//        matrix squeezeresult = squeeze.mult(m1);
//        System.out.println("Result matrix: ");
//        squeezeresult.toString();
    }
}
