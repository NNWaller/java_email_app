package emailapp;

import java.util.Scanner;

public class Email {
    //Here we will create our variables. They will be private so no one can access them directly.
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500; //Our mail capacity can be adjusted via the setMailboxCapacity method.
    private int defaultPasswordLength = 10; //This is a default number that we set in advance. Can adjust.
    private String alternateEmail;
    private String companySuffix = "somecompany.com";

    //Here we create a constructor to receive the first and last name
    public Email(String firstName, String lastName){
        /*"this" refers to the class level variable. The one without this refers to the local parameter variable.
        So, instead of defining the variable outright, we define it through this API.
         */

        this.firstName = firstName;
        this.lastName = lastName;

        //Once we set the email, we want to call the setDepartment method to set the employee's department
        this.department = setDepartment();

        //Call the method that returns a random password based on our defaultPasswordLength
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Now, we combine our elements to generate an email in firstname.lastname@department.company.com
        email = firstName.toLowerCase()+ "." +lastName.toLowerCase()+"@"+ department + "." + companySuffix;
    }

    //Here is the method we will use to ask for the department

    private String setDepartment(){
        System.out.print("DEPARTMENT CODES: " +
                "\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code for " +
                firstName + " " + lastName + ": ");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        if (departmentChoice == 1) { return "Sales";}
        else if(departmentChoice == 2) {return "Development";}
        else if(departmentChoice == 3) {return "Accounting";}
        else {return "";}


    }

    //Here is the method we will use to generate a random password with a parameter of length
    private String randomPassword(int length){
      String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%*@";
      //We will look at the passwordSet of possible characters as an array
        char[] password = new char[length];
        /* We will iterate through the passwordSet array of characters with a for loop. As we loop, we
        will generate a random number by multiplying Math.random() by the length of passwordSet and
         casting that result as an integer. That integer then becomes the variable called "randomNumber." We will
         use the value of randomNumber to get the actual character that is at that index location in passwordSet.
         We then use that index value and shovel it into the password until we build a password that is
         as long as our length parameter that we passed into the randomPassword method.
         */
        for (int i=0; i<length; i++) {
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }
    //Get the mailbox capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    //Get the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    //Change the password or Set the password
    public void changePassword(String password){
        this.password = password;
    }

    //Get the password
    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + " \nCOMPANY EMAIL: " + email + " \nMAILBOX CAPACITY: "
                + mailboxCapacity + "mb";
    }
}
