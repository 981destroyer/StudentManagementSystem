import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeLevel;
    private int inpCourse;

    private int tuition;
    Scanner studentscan = new Scanner(System.in);

    ArrayList<Integer> courses = new ArrayList<Integer>();

    public Student() {
            System.out.println("Enter the first name:");
            firstName = studentscan.nextLine();
            System.out.println("Enter the last name:");
            lastName = studentscan.nextLine();
            System.out.println("Enter the grade level (10-13):");
            gradeLevel = studentscan.nextLine();
            setstudentID();
            System.out.println(firstName + " " + lastName + " " + gradeLevel);
    }

    public void setstudentID() {
        gradeLevel = gradeLevel + "00" + Database.getId();
    }

    public void calculateTuition() {
        int obj = Collections.max(courses);
        int index = courses.indexOf(obj)+1;
        tuition = index*600;
    }

    public void coursesEnrolled() {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i) == 1) {
                System.out.println("History");
            } else if (courses.get(i) == 2) {
                System.out.println("Mathematics");
            } else if (courses.get(i) == 3) {
                System.out.println("English");
            } else if (courses.get(i) == 4) {
                System.out.println("Chemistry");
            } else if (courses.get(i) == 5) {
                System.out.println("Computer Science");
            }
        }

    }

    public void enroll() {
        System.out.println("Choose from the following coures: \n" +
                "1 History 101 \n" +
                "2 Mathematics 101 \n" +
                "3 English 101 \n" +
                "4 Chemistry 101 \n" +
                "5 Computer Science 101 \n" +
                "Press any other number to quit");

        inpCourse = studentscan.nextInt();
        while (inpCourse == 1 || inpCourse == 2 || inpCourse == 3 || inpCourse == 4 || inpCourse == 5) {
            courses.add(inpCourse);
            System.out.println("You've successfully enrolled in: ");
            coursesEnrolled();
            inpCourse = studentscan.nextInt();
        }
    }

    public void viewBalance() {
        System.out.println("Your tuition balance is " + tuition + "€");
    }

    public void pay() {
        System.out.println("How much would you like to pay?");
        int payAmount = studentscan.nextInt();
        if(payAmount > tuition) {
            System.out.println("You can't pay more than your tuition is");
        } else {
            tuition -= payAmount;
            System.out.print("Thank you for your payment! ");
            viewBalance();
        }
    }

    public void showStatus() {
        System.out.println(" ");
        System.out.println("Status:");
        System.out.println(firstName + " " + lastName + " " + gradeLevel);
        System.out.println(" ");
        System.out.println("Courses enrolled:");
        coursesEnrolled();
        System.out.println(" ");
        viewBalance();
    }

}
