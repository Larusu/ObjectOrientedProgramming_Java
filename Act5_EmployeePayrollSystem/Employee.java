package Act5_EmployeePayrollSystem;

public class Employee{

    String name;
    int id = count;
    public static int count = 100;

    Employee(String name){
        this.name = name;
        this.id = count;
    }
    
    double calculateSalary(){ return 0.0; }
}

class FullTimeEmployee extends Employee{

    FullTimeEmployee(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    double monthlySalary;

    @Override
    double calculateSalary(){ return monthlySalary; }
}

class PartTimeEmployee extends Employee{


    PartTimeEmployee(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    double hoursWorked;
    double hourlyRate;

    @Override
    double calculateSalary(){ return hoursWorked * hourlyRate; }
}

class Intern extends Employee{

    Intern(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    double stipend;

    @Override
    double calculateSalary(){ return stipend; }
}
