import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rotation = Integer.parseInt(bufferedReader.readLine().split("\\(")[1].replace(')', ' ').trim()) % 360;
        String text = bufferedReader.readLine();

        List<String> texts = new ArrayList<>();
        int longestText = Integer.MIN_VALUE;
        while (!text.equals("END")) {
            if (text.length() > longestText) {
                longestText = text.length();
            }
            texts.add(text);
            text = bufferedReader.readLine();
        }

        char[][] matrix = new char[texts.size()][longestText];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j < texts.get(i).length()) {
                    matrix[i][j] = texts.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }
        switch (rotation) {
            case 90:
                rotate90(matrix);
                break;
            case 180:
                rotate180(matrix);
                break;
            case 270:
                rotate270(matrix);
                break;
            default:
                rotate360(matrix);
                break;
        }
    }

    private static void rotate90(char[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate360(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


    private static void rotate180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate270(char[][] matrix) {
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
