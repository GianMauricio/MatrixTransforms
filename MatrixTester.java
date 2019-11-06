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
    }
}
