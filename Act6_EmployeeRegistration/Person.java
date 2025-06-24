package Act6_EmployeeRegistration;

public abstract class Person{

    String name;
    int age;
    int contactDetails;

    public void setInfo(String name, int age, int contactDetails){
        this.name = name;
        this.age = age;
        this.contactDetails = contactDetails;
    }
}
