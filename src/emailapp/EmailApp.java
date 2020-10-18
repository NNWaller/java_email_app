package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        //Here we are testing to see if our Email constructor works.
        Email email1 = new Email("Suzy", "Queue");
        System.out.println(email1.showInfo());
    }
}
