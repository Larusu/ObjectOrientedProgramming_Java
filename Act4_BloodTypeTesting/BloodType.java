package Act4_BloodTypeTesting;

public class BloodType{
    String name;
    int age; 
    String bloodType;

    BloodType(String name, int age){
        this.name = name;
        this.age = age;
    }

    void printDetails(){
        System.out.println("\nName: " + name);
        System.out.println("Age: " + age);
        System.out.println("Bloodtype: " + bloodType);
    }
    
    void processBloodType(String inputString){
        switch (inputString) {
            case "A+":
                bloodType = "A Positive";
                break;
            case "A-":
                bloodType = "A Negative";
                break;
            case "B+":
                bloodType = "B Positive";
                break;
            case "O+":
                bloodType = "O Positive";
                break;
            case "O-":
                bloodType = "O Negative";
                break;
            case "AB+":
                bloodType = "AB Positive";
                break;
            case "AB-":
                bloodType = "AB Negative";
                break;
            default:
                System.err.println("Invalid ABO input!");
                return;
        }
    }
    
    void processBloodType(String inputString, char inputChar){
        if(!inputString.equals("A") && !inputString.equals("B") 
        && !inputString.equals("O") && !inputString.equals("AB")){
            System.err.println("Invalid ABO input!");
            return;
        }
        if(inputChar != '+' && inputChar != '-'){
            System.err.println("Invalid Rh input!");
            return;
        }

        if(inputChar == '+'){
            bloodType = inputString + " Positive";
        }
        bloodType = inputString + " Negative";
    }

    void processBloodType(int inputInt){
        inputInt--;
        String[] bloodTypes = {
            "A Positive (A+)",
            "A Negative (A-)",
            "B Positive (B+)",
            "B Negative (B-)",
            "O Positive (O+)",
            "O Negative (O-)",
            "AB Positive (AB+)",
            "AB Negative (AB-)"
        };
        if(inputInt < 8 && inputInt >= 0) {
            bloodType = bloodTypes[inputInt];
        } 
        else{
            System.err.println("Invalid Numeric Input!");
            return;
        }
    }
}

