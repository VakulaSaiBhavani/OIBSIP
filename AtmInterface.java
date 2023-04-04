import java.util.Scanner;
class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice,ch2;
        System.out.println("----------WELCOME----------");
        System.out.println("1.Login");
        System.out.println("2.Exit");
        System.out.print("Enter Your Choice:");
        choice = sc.nextInt();
        if (choice == 1)
        {
	    BankAccount bankAccount = new BankAccount();
            if (bankAccount.login()) 
            {
                System.out.println("\n");
                boolean isFinished = false;
                while (!isFinished) 
                {
                    System.out.print("\n");
                    System.out.println("1.Transaction History\n2.Withdraw \n3.Deposit \n4.Transfer\n5.Check Balance\n6.Exit");
                    System.out.print("Enter Your Choice :");
                    ch2 = sc.nextInt();
                    switch (ch2)
                    {
                        case 1:
                            bankAccount.transHistory();
                            break;
                        case 2:
                            bankAccount.withdraw();
                            break;
                        case 3:
                            bankAccount.deposit();
                            break;
                        case 4:
                            bankAccount.transfer();
                            break;
                        case 5:
                            bankAccount.checkBalance();
                            break;
                        case 6:
                            isFinished = true;
                            break;
                    }
                }
             }
        }
        else
            System.out.print("Thank you visit again!");
    } 
         
}