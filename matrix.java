//Gian Mauricio - X_22; 11839651 - IET-GDS
// Carlo Tongco - X_22; 11712147 - CS-GDS

import java.math.*;

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

    //Overrides to string function, writes all contents of the matrix
    //Possibly convertible to write to file function from matrix
    @Override
    public String toString()
    {
        for (double[] ElementY : aValues) {
            System.out.print("[ ");
            for (double ElementX : ElementY)
                System.out.printf("%.2f ", ElementX);
            System.out.println("]");
        }

        return null;
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
    public matrix CreateSkew(int nAxis, double nValue){
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
}
