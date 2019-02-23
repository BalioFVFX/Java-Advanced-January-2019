import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int snakeRow;
    private static int snakeCol;
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfFood = 0;
        int snakeLength = 1;
        snakeRow = -1;
        snakeCol = -1;

        int screenSize = Integer.parseInt(bufferedReader.readLine());

        String[] commands = bufferedReader.readLine().split(", ");

        matrix = new String[screenSize][screenSize];

        for (int i = 0; i < screenSize; i++) {
            matrix[i] = bufferedReader.readLine().split("\\s+");
            numberOfFood += Arrays.stream(matrix[i]).filter(element -> element.equals("f")).toArray().length;
            if (snakeRow == -1) {
                int[] positions = getSnakePosition(i, matrix[i]);
                if (positions != null) {
                    snakeRow = positions[0];
                    snakeCol = positions[1];
                    matrix[snakeRow][snakeCol] = "*";
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            moveSnake(currentCommand);

            if (snakeStepOnFood()) {
                snakeLength++;
                numberOfFood--;
            }
            if (numberOfFood == 0) {
                System.out.printf("You win! Final snake length is %s%n", snakeLength);
                return;
            }

            if (snakeStepOnEnemey()) {
                System.out.printf("You lose! Killed by an enemy!%n");
                return;
            }
        }

        System.out.printf("You lose! There is still %s food to be eaten.", numberOfFood);
    }

    private static boolean snakeStepOnEnemey() {
        if (matrix[snakeRow][snakeCol].equals("e")) {
            return true;
        }
        return false;
    }

    private static boolean snakeStepOnFood() {
        if (matrix[snakeRow][snakeCol].equals("f")) {
            matrix[snakeRow][snakeCol] = "*";
            return true;
        }
        return false;
    }

    private static void moveSnake(String direction) {
        if (direction.equals("up")) {
            snakeRow--;
        } else if (direction.equals("down")) {
            snakeRow++;
        } else if (direction.equals("left")) {
            snakeCol--;
        } else if (direction.equals("right")) {
            snakeCol++;
        }

        validateSnakePosition();
    }

    private static void validateSnakePosition() {
        if (snakeRow < 0) {
            snakeRow = matrix.length - 1;
        }
        if (snakeRow > matrix.length) {
            snakeRow = 0;
        }
        if (snakeCol < 0) {
            snakeCol = matrix[0].length - 1;
        }
        if (snakeCol > matrix[0].length - 1) {
            snakeCol = 0;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == snakeRow && j == snakeCol) {
                    System.out.print("s");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[] getSnakePosition(int row, String[] col) {
        for (int i = 0; i < col.length; i++) {
            if (col[i].equals("s")) {
                return new int[]{row, i};
            }
        }
        return null;
    }
}
