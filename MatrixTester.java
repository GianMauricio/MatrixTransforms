/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

//Gian Mauricio - X_22; 11839651 - IET-GDS
// Carlo Tongco - X_22; 11712147 - CS-GDS
public class MatrixTester
{
    //Test area    
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
        int operation = 0;
        Scanner scan = new Scanner(System.in);
        matrix composeTransform = new matrix(4);/*Matrix to hold the total transformations*/

        File filename = new File("E:\\Work\\La Salle Stuff\\Outputs\\Term 4\\GDMATH\\GitExports\\MatrixTransforms\\input.txt");
        ArrayList<String> val;

        val = readFromFile(filename);
        matrix inputVectors = new matrix(val);
        String testString = inputVectors.toString();

        System.out.println(val);
        System.out.println(testString);

        do{
            System.out.println("Perform which 3D Transformation?");
            System.out.println("[1] - Translate");
            System.out.println("[2] - Scale");
            System.out.println("[3] - Distort");
            System.out.println("[4] - Squeeze");
            System.out.println("[5] - Project");
            System.out.println("[6] - Rotate");
            System.out.println("[7] - Apply transformations to vector set");

            operation = scan.nextInt();

            switch(operation){
                case 1:/*Translation*/
                    System.out.println("Enter how much to translate in x: ");
                    double translateX = scan.nextDouble();
                    System.out.println("Enter how much to translate in y: ");
                    double translateY = scan.nextDouble();
                    System.out.println("Enter how much to translate in y: ");
                    double translateZ = scan.nextDouble();

                    matrix translate = new matrix(4);
                    translate = translate.createTranslate(translateX, translateY, translateZ);

                    composeTransform = translate.mult(composeTransform);/*Commit translate to current transforms*/
                    break;

                case 2:/*Scaling*/
                    System.out.println("[1] Object space");
                    System.out.println("[2] World space");

                    operation = scan.nextInt();

                    if(operation == 1){

                    }

                    else{

                    }
                    break;

                case 3:/*Distort*/
                    break;

                case 4:/*Squeeze*/
                    break;

                case 5:/*Projection*/
                    break;

                case 6:/*Rotation*/
                    break;
            }
        }while(operation != 7);
    }
}
