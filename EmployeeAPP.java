import java.io.*;
import java.util.*;

class Employee {
    private String name;
    private String id;
    private String designation;
    private double salary;

    public Employee(String name, String id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | " + id + " | " + designation + " | " + salary;
    }
}

public class EmployeeApp {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Add Employee and write to file
    private static void addEmployee(Scanner sc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Designation: ");
            String designation = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            Employee emp = new Employee(name, id, designation, salary);
            writer.write(emp.toString());
            writer.newLine();

            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
        }
    }

    // Display all employees from file
    private static void displayEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nEmployee List:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employees found. File not created yet!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}
