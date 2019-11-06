/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author user
 */
public class matrix {
    public int nRows;
    public int nCols;
    public double[][] aValues;

    //Create an identity matrix based on a given size
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

    //Matrix scaling (Used in composing a scaling matrix)
    //Slight conversion needed to accommodate unique scale values across x y and z
    public matrix scale(double dScalar)
    {
        double[][] newVals = new double[nRows][nCols];

        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < nCols; j++)
                newVals[i][j] = aValues[i][j] * dScalar;

        return new matrix(nRows, nCols, newVals);
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
    
    public matrix createTranslate(double x, double y, double z)
    {
        nCols = 4;
        nRows = 4;
        
        double[][] transVals = new double[nRows][nCols];

        for (int i = 0; i < nRows; i++)
            transVals[i][i] = 1;
        
        transVals[0][3] = x;
        transVals[1][3] = y;
        transVals[2][3] = z;
        
        matrix val = new matrix(nRows, nCols, transVals);
        
        return val;
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
}
