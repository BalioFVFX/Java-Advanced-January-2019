import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static char REPLACE_SYMBOL = '*';
    private static int rows;
    private static int cols;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        rows = Integer.parseInt(bufferedReader.readLine());
        cols = Integer.parseInt(bufferedReader.readLine());


        char[][] matrixA = createMatrix(bufferedReader);
        char[][] matrixB = createMatrix(bufferedReader);

        printDifference(matrixA, matrixB);
    }


    private static void printDifference(char[][] matrixA, char[][] matrixB){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrixA[i][j] == matrixB[i][j]){
                    System.out.print(matrixA[i][j] + " ");
                }
                else{
                    System.out.print(REPLACE_SYMBOL + " ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] createMatrix(BufferedReader bufferedReader) throws IOException {
        char matrix[][] = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = getCurrentRow(bufferedReader);
            matrix[i] = currentRow;
        }

        return matrix;
    }


    private static char[] getCurrentRow(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("\\s+");
        char[] result = new char[input.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = input[i].charAt(0);
        }

        return result;
    }

}
