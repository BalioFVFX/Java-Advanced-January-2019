public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(6);
        smartArray.insert(5, 120);

        smartArray.forEach(integer -> {
            System.out.println(integer);
        });

        System.out.println(smartArray.contains(120));
        System.out.println(smartArray.contains(10));
    }
}
