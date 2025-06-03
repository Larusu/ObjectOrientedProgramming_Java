package Act4_BloodTypeTesting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BloodType[] human = new BloodType[3];

        for (int i = 0; i < 3; i++) {
            try{
                System.out.println("\n===== Blood Type Testing =====");
                System.out.print("Enter Name: ");
                String name = scan.nextLine().trim();
                System.out.print("Enter Age: ");
                int age = Integer.parseInt(scan.nextLine());
                human[i] = new BloodType(name, age);

                System.out.println("\nChoose blood type input method:");
                System.out.println("1. Full Type(e.g., A+)");
                System.out.println("2. ABO and Rh separately(e.g., A and +)");
                System.out.println("3. Numeric code (1 = A+, ..., 8 = AB-)");
                System.out.print("Enter Choice: ");
                int choice = Integer.parseInt(scan.nextLine());

                System.out.println("\n");
                switch(choice){

                    case 1:

                        System.out.print("Enter full blood type (e.g., O-): ");
                        human[i].processBloodType(scan.nextLine().trim().toUpperCase());
                        break;

                    case 2:

                        System.out.print("Enter ABO (A, B, AB, O): ");
                        String ABO = scan.nextLine().trim().toUpperCase();

                        System.out.print("Enter Rh (+ or -): ");
                        String Rh = scan.nextLine().trim();
                        char charRh = Rh.charAt(0);
                        human[i].processBloodType(ABO, charRh);
                        break;

                    case 3:

                        System.out.print("Enter Numeric Code (e.g., 1): ");
                        human[i].processBloodType(Integer.parseInt(scan.nextLine()));
                        break;

                    default:

                        System.out.println("Wrong Input");
                        break;
                }
                
                System.out.println();

            } catch(NumberFormatException e){
                System.err.println("Invalid number format! Try again!");
                i--;
                continue;
            }
        } scan.close();
        

        for(BloodType humans : human){
            humans.printDetails();
        }
        System.out.println("=========================");
    }
}

