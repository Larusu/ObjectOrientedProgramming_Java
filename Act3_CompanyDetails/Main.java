package Act3_CompanyDetails;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee[] employee = new Employee[5];

        for(int i = 0; i < 5; i++){
            System.out.println("\nEnter Details for Employee " + (i+1));
            System.out.print("Enter Name: ");
            String name = scan.nextLine();
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scan.nextLine());
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(scan.nextLine());
            System.out.print("Enter Role(Manager/Engineer/Intern): ");
            String role = scan.nextLine().trim().toLowerCase();

            switch(role){
                case "manager":
                System.out.println("Enter Department: ");
                String dept = scan.nextLine();
                employee[i] = new Manager(name, id, salary, dept);
                break;
                case "engineer":
                System.out.println("Enter Specialization: ");
                String special = scan.nextLine();
                employee[i] = new Engineer(name, id, salary, special);
                break;
                case "intern":
                System.out.println("Enter University: ");
                String univ = scan.nextLine();
                employee[i] = new Intern(name, id, salary, univ);
                break;
                default:
                System.out.println("Invalid role. Defaulting to base Employee");
                employee[i] = new Employee(name, id, salary);
            }
        } scan.close();

        System.out.println("\nEmployee Details:");
        for(Employee i : employee){
            i.displayDetails();
        }
    }
}
