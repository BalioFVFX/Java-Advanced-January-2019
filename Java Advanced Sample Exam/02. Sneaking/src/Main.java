import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static int SAM_ROW = -1;
    private static int SAM_COL = -1;
    private static int NIKOLADZE_ROW = -1;
    private static int NIKOLADZE_COL = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRows = Integer.parseInt(bufferedReader.readLine());

        String[][] matrix = new String[numberOfRows][];


        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = bufferedReader.readLine().split("");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    SAM_ROW = i;
                    SAM_COL = j;
                    matrix[i][j] = ".";
                }
                if (matrix[i][j].equals("N")) {
                    NIKOLADZE_ROW = i;
                    NIKOLADZE_COL = j;
                }
            }
            if (SAM_ROW != -1 && SAM_COL != -1 &&
                    NIKOLADZE_ROW != -1 && NIKOLADZE_COL != -1) {
                break;
            }
        }

        ArrayDeque<String> commands = new ArrayDeque<>(Arrays.asList(bufferedReader.readLine().split("")));

        while (!commands.isEmpty()) {
            String command = commands.pop();
            moveEnemies(matrix);

            boolean isSamDead = enemyKillsSam(matrix);

            if (isSamDead) {
                System.out.printf("Sam died at %s, %s%n", SAM_ROW, SAM_COL);
                matrix[SAM_ROW][SAM_COL] = "X";
                printMatrix(matrix);
                return;
            }

            move(command, matrix);

            boolean isNikoladzeDead = samKillsNikoladze(matrix);

            if (isNikoladzeDead) {
                System.out.println("Nikoladze killed!");
                matrix[NIKOLADZE_ROW][NIKOLADZE_COL] = "X";
                break;
            }
        }
        matrix[SAM_ROW][SAM_COL] = "S";
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean move(String direction, String[][] matrix) {
        switch (direction) {
            case "U":
                SAM_ROW--;
                break;
            case "D":
                SAM_ROW++;
                break;
            case "L":
                SAM_COL--;
                break;
            case "R":
                SAM_COL++;
                break;
            case "W":
                break;
        }
        //matrix[SAM_ROW][SAM_COL] = "S";
        if (stepsOnEnemy(matrix)) {
            matrix[SAM_ROW][SAM_COL] = ".";
            return false;
        }

        if (enemyKillsSam(matrix)) {
            return true;
        } else {
            return false;
        }
    }


    private static boolean samKillsNikoladze(String[][] matrix) {
        if (SAM_ROW == NIKOLADZE_ROW) {
            return true;
        }
        return false;
    }

    private static boolean enemyKillsSam(String[][] matrix) {
        String[] row = matrix[SAM_ROW];


        for (int enemyCol = 0; enemyCol < row.length; enemyCol++) {
            if (row[enemyCol].equals("d")) {
                if (enemyCol >= SAM_COL) {
                    return true;
                }
            } else if (row[enemyCol].equals("b")) {
                if (enemyCol <= SAM_COL) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean stepsOnEnemy(String[][] matrix) {
        if (matrix[SAM_ROW][SAM_COL].equals("d")) {
            return true;
        }
        if (matrix[SAM_ROW][SAM_COL].equals("b")) {
            return true;
        }
        return false;
    }

    // D -> Goes Left
    // B -> Goes Right
    private static void moveEnemies(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("d")) {
                    if (col == 0) {
                        matrix[row][col] = "b";
                        break;
                    } else {
                        matrix[row][col - 1] = "d";
                        matrix[row][col] = ".";
                        break;
                    }
                } else if (matrix[row][col].equals("b")) {
                    if (col == matrix[row].length - 1) {
                        matrix[row][col] = "d";
                        break;
                    } else {
                        matrix[row][col + 1] = "b";
                        matrix[row][col] = ".";
                        break;
                    }
                }
            }
        }
    }
}
