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
                    System.out.println("Enter how much to translate in x: ");
                    double ScaleX = scan.nextDouble();
                    System.out.println("Enter how much to translate in y: ");
                    double ScaleY = scan.nextDouble();
                    System.out.println("Enter how much to translate in z: ");
                    double ScaleZ = scan.nextDouble();

                    System.out.println("[1] Object space");
                    System.out.println("[2] World space");
                    operation = scan.nextInt();

                    if(operation == 1){
                        matrix Center = composeTransform.baryCenter(composeTransform);
                        matrix Return = composeTransform.baryReturn(composeTransform);
                        matrix Scale = composeTransform.Createscale(ScaleX, ScaleY, ScaleZ);

                        composeTransform = Center.mult(composeTransform);
                        composeTransform = Scale.mult(composeTransform);
                        composeTransform = Return.mult(composeTransform);
                    }

                    else{
                        matrix Scale = composeTransform.Createscale(ScaleX, ScaleY, ScaleZ);
                        composeTransform = Scale.mult(composeTransform);
                    }
                    break;

                case 3:/*Distort*/
                    System.out.println("[1] Distort in x");
                    System.out.println("[2] Distort in y");
                    System.out.println("[3] Distort in z");
                    int nAxis = scan.nextInt();

                    System.out.println("Distort by how much?");
                    double Distort = scan.nextDouble();

                    System.out.println("[1] Object space");
                    System.out.println("[2] World space");
                    operation = scan.nextInt();

                    if(operation == 1){
                        matrix Center = composeTransform.baryCenter(composeTransform);
                        matrix Return = composeTransform.baryReturn(composeTransform);
                        matrix Dist = composeTransform.Createskew(nAxis, Distort);

                        composeTransform = Center.mult(composeTransform);
                        composeTransform = Dist.mult(composeTransform);
                        composeTransform = Return.mult(composeTransform);
                    }

                    else{
                        matrix Dist = composeTransform.Createskew(nAxis, Distort);
                        composeTransform = Dist.mult(composeTransform);
                    }
                    break;

                case 4:/*Squeeze*/
                    System.out.println("Squeeze by how much?");
                    double Squish = scan.nextDouble();

                    System.out.println("[1] Object space");
                    System.out.println("[2] World space");
                    operation = scan.nextInt();

                    if(operation == 1){
                        matrix Center = composeTransform.baryCenter(composeTransform);
                        matrix Return = composeTransform.baryReturn(composeTransform);
                        matrix Squeeze = composeTransform.createSqueeze(Squish);

                        composeTransform = Center.mult(composeTransform);
                        composeTransform = Squeeze.mult(composeTransform);
                        composeTransform = Return.mult(composeTransform);
                    }

                    else{
                        matrix Squeeze = composeTransform.createSqueeze(Squish);
                        composeTransform = Squeeze.mult(composeTransform);
                    }
                    break;

                case 5:/*Projection*/
                    System.out.println("Enter the value for n: ");
                    double n = scan.nextDouble();
                    
                    System.out.println("Enter which plane to project?");
                    System.out.println("[1] - XY Plane");
                    System.out.println("[2] - YZ Plane");
                    System.out.println("[3] - XZ Plane");
                    int nPlane = scan.nextInt();
                    
                    matrix project = new matrix(4);
                    project = project.createProjection(nPlane, n);
                    break;

                case 6:/*Rotation*/
                    System.out.println("[1] Rotate in x");
                    System.out.println("[2] Rotate in y");
                    System.out.println("[3] Rotate in z");
                    int nRot = scan.nextInt();

                    System.out.println("Rotate by how much? (in Radians)");
                    double Angle = scan.nextDouble();

                    System.out.println("[1] Object space");
                    System.out.println("[2] World space");
                    operation = scan.nextInt();

                    if(operation == 1){
                        matrix Center = composeTransform.baryCenter(composeTransform);
                        matrix Return = composeTransform.baryReturn(composeTransform);
                        matrix Spin = composeTransform.CreateSpin(nRot, Angle);

                        composeTransform = Center.mult(composeTransform);
                        composeTransform = Spin.mult(composeTransform);
                        composeTransform = Return.mult(composeTransform);
                    }

                    else{
                        matrix Spin = composeTransform.CreateSpin(nRot, Angle);
                        composeTransform = Spin.mult(composeTransform);
                    }
                    break;
            }
        }while(operation != 7);
    }
}
