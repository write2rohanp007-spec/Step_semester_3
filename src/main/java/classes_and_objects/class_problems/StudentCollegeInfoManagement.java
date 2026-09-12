package classes_and_objects.class_problems;

/**
 * Category C Practice - Problem M5: Student and College Information Management
 */
public class StudentCollegeInfoManagement {

    static class Student {
        String name;
        int attendance;

        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Meera", 88);
        new Student("Arjun", 92);

        Student.printCollegeInfo();
    }
}
