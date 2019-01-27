import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int rows;
    private static int cols;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> matrix = new ArrayList<>();

        int[] sizes = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        rows = sizes[0];
        cols = sizes[1];

        int[][] bombs = readBombs(bufferedReader);

        int counter = 1;

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<Integer>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(counter);
                counter++;
            }
        }

        for (int i = 0; i < bombs.length; i++) {
            detonate(matrix, bombs[i][0], bombs[i][1], bombs[i][2]);
        }



        rearrangeMatrix(matrix);


        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void rearrangeMatrix(List<List<Integer>> matrix){

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j) == - 1){
                    matrix.get(i).remove(j);
                    j--;
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            if(matrix.get(i).size() == 0){
                matrix.remove(i);
                i--;
            }
        }
    }

    private static void detonate(List<List<Integer>> matrix, int row, int col, int radius) {
        try {
            if(radius == 0){
                matrix.get(row).set(col, - 1);
                rearrangeMatrix(matrix);
                return;
            }

        }
        catch (IndexOutOfBoundsException e){
            return;
        }

        detonateSides(matrix, row, col, radius);
        detonateUp(matrix, row, col, radius);
        detonateDown(matrix,row,col,radius);

        rearrangeMatrix(matrix);
    }


    private static void detonateSides(List<List<Integer>> matrix, int row, int col, int radius){

        try{
            matrix.get(row).set(col, -1);
        }
        catch (IndexOutOfBoundsException e){

        }


        int leftIndex = col;
        for (int i = 0; i < radius; i++) {
            if(col < 0 ){
                break;
            }
            try{
                leftIndex--;
                matrix.get(row).set(leftIndex, - 1);
            }
            catch(IndexOutOfBoundsException e){

            }
        }

        int rightIndex = col;


        for (int i = 0; i < radius; i++) {
            try {
                if(rightIndex > matrix.get(row).size()){
                    break;
                }
                rightIndex++;
                matrix.get(row).set(rightIndex, - 1);
            } catch (IndexOutOfBoundsException e) {

            }
        }

    }

    private static void detonateUp (List<List<Integer>> matrix, int row, int col, int radius){
        for (int i = 0; i <radius ; i++) {
            row--;
            try {
                matrix.get(row).set(col, - 1);
            }
            catch (IndexOutOfBoundsException e){
                if(row < 0){
                    break;
                }
            }

        }

    }

    private static void detonateDown (List<List<Integer>> matrix, int row, int col, int radius){
        for (int i = 0; i <radius ; i++) {
            row++;
            try {
                matrix.get(row).set(col, - 1);
            }
            catch (IndexOutOfBoundsException e){
                if(row > cols){
                    break;
                }
            }

        }
    }

    private static int[][] readBombs(BufferedReader bufferedReader) throws IOException {
        String input = bufferedReader.readLine();
        ArrayList<String> bombsInput = new ArrayList<>();

        while (!input.equals("Nuke it from orbit")){
            bombsInput.add(input);
            input = bufferedReader.readLine();
        }

        int[][] bombs = new int[bombsInput.size()][3];

        for (int i = 0; i < bombs.length; i++) {
            String[] currentBomb = bombsInput.get(i).split("\\s+");
            bombs[i][0] = Integer.parseInt(currentBomb[0]);
            bombs[i][1] = Integer.parseInt(currentBomb[1]);
            bombs[i][2] = Integer.parseInt(currentBomb[2]);
        }
        return bombs;
    }

}
