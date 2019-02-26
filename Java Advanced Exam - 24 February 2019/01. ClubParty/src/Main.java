import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static int MAX_CAPACITY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MAX_CAPACITY = Integer.parseInt(bufferedReader.readLine());
        List<String> input = Arrays.stream(bufferedReader.readLine().split("\\s+")).collect(Collectors.toList());
        Collections.reverse(input);
        List<Hall> halls = new ArrayList<>();
        for (String data : input) {
            if (Character.isDigit(data.charAt(0))) {
                if (halls.isEmpty()) {
                    continue;
                }
                Hall currentHall = halls.get(0);
                Long currentHallCapacity = currentHall.getCapacity();
                Long inputCapacity = Long.parseLong(data);
                if (currentHallCapacity + inputCapacity < MAX_CAPACITY) {
                    currentHall.reservations.add(inputCapacity);
                } else if (currentHallCapacity + inputCapacity > MAX_CAPACITY) {
                    System.out.println(currentHall);
                    halls.remove(0);
                    if (!halls.isEmpty()) {
                        while (!halls.isEmpty()) {
                            Hall hall = halls.get(0);
                            if (hall.getCapacity() + inputCapacity > MAX_CAPACITY) {
                                System.out.println(hall);
                                halls.remove(0);
                            }
                            else if(hall.getCapacity() + inputCapacity < MAX_CAPACITY){
                                hall.reservations.add(inputCapacity);
                                break;
                            }
                            else if(hall.getCapacity() + inputCapacity >= MAX_CAPACITY){
                                hall.reservations.add(inputCapacity);
                                break;
                            }
                        }
                    }
                    else {
                        continue;
                    }
                } else {
                    currentHall.reservations.add(inputCapacity);
                    //System.out.println(currentHall);
                    //halls.remove(0);
                }

            } else {
                halls.add(new Hall(data));
            }
        }
    }

    private static class Hall {
        private String name;
        private List<Long> reservations;

        public Hall(String name) {
            this.name = name;
            this.reservations = new ArrayList<>();
        }

        public Long getCapacity() {
            if (reservations.size() == 0) {
                return 0L;
            }

            Long sum = 0L;

            for (int i = 0; i < reservations.size(); i++) {
                sum += reservations.get(i);
            }
            return sum;
        }

        public boolean isEmpty() {
            return this.getCapacity() == 0;
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < reservations.size(); i++) {
                stringBuilder.append(reservations.get(i)).append(", ");
            }
            return String.format("%s -> %s",
                    this.name,
                    stringBuilder.substring(0, stringBuilder.length() - 2).trim()).trim();
        }
    }

}
