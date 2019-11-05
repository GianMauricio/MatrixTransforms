//Gian Cedric Amos Mauricio - X_22
//11839651 - IET-GDS

/*
Checklist:
    * Variables
        - nRows[/]
        - nCols[/]
        - aValues[/]
    * Constructors
        - Identity matrix[/]
        - Zero matrix with given dimensions[/]
        - matrix with dimensions and values[/]
    * Functions
        - toString[/]
        - add[/]
        - scale[/]
        - mult[/]
        - transpose[/]
    * Additional Functions
        - minor[/]
        - determinant[/]
    *Gauss-Jordan Elimination Algorithm
        - Getting determinant using GJE[]
        - Returning the solution to linear equations using GJE[]
           - Can handle whole numbers[/]
           - Can handle negative numbers[/]
           - Can handle fractions[]
    *Appropriate variable names[/]
*/

public class matrix {
    public int nRows;
    public int nCols;
    public double[][] aValues;

    public matrix(int size)
    {
        nRows = size;
        nCols = size;

        aValues = new double[nRows][nCols];

        for (int i = 0; i < nRows; i++)
            aValues[i][i] = 1;
    }

    public matrix(int rows, int cols)
    {
        nRows = rows;
        nCols = cols;

        aValues = new double[nRows][nCols];

        for (double[] ElementY : aValues)
            for (double ElementX : ElementY)
                ElementX = 0;

    }

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

    public matrix add(matrix other)
    {
        if (nRows != other.nRows) {
            System.out.println("Not Possible");
            return null;
        } else if (nCols != other.nCols) {
            System.out.println("Not Possible");
            return null;
        } else {
            double[][] newVals = new double[nRows][nCols];
            for (int i = 0; i < nRows; i++)
                for (int j = 0; j < nCols; j++)
                    newVals[i][j] = aValues[i][j] + other.aValues[i][j];

            return new matrix(nRows, nCols, newVals);
        }
    }

    public matrix scale(double dScalar)
    {
        double[][] newVals = new double[nRows][nCols];

        for (int i = 0; i < nRows; i++)
            for (int j = 0; j < nCols; j++)
                newVals[i][j] = aValues[i][j] * dScalar;

        return new matrix(nRows, nCols, newVals);
    }

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

    public matrix transpose()
    {
        double[][] newVals = new double[nCols][nRows];

        for (int i = 0; i < nCols; i++)
            for (int j = 0; j < nRows; j++)
                newVals[i][j] = aValues[j][i];

        return new matrix(nCols, nRows, newVals);
    }

    public matrix minor(matrix major, int nRow, int nCol)
    {
        int nMinorRow = 0, nMinorCol = 0;
        matrix minor = new matrix(major.nRows - 1, major.nCols - 1);

        for(int i = 0; i < major.nCols; i++)
        {
            for (int j = 0; j < major.nRows; j++)
            {
                if(!(i == nCol || j == nRow))
                {
                    minor.aValues[nMinorCol][nMinorRow] = major.aValues[j][i];
                    nMinorRow++;
                }
            }

            nMinorRow = 0;
            if(!(i == nCol))
                nMinorCol++;
        }
        return minor;
    }

    //Made for recursion
    public matrix minor(int nRow, int nCol)
    {
        int nMinorRow = 0, nMinorCol = 0;
        matrix minor = new matrix(nRows - 1, nCols - 1);

        for(int i = 0; i < nCols; i++)
        {
            for (int j = 0; j < nRows; j++)
            {
                if(!(i == nCol || j == nRow))
                {
                    minor.aValues[nMinorCol][nMinorRow] = aValues[j][i];
                    nMinorRow++;
                }
            }

            nMinorRow = 0;
            if(!(i == nCol))
                nMinorCol++;
        }
        return minor;
    }

    public double determinant()
    {
        double dDeterminant = 0;
        if(nRows != nCols)
            dDeterminant = 0;

        else if(nRows == 1)
            dDeterminant = aValues[0][0];

        else if(nRows == 2)
            dDeterminant = (aValues[0][0] * aValues[1][1]) - (aValues[0][1] * aValues[1][0]);

        else
        {
            int nSign = 1;
            for(int i = 0; i < nRows; i++)
            {
                dDeterminant = dDeterminant + (nSign *(aValues[0][i] * minor(0, i).determinant()));
                nSign = nSign * -1;
            }
        }

        return dDeterminant;
    }

    public double det_ref()
    {
        double nDeterminant = 1;
        int nRowCtr;

        //Reduce the matrix to REF
        for(int i = 0; i < nRows; i++)
        {
            nRowCtr = i + 1;
            for(; nRowCtr < nRows; nRowCtr++)
            {
                if(aValues[nRowCtr][0] > 0)
                {
                    for(int j = 0; j < nCols; j++)
                    {
                        aValues[nRowCtr][j] = aValues[nRowCtr][j] - (aValues[nRowCtr][i] * aValues[i][j] / aValues[i][i]);
                    }
                }

                else if(aValues[nRowCtr][0] < 0)
                {
                    for(int j = 0; j < nCols; j++)
                    {
                        aValues[nRowCtr][j] = aValues[nRowCtr][j] + (aValues[nRowCtr][i] * aValues[i][j] / aValues[i][i]);
                    }
                }
            }
        }

        for(int i = 0; i < nRows; i++)
            nDeterminant *= aValues[i][i];

        return nDeterminant;
    }

    /*Begin BIG BRAIN time*/
    matrix GJE(matrix augment)
    {
        if(determinant() == 0)
        {
            System.out.println("Original matrix cannot evaluate to an identity matrix due to at least one linear dependency.");
            return null;
        }

        //Check first if the matrices are not conducive to each other
        if(nRows != augment.nRows)
        {
            System.out.println("Incompatible number of rows.");
            return null;
        }

        //Check if the original matrix isn't a square
        else if(nRows != nCols)
        {
            System.out.println("Original matrix cannot evaluate to an identity matrix due to mismatched dimensions.");
            return null;
        }

        //Solve for the matrix solution
        else
        {
            matrix solutionMatrix = new matrix(augment.nRows, augment.nCols, augment.aValues);
            double dChange;
            /*Create the solution matrix based on the augment and the actions required to
             * reduce the current matrix to an identity.
             */
            if(aValues != new matrix(nRows).aValues)
            {
                //For every pivot in the current matrix
                for(int currPivot = 0; currPivot < nRows; currPivot++)
                {
                    if(determinant() == 0)
                    {
                        System.out.println("Original matrix cannot evaluate to an identity matrix due to at least one linear dependency.");
                        return null;
                    }

                    //Reduce the pivot to one
                    if(aValues[currPivot][currPivot] != 1)
                    {
                        dChange = 1 / aValues[currPivot][currPivot];

                        //Reflect the change across the entire row
                        for (int j = 0; j < nCols; j++) {
                            aValues[currPivot][j] = aValues[currPivot][j]
                                    * dChange;
                        }

                        //Reflect the change across the solution matrix
                        for(int j = 0; j < solutionMatrix.nCols; j++) {
                            solutionMatrix.aValues[currPivot][j] = solutionMatrix.aValues[currPivot][j]
                                    * dChange;
                        }
                    }

                    //Make sure that every other value in the same column is 0
                    for(int colValue = 0; colValue < nRows; colValue++)
                    {
                        //While value is not equal to zero and if value is not the pivot being checked
                        while(aValues[colValue][currPivot] != 0 && colValue != currPivot)
                        {
                            //Continue to reduce the row until the value is 0 accounting for negativity
                            // and reflect the change onto the solution
                            if(aValues[colValue][currPivot] < aValues[currPivot][currPivot])/*if less than*/
                            {
                                for(int i = 0; i < nCols; i++) {
                                    aValues[colValue][i] += aValues[currPivot][i];
                                }

                                for(int i = 0; i < solutionMatrix.nCols; i++){
                                    solutionMatrix.aValues[colValue][i] += solutionMatrix.aValues[currPivot][i];
                                }
                            }

                            else /*if equal to or greater than*/
                            {
                                for(int i = 0; i < nCols; i++) {
                                    aValues[colValue][i] -= aValues[currPivot][i];
                                }

                                for(int i = 0; i < solutionMatrix.nCols; i++){
                                    solutionMatrix.aValues[colValue][i] -= solutionMatrix.aValues[currPivot][i];
                                }
                            }
                        }
                    }
                }
                return solutionMatrix;
            }

            //If the matrix is already in identity form, simply return the augment
            else
                return augment;
        }
    }
}
