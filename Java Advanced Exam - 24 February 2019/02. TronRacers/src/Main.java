import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int F_ROW = -1;
    private static int F_COL = -1;
    private static int S_ROW = -1;
    private static int S_COL = - 1;
    private static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(bufferedReader.readLine());

        matrix = new String[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = bufferedReader.readLine().split("");
            if(!playerFound()){
                getPlayersPositions(matrix[i], i);
            }
        }

        while (true){
            String[] lines = bufferedReader.readLine().split("\\s+");
            boolean isFAlive = moveF(lines[0]);

            if(isFAlive){
                matrix[F_ROW][F_COL] = "f";
            }
            else{
                matrix[F_ROW][F_COL] = "x";
                break;
            }

            boolean isSAlive = moveS(lines[1]);

            if(isSAlive){
                matrix[S_ROW][S_COL] = "s";
            }
            else{
                matrix[S_ROW][S_COL] = "x";
                break;
            }

        }
        printMatrix();
    }


    private static void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean moveF(String direction){
        if(direction.equals("up")){
            F_ROW--;
        } else if(direction.equals("down")){
            F_ROW++;

        } else if (direction.equals("left")) {
            F_COL--;
        }
        else if(direction.equals("right")){
            F_COL++;
        }

        if(F_ROW < 0){
            F_ROW = matrix.length - 1;
        }
        if(F_ROW > matrix.length - 1){
            F_ROW = 0;
        }

        if(F_COL < 0){
            F_COL = matrix[0].length - 1;
        }

        if(F_COL > matrix[0].length - 1){
            F_COL = 0;
        }

        if(matrix[F_ROW][F_COL].equals("s")){
            return false;
        }
        return true;
    }

    private static boolean moveS(String direction){
        if(direction.equals("up")){
            S_ROW--;
        } else if(direction.equals("down")){
            S_ROW++;

        } else if (direction.equals("left")) {
            S_COL--;
        }
        else if(direction.equals("right")){
            S_COL++;
        }

        if(S_ROW < 0){
            S_ROW = matrix.length - 1;
        }
        if(S_ROW > matrix.length - 1){
            S_ROW = 0;
        }

        if(S_COL < 0){
            S_COL = matrix[0].length - 1;
        }

        if(S_COL > matrix[0].length - 1){
            S_COL = 0;
        }

        if(matrix[S_ROW][S_COL].equals("f")){
            return false;
        }
        return true;
    }

    private static void getPlayersPositions(String[] row, int currentRow){
        for (int i = 0; i < row.length; i++) {
            if(row[i].equals("s")){
                S_ROW = currentRow;
                S_COL = i;
            }
            if(row[i].equals("f")){
                F_ROW = currentRow;
                F_COL = i;
            }
        }
    }

    private static boolean playerFound(){
        if(S_COL != -1 && F_COL != -1){
            return true;
        }
        return false;
    }
}