package Act6_EmployeeRegistration;

public abstract class Person{

    String name;
    int age;
    String[] contactDetails = new String[2];

    public void setInfo(String name, int age, String[] contactDetails){
        this.name = name;
        this.age = age;
        this.contactDetails = contactDetails;
    }
}
