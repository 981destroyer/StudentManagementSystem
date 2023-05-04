import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Database {
    private static int numberOfStudents;
    private static int id;

    public static int getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("How many students will be added to the database?");
            numberOfStudents = scanner.nextInt();
            Student[] students = new Student[numberOfStudents+1];
            for (int i=1; i < numberOfStudents+1; i++) {
                id =  i;
                students[i] = new Student();
                students[i].enroll();
                students[i].calculateTuition();
                students[i].pay();
            }

            System.out.println("Select Student you want to show the status of: ");
            int selectedStudent = scanner.nextInt();
            students[selectedStudent].showStatus();

        } catch (InputMismatchException e) {
            System.out.println("False datatype, type in a number");
        }



    }


}