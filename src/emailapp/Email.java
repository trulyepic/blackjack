package emailapp;

import java.util.Scanner;

public class Email {

    private String fistName;
    private String lastName;
    private String passWord;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    public Email(String fistName, String lastName){
        this.fistName = fistName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.fistName + " " + this.lastName);
        department = setDepartment();
        System.out.println("Your department is: " + this.department);
    }

    private String setDepartment(){
        System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 For Acct\n0 for none: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("1")){
            return "Sales";
        }else if(userInput.equalsIgnoreCase("2")){
            return "Development";
        }else if(userInput.equalsIgnoreCase("3")){
            return "Accounting";
        }else
            return "";
    }
}
