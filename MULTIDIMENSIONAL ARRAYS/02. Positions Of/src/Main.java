import java.rmi.activation.ActivationGroupDesc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);
        int searchedNumber = scanner.nextInt();

        List<String> positions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == searchedNumber){
                    positions.add(i + " " + j);
                }
            }
        }

        if(positions.size() > 0){
            System.out.println(String.join("\n", positions));
        }
        else {
            System.out.println("not found");
        }
    }

    private static int[][] createMatrix(Scanner scanner){

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = currentRow;
        }
        return matrix;
    }
}
