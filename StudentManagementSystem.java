import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String rollNo;
    String name;
    String department;
    String semester;

    double attendance;

    String subject1 = "ADIC";
    String subject2 = "MPMC";
    String subject3 = "IQTA";
    String subject4 = "AWP";
    String subject5 = "JAVA";

    double marks1, marks2, marks3, marks4,marks5;

    Student(String rollNo, String name, String department,
            String semester, double attendance,
            double marks1, double marks2,
            double marks3, double marks4,double marks5) {

        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.attendance = attendance;

        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
    }

    double totalMarks() {
        return marks1 + marks2 + marks3 + marks4+ marks5;
    }

    double percentage() {
        return totalMarks() / 5.0;
    }

    String grade() {
        double p = percentage();

        if (p >= 90) {
            return "S";
        } else if (p >= 80) {
            return "A";
        } else if (p >= 70) {
            return "B";
        } else if (p >= 60) {
            return "C";
        } else if (p >= 50) {
            return "D";
        } else if (p >= 35) {
            return "E";
        }else {
            return "F";
        }
    }

    String result() {
        if (marks1 >= 35 && marks2 >= 35
                && marks3 >= 35 && marks4 >= 35 && marks5 >= 35) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    void display() {

        System.out.println("\n===== STUDENT DETAILS =====");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Semester    : " + semester);
        System.out.println("Attendance  : " + attendance + "%");

        System.out.println("\n===== SUBJECT-WISE MARKS =====");
        System.out.println(subject1 + " : " + marks1);
        System.out.println(subject2 + " : " + marks2);
        System.out.println(subject3 + " : " + marks3);
        System.out.println(subject4 + " : " + marks4);
        System.out.println(subject5 + " : " + marks5);

        System.out.println("------------------------------");
        System.out.println("Total Marks : " + totalMarks() + "/500");
        System.out.println("Percentage  : " + percentage() + "%");
        System.out.println("Grade       : " + grade());
        System.out.println("Result      : " + result());
        System.out.println("==============================");
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Attendance");
            System.out.println("5. Update Subject Marks");
            System.out.println("6. Generate Report Card");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine().trim();

                    boolean exists = false;

                    for (Student s : students) {
                        if (s.rollNo.equalsIgnoreCase(roll)) {
                            exists = true;
                            break;
                        }
                    }

                    if (roll.isEmpty() || exists) {
                        System.out.println(
                            "Invalid or duplicate roll number!"
                        );
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Semester: ");
                    String semester = sc.nextLine();

                    System.out.print("Enter Attendance Percentage: ");
                    double attendance = sc.nextDouble();

                    System.out.println("\nEnter Subject Marks (0-100)");

                    System.out.print("ADIC: ");
                    double m1 = sc.nextDouble();

                    System.out.print("MPMC: ");
                    double m2 = sc.nextDouble();

                    System.out.print("IQTA: ");
                    double m3 = sc.nextDouble();
                
                    System.out.print("AWP: ");
                    double m4 = sc.nextDouble();

                    System.out.print("JAVA: ");
                    double m5 = sc.nextDouble();
                    sc.nextLine();

                    if (name.trim().isEmpty()
                            || department.trim().isEmpty()
                            || semester.trim().isEmpty()
                            || attendance < 0 || attendance > 100
                            || m1 < 0 || m1 > 100
                            || m2 < 0 || m2 > 100
                            || m3 < 0 || m3 > 100
                            || m4 < 0 || m4 > 100
                            || m5 < 0 || m5 > 100) {

                        System.out.println("Invalid input!");
                        break;
                    }

                    Student student = new Student(
                        roll, name, department, semester,
                        attendance, m1, m2, m3, m4, m5 );

                    students.add(student);

                    System.out.println(
                        "Student added successfully!"
                    );
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    String searchRoll = sc.nextLine().trim();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo.equalsIgnoreCase(searchRoll)) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll Number: ");
                    String attendanceRoll = sc.nextLine().trim();

                    found = false;

                    for (Student s : students) {
                        if (s.rollNo.equalsIgnoreCase(attendanceRoll)) {

                            System.out.print(
                                "Enter New Attendance Percentage: "
                            );
                            double newAttendance = sc.nextDouble();
                            sc.nextLine();

                            if (newAttendance >= 0
                                    && newAttendance <= 100) {
                                s.attendance = newAttendance;
                                System.out.println(
                                    "Attendance updated successfully!"
                                );
                            } else {
                                System.out.println(
                                    "Invalid attendance percentage!"
                                );
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll Number: ");
                    String marksRoll = sc.nextLine().trim();

                    found = false;

                    for (Student s : students) {
                        if (s.rollNo.equalsIgnoreCase(marksRoll)) {

                            System.out.println("1. ADIC");
                            System.out.println("2. MPMC");
                            System.out.println("3. IQTA");
                            System.out.println("4. AWP ");
                            System.out.println("5. java");

                            System.out.print("Choose Subject: ");
                            int sub = sc.nextInt();

                            System.out.print("Enter New Marks: ");
                            double newMarks = sc.nextDouble();
                            sc.nextLine();

                            if (newMarks < 0 || newMarks > 100) {
                                System.out.println("Invalid marks!");
                                found = true;
                                break;
                            }

                            switch (sub) {
                                case 1:
                                    s.marks1 = newMarks;
                                    break;
                                case 2:
                                    s.marks2 = newMarks;
                                    break;
                                case 3:
                                    s.marks3 = newMarks;
                                    break;
                                case 4:
                                    s.marks4 = newMarks;
                                    break;
                                    case 5:
                                    s.marks5 = newMarks;
                                    break;
                                default:
                                    System.out.println(
                                        "Invalid subject choice!"
                                    );
                                    found = true;
                                    continue;
                            }

                            System.out.println("Marks updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Roll Number for Report: ");
                    String reportRoll = sc.nextLine().trim();

                    found = false;

                    for (Student s : students) {
                        if (s.rollNo.equalsIgnoreCase(reportRoll)) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 7:
                    System.out.println(
                        "Thank you for using the Student Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

    }
}
