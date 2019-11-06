public class MatrixTester
{
    //Test area
    public static void main(String[] args)
    {
        //Testing Identity matrix
        System.out.println("Identity matrix: ");
        System.out.println("Size: 5");
        System.out.println();

        matrix newMatrix = new matrix(4);
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

        //Testing matrix scaling
        System.out.println("Matrix Scaling: ");
        System.out.println("Generate matrix scaled to 2 3 4");
        System.out.println();

        double[][] newValues3 = {{1, 2, 3}, {2, 3, 4}, {1, 1, 1}};
        matrix newMatrix5 = new matrix(3, 3, newValues3);

        matrix scaledMatrix = newMatrix5.Createscale(2, 3, 4);
        System.out.println("Matrix: ");
        scaledMatrix.toString();
        System.out.println();

        //Testing matrix multiplication
        System.out.println("Matrix Composition: ");
        System.out.println("Matrix 1: ");
        System.out.println("Rows: 4");
        System.out.println("Columns: 4");
        System.out.print("Values: {{1, 0, 2, 0}, {1, 3, 4, 0}, {5, 1, 2, 0}, {0, 0, 0, 1}}");
        System.out.println();
        System.out.println();
        System.out.println("Matrix 2: ");
        System.out.println("Rows: 4");
        System.out.println("Columns: 4");
        System.out.print("Values: {{2, 1, 2, 0}, {0, 2, 1, 0}, {4, 10, 1, 0}, {0, 0, 0, 1}}");
        System.out.println();
        System.out.println();

        double[][] newValues4 = {{1, 0, 2, 0}, {1, 3, 4, 0}, {5, 1, 2, 0}, {0, 0, 0, 1}};
        matrix firstMultiple = new matrix(4, 4, newValues4);

        double[][] newValues5 = {{2, 1, 2, 0}, {0, 2, 1, 0}, {4, 10, 1, 0}, {0, 0, 0, 1}};
        matrix secondMultiple = new matrix(4, 4, newValues5);

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
    }
}
