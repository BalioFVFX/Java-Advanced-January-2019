import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    private static  ArrayDeque<Integer> binaryStack;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = scanner.nextInt();
        binaryStack = convertToBinary(decimal);
        output(binaryStack);

    }

    private static ArrayDeque<Integer> convertToBinary(int decimal){
        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();
        if(decimal == 0){
            binaryStack.push(0);
            return binaryStack;
        }
        while(decimal != 0){
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }
        return binaryStack;
    }

    private static void output(ArrayDeque<Integer> binaryStack){
        StringBuilder output = new StringBuilder();
        while (!binaryStack.isEmpty()){
            output.append(binaryStack.pop().toString());
        }
        System.out.println(output.toString());
    }
}
