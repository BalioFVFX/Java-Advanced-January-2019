import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(bufferedReader.readLine());
        int cols = Integer.parseInt(bufferedReader.readLine());
        List<Area> areas = new ArrayList<>();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '-') {
                    Area area = new Area(i, j);
                    resolve(matrix, i, j, area);
                    areas.add(area);
                }
            }
        }

        System.out.printf("Total areas found: %s%n", areas.size());

        areas.sort((a1, a2) -> {
            int sizeSort = Integer.compare(a2.size, a1.size);

            if (sizeSort != 0) {
                return sizeSort;
            }

            int rowSort = Integer.compare(a1.startRow, a2.startRow);

            if (rowSort != 0) {
                return rowSort;
            }

            int colSort = Integer.compare(a1.startCol, a2.startCol);

            return colSort;

        });

        int counter = 1;
        for (Area area : areas) {
            System.out.printf("Area #%s at (%s, %s), size: %s%n",
                    counter++,
                    area.startRow,
                    area.startCol,
                    area.size);
        }

    }

    private static void resolve(char[][] matrix, int startRow, int startCol, Area area) {

        if (!isValid(matrix, startRow, startCol)) {
            return;
        }


        matrix[startRow][startCol] = 'V';
        area.incrementSize();
        resolve(matrix, startRow + 1, startCol, area);
        resolve(matrix, startRow, startCol + 1, area);
        resolve(matrix, startRow - 1, startCol, area);
        resolve(matrix, startRow, startCol - 1, area);


    }

    private static boolean isValid(char[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0) {
            return false;
        }

        if (col < 0 || col >= matrix[0].length) {
            return false;
        }

        if (matrix[row][col] == '*' || matrix[row][col] == 'V') {
            return false;
        }

        return true;
    }

    private static class Area {
        private int size;
        private int startRow;
        private int startCol;

        public Area(int startRow, int startCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.size = 0;
        }

        public void incrementSize() {
            this.size++;
        }

    }
}

