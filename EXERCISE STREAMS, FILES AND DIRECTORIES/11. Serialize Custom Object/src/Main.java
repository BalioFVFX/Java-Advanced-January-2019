import java.io.*;

public class Main {

    private final static String DESTINATION = "C:\\Users\\Erik\\Desktop\\Destination\\course.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DESTINATION));

        Course course = new Course("Programming Basics With Java", 250);

        objectOutputStream.writeObject(course);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DESTINATION));

        Course myReturnedCourse = (Course) objectInputStream.readObject();

        System.out.println("Course name: " + myReturnedCourse.getName());
        System.out.println("Number of students: " + myReturnedCourse.getNumberOfStudents());
    }
}
