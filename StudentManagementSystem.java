import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 5);
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student Added Successfully");
    }

    static void viewStudents() {
        for(Student s : students) {
            System.out.println("ID: " + s.id + " Name: " + s.name + " Age: " + s.age + " Course: " + s.course);
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for(Student s : students) {
            if(s.id == id) {
                System.out.println("Found: " + s.name + " " + s.age + " " + s.course);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while(it.hasNext()) {
            Student s = it.next();
            if(s.id == id) {
                it.remove();
                System.out.println("Student Deleted");
                return;
            }
        }
        System.out.println("Student Not Found");
    }
}