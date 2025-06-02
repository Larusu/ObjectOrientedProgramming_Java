package Act3_CompanyDetails;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public String getName(){return name;}
    public int getID(){return id;}
    public double getSalary(){return salary;}
    
    public void displayDetails(){
        System.out.println("Name:" + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee{
    private String department;

    public Manager(String name, int id, double salary, String department){
        super(name, id, salary);
        this.department = department;
    }
    public String setDepartment(String department){return this.department = department;}
    @Override
    public void displayDetails(){
        System.out.println("MANAGER Name:" + getName() + ", ID: " + getID() + ", Salary: " + getSalary() + ", Department: " + department);
    }
}
class Engineer extends Employee{
    private String specialization;

    public Engineer(String name, int id, double salary, String specialization){
        super(name, id, salary);
        this.specialization = specialization;
    }
    public String setSpecialization(String specialization){return this.specialization = specialization;}

    @Override
    public void displayDetails(){
        System.out.println("ENGINEER Name:" + getName() + ", ID: " + getID() + ", Salary: " + getSalary() + ", Specialization: " + specialization);
    }
}

class Intern extends Employee{
    private String university;

    public Intern(String name, int id, double salary, String university){
        super(name, id, salary);
        this.university = university;
    }
    public String setUniversity(String university){return this.university = university;}

    @Override
    public void displayDetails(){
        System.out.println("INTERN Name:" + getName() + ", ID: " + getID() + ", Salary: " + getSalary() + ", University: " + university);
    }
}

