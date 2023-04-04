
import java.util.Scanner;
class BankAccount {
    String id="1234 5678 9876 5432";
    String pin="2345";
    double avlBalance=2000.0;
    String transactionHistory = "";

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        boolean isLogin = false;
	int cnt=0;
        while (!isLogin) {
            System.out.print("Enter Your 16 digits ID:");
            String p = sc.nextLine();
            if (p.equals(id)) {
                while (!isLogin) {
                    System.out.print("Enter Your 4 digit pin :");
                    String Password = sc.nextLine();
                    if (Password.equals(pin)) {
                        System.out.print("Login successful");
                        isLogin = true;
                    } else {
			cnt=cnt+1;
                        System.out.println("Incorrect Pin.You have only "+(3-cnt)+" attempts");
			if((3-cnt)==0){
				System.out.println("Access Denied.Try again after sometime");
				return isLogin;}

                    }
                }
            } else {
                System.out.println("User not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw:");
        float amount = sc.nextFloat();
        try {
            if (avlBalance >= amount) {
                avlBalance = avlBalance - amount;
                System.out.println("Withdraw Successfully");
                System.out.println("please collect your cash");
                System.out.println("Available balance is:" + avlBalance);
                String str = amount + "/- Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit:");
        double amount = sc.nextDouble();
        try {
            avlBalance = avlBalance + amount;
            System.out.println("Amount Deposited Successfully");
            String str = amount + "/- deposited\n";
            transactionHistory = transactionHistory.concat(str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number to transfer:");
        int recAccNo = sc.nextInt();
        System.out.print("Enter amount to transfer:");
        float amount = sc.nextFloat();
        try {
            if (avlBalance >= amount) {
                if (amount <= 10000) {
                    avlBalance = avlBalance - amount;
                    System.out.println("Successfully Transfered to Account no: " + recAccNo);
                    String str = amount + " /- transfered to Acc number " + recAccNo + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("Sorry your Limit is only 10000");
                }
            } else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void checkBalance() {
        System.out.println("Available Balance:" + avlBalance + "/-");
    }

    public void transHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions are done");
        } else {
            System.out.println("Transaction history:");
            System.out.println(transactionHistory);
        }
    }
}
