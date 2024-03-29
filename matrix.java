/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.ArrayList;

//Gian Mauricio - X_22; 11839651 - IET-GDS
// Carlo Tongco - X_22; 11712147 - CS-GDS

public class matrix {
    public int nRows;
    public int nCols;
    public double[][] aValues;

    //Create a matrix based on a given size, matrix is automatically an identity
    public matrix(int size)
    {
        nRows = size;
        nCols = size;

        aValues = new double[nRows][nCols];

        for (int i = 0; i < nRows; i++)
            aValues[i][i] = 1;
    }

    //Create a matrix based on a given set of rows and columns, all items within are 0
    public matrix(int rows, int cols)
    {
        nRows = rows;
        nCols = cols;

        aValues = new double[nRows][nCols];

        for (double[] ElementY : aValues)
            for (double ElementX : ElementY)
                ElementX = 0;

    }

    //Create a matrix based on rows, columns and a given 2D array with values
    public matrix(int rows, int cols, double[][] values)
    {
        nRows = rows;
        nCols = cols;

        aValues = new double[nRows][nCols];

        /*
        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < nCols; j++)
                aValues[i][j] = values[i][j];
        */

        System.arraycopy(values, 0, aValues, 0, nRows);
    }
  
    public matrix(ArrayList<String> Source){
        int nElements = Source.size();
        double newVals[][] = new double[4][nElements];

        //Loops through the main ArrayList of strings
        for(int i = 0; i < nElements; i++){
            //Parses each string by inspecting the first element
            /*Spherical*/
            if(Source.get(i).startsWith("s")){
                //Convert to cartesian before adding to array set
                double spherVals[] = new double[3],
                       cartVals[];
                spherVals[0] = Character.getNumericValue(Source.get(i).charAt(3));
                spherVals[1] = Character.getNumericValue(Source.get(i).charAt(6));
                spherVals[2] = Character.getNumericValue(Source.get(i).charAt(9));

                cartVals = toCart(spherVals);

                newVals[0][i] = cartVals[0];
                newVals[1][i] = cartVals[1];
                newVals[2][i] = cartVals[2];
                newVals[3][i] = 1.0;
            }

            /*Cartesian*/
            else if(Source.get(i).startsWith("c")){
                //Add to array set depending on the contents of the string
                newVals[0][i] = Character.getNumericValue(Source.get(i).charAt(3));
                newVals[1][i] = Character.getNumericValue(Source.get(i).charAt(6));
                newVals[2][i] = Character.getNumericValue(Source.get(i).charAt(9));
                newVals[3][i] = 1.0;
            }
        }

        nRows = 4;
        nCols = nElements;
        aValues = new double[nRows][nCols];
        System.arraycopy(newVals, 0, aValues, 0, nRows);
    }

    //Converts spherical coordinates to cartesian coordinates
    private double[] toCart(double Spher[]){
        double dRads = Spher[0],
               dTheta = Spher[1],
               dPho = Spher[2];

        double[] cartVals = new double[3];

        /*For x*/
        cartVals[0] = dRads * Math.sin(dPho) * Math.cos(dTheta);

        /*For y*/
        cartVals[1] = dRads * Math.sin(dPho) * Math.sin(dTheta);

        /*For z*/
        cartVals[2] = dRads * Math.cos(dPho);

        return cartVals;
    }

    //Overrides to string function, writes all contents of the matrix
    //Possibly convertible to write to file function from matrix
    @Override
    public String toString()
    {
        String newString = "";
        for(int i = 0; i < nRows - 1; i++){
            for(int j = 0; j < nCols; j++){
                newString = newString.concat(Double.toString(aValues[i][j]));
                if(j < nCols - 1) {
                    newString = newString.concat(", ");
                }
            }
            newString = newString.concat("\n");
        }
        return newString;
    }
    
    //composes a translate matrix based on the given input per axis
    public matrix createTranslate(double x, double y, double z)
    {        
        matrix translate = new matrix(4);
        
        //assign translate values to the corresponding areas
        translate.aValues[0][3] = x;
        translate.aValues[1][3] = y;
        translate.aValues[2][3] = z;
        
        return translate;
    }
    
    //composes a squeeze 
    public matrix createSqueeze(double k){
        
        matrix squeeze = new matrix(4);
        
        squeeze.aValues[0][1] = k;
        squeeze.aValues[0][2] = k;
        squeeze.aValues[1][0] = k;
        squeeze.aValues[1][2] = k; 
        squeeze.aValues[2][0] = k;
        squeeze.aValues[2][1] = k;
        
        return squeeze;
    }

    //Composes a scale matrix based on given integers per axis
    public matrix Createscale(double Sx, double Sy, double Sz)
    {
        matrix Scale = new matrix(4);

        //Assign values at all appropriate areas
        Scale.aValues[0][0] = Sx;
        Scale.aValues[1][1] = Sy;
        Scale.aValues[2][2] = Sz;

        return Scale;
    }

    //Matrix multiplication (Can serve for composition, but ordering is hard to find out)
    public matrix mult(matrix other)
    {
        if (nCols == other.nRows) {
            double[][] newVals = new double[nRows][other.nCols];

            for (int i = 0; i < nRows; i++)
                for (int j = 0; j < other.nCols; j++)
                    for (int k = 0; k < other.nRows; k++)
                        newVals[i][j] = newVals[i][j] + aValues[i][k] * other.aValues[k][j];

            return new matrix(nRows, other.nCols, newVals);
        } else {
            System.out.println("Not Possible");
            return null;
        }
    }

    //Shifts the matrix orientation
    public matrix transpose()
    {
        double[][] newVals = new double[nCols][nRows];

        for (int i = 0; i < nCols; i++)
            for (int j = 0; j < nRows; j++)
                newVals[i][j] = aValues[j][i];

        return new matrix(nCols, nRows, newVals);
    }

    //Skews the matrix in one axis in reference to the other two axes by a certain value
    public matrix Createskew(int nAxis, double nValue){
        matrix Skew = new matrix(4);

        switch(nAxis){
            //Skew across x
            case 1:
                Skew.aValues[0][1] = nValue; /*Reference to y*/
                Skew.aValues[0][2] = nValue; /*Reference to z*/
                break;

            //Skew across y
            case 2:
                Skew.aValues[1][0] = nValue; /*Reference to x*/
                Skew.aValues[1][2] = nValue; /*Reference to z*/
                break;

            //Skew across z
            case 3:
                Skew.aValues[2][0] = nValue; /*Reference to x*/
                Skew.aValues[2][1] = nValue; /*Reference to y*/
                break;
        }

        return Skew;
    }
    
    public matrix createProjection(int nPlane, double n){
        matrix project = new matrix(4);
        
        //switch statement for different planes
        switch(nPlane){
            //Project along the xy plane
            case 1: 
                project.aValues[0][0] = n;
                project.aValues[1][1] = n;
                project.aValues[2][2] = 0;
                project.aValues[2][3] = -1;
                break;
            //Project along the yz plane
            case 2: 
                project.aValues[0][0] = 0;
                project.aValues[1][1] = n;
                project.aValues[2][2] = n;
                project.aValues[2][3] = -1;
                break;
            //Project along the xz plane
            case 3: 
                project.aValues[0][0] = n;
                project.aValues[1][1] = 0;
                project.aValues[2][2] = n;
                project.aValues[2][3] = -1;
                break;
        }
        
        return project;
    }
    
    //Rotates the matrix by a certain amount in degrees, across an axis
    public matrix CreateSpin(int nAxis, double dTheta){
        matrix Spun = new matrix(4);

        //Euler implementation
        switch(nAxis){
            //Rotate across x
            case 1:
                Spun.aValues[1][1] = Math.cos(dTheta);
                Spun.aValues[1][2] = -Math.sin(dTheta);
                Spun.aValues[2][1] = Math.sin(dTheta);
                Spun.aValues[2][2] = Math.cos(dTheta);
                break;

            //Rotate across y
            case 2:
                Spun.aValues[0][0] = Math.cos(dTheta);
                Spun.aValues[0][2] = Math.sin(dTheta);
                Spun.aValues[2][0] = -Math.sin(dTheta);
                Spun.aValues[2][2] = Math.cos(dTheta);
                break;

            //Rotate across z
            case 3:
                Spun.aValues[0][0] = Math.cos(dTheta);
                Spun.aValues[0][1] = -Math.sin(dTheta);
                Spun.aValues[1][0] = Math.sin(dTheta);
                Spun.aValues[1][1] = Math.cos(dTheta);
                break;
        }
        return Spun;
    }

    //Returns a matrix which brings the matrix to origin
    public matrix baryCenter(matrix Current){
        matrix Bary = new matrix(4);
        int nTotal = Current.nCols;
        for(int i = 0; i < nTotal; i++){
            Bary.aValues[0][3] += Current.aValues[0][i];/*Sum of all X*/
            Bary.aValues[1][3] += Current.aValues[1][i];/*Sum of all Y*/
            Bary.aValues[2][3] += Current.aValues[2][i];/*Sum of all Z*/
        }

        Bary.aValues[0][3] /= nTotal;
        Bary.aValues[1][3] /= nTotal;
        Bary.aValues[2][3] /= nTotal;
        return Bary;
    }

    //Returns a matrix which returns the matrix to the current location
    public matrix baryReturn(matrix Current){
        matrix Bary = new matrix(4);
        int nTotal = Current.nCols;
        for(int i = 0; i < nTotal; i++){
            Bary.aValues[0][3] += Current.aValues[0][i];/*Sum of all X*/
            Bary.aValues[1][3] += Current.aValues[1][i];/*Sum of all Y*/
            Bary.aValues[2][3] += Current.aValues[2][i];/*Sum of all Z*/
        }

        Bary.aValues[0][3] /= -nTotal;
        Bary.aValues[1][3] /= -nTotal;
        Bary.aValues[2][3] /= -nTotal;
        return Bary;
    }
}