package Act5_EmployeePayrollSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> emp = new ArrayList<Employee>();

        initializingData(emp);
        
        for(Employee e : emp){
            System.out.println(e.name + " (ID: " + e.id + "): $" + e.calculateSalary());
        }

    }

    static void initializingData(ArrayList<Employee> emp){
        Scanner scan = new Scanner(System.in);
        char choice = ' ';
        int count = 1;
        

        while(choice != 'n' && choice != 'N'){

            Employee tempEmp = new Employee(" ");
            try{

                System.out.println("\nEmployee " + (Employee.count + count) + ":");
                System.out.print("Name: ");
                String name = scan.nextLine().trim();
                System.out.print("Type (1 = Full Time, 2 = Part-Time, 3 = Intern): ");
                int type = Integer.parseInt(scan.nextLine());

                switch(type){
                    case 1:
                        tempEmp = new FullTimeEmployee(name);
                        break;
                    case 2:
                        tempEmp = new PartTimeEmployee(name);
                        break;
                    case 3:
                        tempEmp = new Intern(name);
                        break;
                }
                tempEmp.id += count;

                chooseSpecificData(tempEmp, scan);

                emp.add(tempEmp);
                System.out.println();
            }
            catch(NumberFormatException e){
                System.err.println("\nInvalid number format! Try again!");
                return;
            }  
            count++;

            System.out.print("Do you want to continue (type 'Y' or 'N'): ");
            String strChoice = scan.nextLine().trim();
            choice = strChoice.charAt(0);
        }

        scan.close();

    }

    static void chooseSpecificData(Employee n, Scanner scan){

        // Changing the value of the variable on the class directly
        if(n instanceof FullTimeEmployee){
            System.out.print("Monthly salary: ");
            ((FullTimeEmployee)n).monthlySalary = Double.parseDouble(scan.nextLine());

        }else if(n instanceof PartTimeEmployee){
            System.out.print("Hours worked: ");
            ((PartTimeEmployee)n).hoursWorked = Double.parseDouble(scan.nextLine());
            System.out.print("Hourly rate: ");
            ((PartTimeEmployee)n).hourlyRate = Double.parseDouble(scan.nextLine());

        }else if(n instanceof Intern){
            System.out.print("Stipend: ");
            ((Intern)n).stipend = Double.parseDouble(scan.nextLine());
        }
        System.out.println();
    }
}
