import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final static byte ROWS = 8;
    private final static byte COLS = 8;

    private final static char QUEEN = 'q';
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = createMatrix(bufferedReader);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(matrix[i][j] == QUEEN){
                    if(isRealQueen(matrix, i, j)){
                        System.out.println(i + " " + j );
                    }
                }
            }
        }

    }

    private static boolean isRealQueen(char[][] matrix, int currentRow, int currentCol){
        return  isLeftFree(matrix, currentRow, currentCol - 1) &&
                isUpFree(matrix, currentRow - 1, currentCol) &&
                isRightFree(matrix, currentRow, currentCol + 1) &&
                isBottomFree(matrix, currentRow + 1, currentCol) &&
                isLeftUpDiagonalFree(matrix, currentRow - 1, currentCol - 1) &&
                isRightUpDiagonalFree(matrix, currentRow - 1, currentCol + 1) &&
                isLeftDownDiagonalFree(matrix, currentRow + 1, currentCol - 1) &&
                isRightDownDiagonalFree(matrix, currentRow + 1, currentCol + 1);
    }

    private static char[][] createMatrix(BufferedReader bufferedReader) throws IOException {
        char matrix[][] = new char[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
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

    private static boolean isLeftFree(char[][] matrix, int currentRow, int currentCol){
        if(currentCol == 0){
            return true;
        }

        for (int i = currentCol; i >= 0 ; i--) {
            if(matrix[currentRow][i] == QUEEN){
                return false;
            }
        }
        return true;
    }

    private static boolean isUpFree(char[][] matrix, int currentRow, int currentCol){
        if(currentRow == 0){
            return true;
        }

        for (int i = currentRow; i >= 0 ; i--) {
            if(matrix[i][currentCol] == QUEEN){
                return false;
            }
        }
        return true;
    }

    private static boolean isRightFree(char[][] matrix, int currentRow, int currentCol){
        if(currentCol == matrix[0].length){
            return true;
        }

        for (int i = currentCol; i < matrix[0].length; i++) {
            if(matrix[currentRow][currentCol] == QUEEN){
                return false;
            }

        }
        return true;
    }


    private static boolean isBottomFree(char[][] matrix, int currentRow, int currentCol){
        if (currentRow == matrix.length - 1){
            return true;
        }

        for (int i = currentRow; i < matrix.length; i++) {
            if(matrix[i][currentCol] == QUEEN){
                return false;
            }
        }
        return true;
    }


    private static boolean isLeftUpDiagonalFree(char[][] matrix, int currentRow, int currentCol){
        if(currentRow == 0 || currentCol == 0){
            return true;
        }

        while (currentRow >= 0 && currentCol >= 0){
            if(matrix[currentRow][currentCol] == QUEEN){
                return false;
            }
            currentRow--;
            currentCol--;
        }

        return true;
    }

    private static boolean isRightUpDiagonalFree(char[][] matrix, int currentRow, int currentCol){
        if(currentRow == 0 || currentCol == matrix[0].length - 1){
            return true;
        }

        while (currentRow >= 0 && currentCol < matrix[0].length){
            if(matrix[currentRow][currentCol] == QUEEN){
                return false;
            }
            currentRow--;
            currentCol++;
        }
        return true;
    }

    private static boolean isLeftDownDiagonalFree(char[][] matrix, int currentRow, int currentCol){
        if(currentRow == matrix.length - 1 || currentCol == 0){
            return true;
        }

        while (currentRow < matrix.length && currentCol >= 0){
            if(matrix[currentRow][currentCol] == QUEEN){
                return false;
            }
            currentRow++;
            currentCol--;
        }

        return true;
    }

    private static boolean isRightDownDiagonalFree(char[][] matrix, int currentRow, int currentCol){
        if(currentRow == matrix.length - 1 || currentCol == matrix[0].length - 1){
            return true;
        }

        while(currentRow < matrix.length && currentCol < matrix[0].length){
            if(matrix[currentRow][currentCol] == QUEEN){
                return false;
            }

            currentRow++;
            currentCol++;
        }
        return true;
    }
}