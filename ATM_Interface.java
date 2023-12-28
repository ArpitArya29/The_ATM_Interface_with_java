import java.util.Scanner; //imported Scanner class to add functionality of taking input from user

//interface of an ATM machine which contains all the important function to be surely implemented
interface ATM {
    void Withdraw(int amount);

    void Balance_Check();

    void Deposit(int amount);
}

//Bank Account class which provide the functionality of all the transactions
class Bank_Account implements ATM {
    public int balance; //A variable which holds the account balance of the user
    String U_Name; //Variable which can hold the user's name

    //A constructor which sets the name of the ser when object of this class is initialized
    Bank_Account(String name) {
        this.U_Name = name;
    }

    //A member function which perform the withdrawing functionality to the user
    public void Withdraw(int amount) {
        if (balance < amount) {
            System.out.format("Hey %s, You have insufficient amount in your account!\n", U_Name);
        } else{
            balance = balance - amount;
            System.out.format("Your account has been debited with Rs %d \n", amount);
        }
    }
    
    //A member fuction which deposits the given amount to the user's bank account
    public void Deposit(int amount) {
        balance = balance + amount;
        System.out.format("Your account has been credited with Rs %d \n", amount);
    }
    
    //A member function which displays the user's account balance
    public void Balance_Check() {
        System.out.format("Hey Mr. %s Your current account balance: %d \n", U_Name, balance);
    }
}

//The main class where the program starts
public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //An object of Scanner class to accept the input from the user
        int choice, Damount, Wamount; //Varible for user's choice, amount to be deposited and amount that will be withdrawn 
        String name; 
        String check;
        boolean wtd = true;
        System.out.println("Introduce yourself");
        name = sc.nextLine();
        Bank_Account user = new Bank_Account(name);
        while (wtd) {
            System.out.println("***************************************");
            System.out.println("     What do you want to perform?");
            System.out.println("1-Deposite  2-withdraw  3-BalanceEnquiry");
            choice = sc.nextInt();
            
            //options for user's choice
            switch (choice) {
                case 1:
                System.out.println("Amount to be deposited: ");
                Damount = sc.nextInt();
                user.Deposit(Damount);
                break;
                
                case 2:
                System.out.println("Amount to withdraw: ");
                Wamount = sc.nextInt();
                user.Withdraw(Wamount);
                break;
                
                case 3:
                user.Balance_Check();
                break;
                
                default:
                System.out.println("-->Please enter correct choice!<--");
                break;
            }
            System.out.println("---------------------------------------------");
            System.out.println("Still you want to do something?");
            check = sc.next();
            if (check.equalsIgnoreCase("Yes")) {
                System.out.println("-----------------------");
                System.out.println("Okay, you may proceed");
            } else{
                wtd = false;
            }
        }
    }
}