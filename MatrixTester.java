public class MatrixTester
{
    //Test area
    public static void main(String[] args)
    {
        //Testing Identity matrix
        System.out.println("Identity matrix: ");
        System.out.println("Size: 5");
        System.out.println();

        matrix newMatrix = new matrix(5);
        newMatrix.toString();

        System.out.println();
        System.out.println();

        //Testing Zero matrix
        System.out.println("Zero matrix: ");
        System.out.println("Rows: 6");
        System.out.println("Columns: 3");
        System.out.println();

        matrix newMatrix2 = new matrix(6, 3);
        newMatrix2.toString();

        System.out.println();
        System.out.println();

        //Testing matrix Actual
        System.out.println("matrix: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: {[1, 2, 3], [4, 5, 6], [7, 8, 9]}");
        System.out.println();

        double[][] newValues = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        matrix newMatrix3 = new matrix(3, 3, newValues);
        newMatrix3.toString();

        System.out.println();
        System.out.println();

        //Testing addition of two matrices
        System.out.println("matrix addition: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: {[1, 2, 3], [4, 5, 6], [7, 8, 9]}");
        System.out.println();
        System.out.println();
        System.out.println("matrix 2:");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: {[1, 1, 1], [2, 2, 2], [3, 3, 3]}");
        System.out.println();
        System.out.println();

        double[][] newValues2 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};

        matrix newMatrix4 = new matrix(3, 3, newValues2);
        matrix addMatrix = newMatrix3.add(newMatrix4);
        System.out.println("Final Values: ");
        addMatrix.toString();

        System.out.println();
        System.out.println();

        //Testing matrix scaling
        System.out.println("matrix scaling: ");
        System.out.println("matrix: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: {[2, 2, 2], [3, 3, 3], [2, 2, 2]}");
        System.out.println();
        System.out.println("Scale by: 3");
        System.out.println();

        double[][] newValues3 = {{2, 2, 2}, {3, 3, 3}, {2, 2, 2}};
        matrix newMatrix5 = new matrix(3, 3, newValues3);

        matrix scaledMatrix = newMatrix5.scale(3);
        System.out.println("Final Values: ");
        scaledMatrix.toString();
        System.out.println();

        //Testing matrix multiplication
        System.out.println("matrix multiplication: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 2");
        System.out.print("Values: {[1, 2], [3, 4], [5, 6]}");
        System.out.println();
        System.out.println();
        System.out.println("matrix 2: ");
        System.out.println("Rows: 2");
        System.out.println("Columns: 3");
        System.out.print("Values: {[1, 2, 3], [4, 5, 6]}");
        System.out.println();
        System.out.println();

        double[][] newValues4 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        matrix firstMultiple = new matrix(3, 2, newValues4);

        double[][] newValues5 = {{1, 2, 3}, {4, 5, 6}};
        matrix secondMultiple = new matrix(2, 3, newValues5);

        matrix multipliedMatrix = firstMultiple.mult(secondMultiple);
        System.out.println("Final Values: ");
        multipliedMatrix.toString();

        System.out.println();
        System.out.println();

        //Testing matrix transposition
        System.out.println("matrix transposition: ");
        System.out.println("matrix: ");
        System.out.println("Rows: 2");
        System.out.println("Columns: 3");
        System.out.print("Values: {[2, 4, 6], [3, 6, 9]}");
        System.out.println();
        System.out.println();

        double[][] newValues6 = {{2, 4, 6}, {3, 6, 9}};
        matrix originalMatrix = new matrix(2, 3, newValues6);

        matrix transposedMatrix = originalMatrix.transpose();

        System.out.println("Final Values: ");
        transposedMatrix.toString();

        System.out.println();
        System.out.println();

        //Testing matrix reduction (minor matrix / for determinants)
        System.out.println("matrix reduction: ");
        System.out.println("matrix: ");
        System.out.println("Rows: 4");
        System.out.println("Columns: 4");
        System.out.print("Values: ");
        System.out.print("{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}");
        System.out.println();
        System.out.println("Removed: Row 1 and Column 3");
        System.out.println();

        double[][] newValues7 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        matrix majorMatrix = new matrix(4, 4, newValues7);

        matrix minorMatrix = majorMatrix.minor(majorMatrix, 0, 2);

        System.out.println("Minor matrix: ");
        minorMatrix.toString();

        System.out.println();
        System.out.println();

        //Testing determinants
        System.out.println("matrix determinants: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 1");
        System.out.println("Columns: 1");
        System.out.print("Values: ");
        System.out.print("{[1]}");
        System.out.println();
        System.out.println();

        double[][] newValues8 = {{1}};
        matrix detMatrix1 = new matrix(1, 1, newValues8);

        System.out.print("Determinant: ");
        System.out.print(detMatrix1.determinant());

        System.out.println();
        System.out.println();

        System.out.println("matrix 2: ");
        System.out.println("Rows: 2");
        System.out.println("Columns: 2");
        System.out.print("Values: ");
        System.out.print("{{1, 2}, {3, 4}}");
        System.out.println();
        System.out.println();

        double[][] newValues9 = {{1, 2}, {3, 4}};
        matrix detMatrix2 = new matrix(2, 2, newValues9);

        System.out.print("Determinant: ");
        System.out.print(detMatrix2.determinant());

        System.out.println();
        System.out.println();

        System.out.println("matrix 3: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: ");
        System.out.println("{{1, 2, 3}, {4, 5, 6}, {5, 7, 13}}");
        System.out.print("Expected Determinant: -12");
        System.out.println();
        System.out.println();

        double[][] newValues10 = {{1, 2, 3}, {4, 5, 6}, {5, 7, 13}};
        matrix detMatrix3 = new matrix(3, 3, newValues10);

        System.out.print("Determinant: ");
        System.out.print(detMatrix3.determinant());

        System.out.println();
        System.out.println();

        System.out.println("matrix 4: ");
        System.out.println("Rows: 5");
        System.out.println("Columns: 5");
        System.out.print("Values: ");
        System.out.println("{{1, 2, 1, 0}, {0, 3, 1, 1}, {-1, 0, 3, 1}, {3, 1, 2, 0}}");
        System.out.print("Expected Determinant: 16");
        System.out.println();
        System.out.println();

        double[][] newValues11 = {{1, 2, 1, 0}, {0, 3, 1, 1}, {-1, 0, 3, 1}, {3, 1, 2, 0}};
        matrix detMatrix4 = new matrix(4, 4, newValues11);

        System.out.print("Determinant: ");
        System.out.print(detMatrix4.determinant());

        System.out.println();
        System.out.println();

        //Testing GJE.
        System.out.println("Gauss-Jordan Elimination: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: ");
        System.out.print("{{1, 0, 0}, {0, 1, 1}, {0, 2, 3}}");
        System.out.println();
        System.out.print("Augment 1: ");
        System.out.print("{{1}, {2}, {5}}");
        System.out.println();
        System.out.println();

        //matrix to be turned into an identity
        double[][] newValues12 = {{1, 0, 0}, {0, 1, 1}, {0, 2, 3}};
        matrix GJEmatrix = new matrix(3, 3, newValues12);
        System.out.println("Solved matrix: ");

        //Augmented matrix to be affected
        double[][] augValues = {{1}, {2}, {5}};
        matrix GJEaugment = new matrix(3, 1, augValues);

        //Solution matrix
        matrix GJEsolution = GJEmatrix.GJE(GJEaugment);
        GJEsolution.toString();

        System.out.println();
        System.out.println();

        System.out.print("Augment 2: ");
        System.out.print("{{1, 0, 0}, {0, 1, 0}, {0, 0 ,1}}");
        System.out.println();
        System.out.println();

        //matrix to be turned into an identity
        double[][] newValues13 = {{1, 0, 0}, {0, 1, 1}, {0, 2, 3}};
        matrix GJEmatrix2 = new matrix(3, 3, newValues13);
        System.out.println("Solved matrix: ");

        //Augmented matrix to be affected
        double[][] augValues2 = {{1, 0, 0}, {0, 1, 0}, {0, 0 ,1}};
        matrix GJEaugment2 = new matrix(3, 3, augValues2);

        //Solution matrix
        matrix GJEsolution2 = GJEmatrix2.GJE(GJEaugment2);
        GJEsolution2.toString();

        System.out.println();
        System.out.println();

        System.out.print("Augment 3: ");
        System.out.print("{{1, 0}, {2, 1}, {5, 1}}");
        System.out.println();
        System.out.println();

        //matrix to be turned into an identity
        double[][] newValues14 = {{1, 0, 0}, {0, 1, 1}, {0, 2, 3}};
        matrix GJEmatrix3 = new matrix(3, 3, newValues14);
        System.out.println("Solved matrix: ");

        //Augmented matrix to be affected
        double[][] augValues3 = {{1, 0}, {2, 1}, {5, 1}};
        matrix GJEaugment3 = new matrix(3, 2, augValues3);

        //Solution matrix
        matrix GJEsolution3 = GJEmatrix3.GJE(GJEaugment3);
        GJEsolution3.toString();

        System.out.println();
        System.out.println("Testing unequal row failure condition");

        //Testing unequal row failure condition
        double[][] newValues15 = {{1, 0, 0}, {0, 1, 1}, {0, 2, 3}};
        matrix GJEmatrix4 = new matrix(3, 3, newValues15);

        //Augmented matrix to be affected
        double[][] augValues4 = {{1, 0}, {2, 1}};
        matrix GJEaugment4 = new matrix(2, 2, augValues4);

        //Solution matrix
        matrix GJEsolution4 = GJEmatrix4.GJE(GJEaugment4);

        System.out.println();
        System.out.println("Testing rectangle origin matrix failure condition");

        //Testing non-square origin matrix failure condition
        double[][] newValues16 = {{1, 0, 0}, {0, 1, 1}, {0, 2, 3}, {3, 4, 5}};
        matrix GJEmatrix5 = new matrix(4, 3, newValues16);

        //Augmented matrix to be affected
        double[][] augValues5 = {{1, 0}, {2, 1}, {5, 1}, {6, 2}};
        matrix GJEaugment5 = new matrix(4, 2, augValues5);

        //Solution matrix
        matrix GJEsolution5 = GJEmatrix5.GJE(GJEaugment5);

        System.out.println();
        System.out.println("Testing row of zeroes failure condition");

        //Testing row of zeroes failure condition
        double[][] newValues17 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        matrix GJEmatrix6 = new matrix(3, 3, newValues17);

        //Augmented matrix to be affected
        double[][] augValues6 = {{1, 0}, {2, 1}, {5, 1}};
        matrix GJEaugment6 = new matrix(3, 2, augValues6);

        //Solution matrix
        matrix GJEsolution6 = GJEmatrix6.GJE(GJEaugment6);

        //Testing Negativity
        System.out.println("Gauss-Jordan Elimination w/ Negatives: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 2");
        System.out.println("Columns: 2");
        System.out.print("Values: ");
        System.out.print("{{-1, 2}, {3, -4}}");
        System.out.println();
        System.out.print("Augment 1: ");
        System.out.print("{{10}, {20}}");
        System.out.println();
        System.out.println();

        //matrix to be turned into an identity
        double[][] newValues18 = {{-1, 2}, {3, -4}};
        matrix GJEmatrix7 = new matrix(2, 2, newValues18);
        System.out.println("Solved matrix: ");

        //Augmented matrix to be affected
        double[][] augValues7 = {{10}, {20}};
        matrix GJEaugment7 = new matrix(2, 1, augValues7);

        //Solution matrix
        matrix GJEsolution7 = GJEmatrix7.GJE(GJEaugment7);
        GJEsolution7.toString();

        System.out.println();
        System.out.println();

        System.out.println("matrix 2: ");
        System.out.println("Rows: 3");
        System.out.println("Columns: 3");
        System.out.print("Values: ");
        System.out.print("{{-1, 2, 3}, {4, -5, -6}, {-7, 8, 9}");
        System.out.println();
        System.out.print("Augment 1: ");
        System.out.print("{{5}, {10}, {20}}");
        System.out.println();
        System.out.println();

        //matrix to be turned into an identity
        double[][] newValues19 = {{-1, 2, 3}, {4, -5, -6}, {-7, 8, 9}};
        matrix GJEmatrix8 = new matrix(3, 3, newValues19);
        System.out.println("Solved matrix: ");

        //Augmented matrix to be affected
        double[][] augValues8 = {{5}, {10}, {20}};
        matrix GJEaugment8 = new matrix(3, 1, augValues8);

        //Solution matrix
        matrix GJEsolution8 = GJEmatrix8.GJE(GJEaugment8);

        System.out.println();
        System.out.println();

        //Testing Determinant via GJE
        System.out.println("Gauss-Jordan Elimination to get Determinant: ");
        System.out.println("matrix 1: ");
        System.out.println("Rows: 2");
        System.out.println("Columns: 2");
        System.out.print("Values: ");
        System.out.print("{{1, 2}, {3, 4}}");
        System.out.println();
        System.out.println();

        //matrix
        double[][] newValues20 = {{1, 2}, {3, 4}};
        matrix GJEmatrix9 = new matrix(2, 2, newValues20);

        double nTrueDet = GJEmatrix9.determinant();
        double nDet = GJEmatrix9.det_ref();

        System.out.println("Normal determinant returns: " + nTrueDet);
        System.out.println("GJE determinant returns: " + nDet);
    }
}
