//Demonstrating Exception Handling

public class Main
{
    public static void main(String[] args) throws IOException, DemonetizationException
    {
        Account newac;
        Scanner br =new Scanner(System.in);
        System.out.println("Create account with: ");
        System.out.println("1. Minimum balance");
        System.out.println("2. Custom balance");1
        System.out.print("Enter choice: ");
        int ch = br.nextInt();

        if(ch == 1)
        {
            newac = new Account();
        }
        else if(ch == 2)
        {
            System.out.print("Enter starting balance: ");
            double bal = br.nextDouble();
            if(bal >= 500)
            {
                newac = new Account(bal);
            }
            else
            {
                System.out.println("Sorry, balance cannot be less than Rs. 500. Creating account with minimum balance...");
                newac = new Account();
            }
        }
        else
        {
            System.out.println("Sorry, wrong option chosen. Creating account with minimum balance...");
            newac = new Account();
        }

        while(true)
        {
            System.out.println("MENU:");
            System.out.println("1. Check account balance");
            System.out.println("2. Make a deposit");
            System.out.println("3. Make a withdrawal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = br.nextInt();

            if(ch == 1)
            {
                System.out.println("Your current account balance is: " + newac.currBalance());
                System.out.println("\n");
            }
            else if(ch == 2)
            {
                System.out.print("Enter amount to deposit: ");
                double toDep = br.nextDouble();
                System.out.print("Enter type of currency - OLD/NEW: ");
                String curType = br.next();
                curType=curType.toUpperCase();
                try
                {
                    newac.deposit(toDep, curType);
                }
                catch(DemonetizationException de)
                {
                    System.out.println(de.exMessage());
                }
                System.out.println("\n");
            }
            else if(ch == 3)
            {
                System.out.print("Enter amount to withdraw: ");
                double toWith = br.nextDouble();
                newac.withdraw(toWith);
                System.out.println("\n");
            }
            else if(ch == 4)
            {
                System.out.println("Goodbye!");
                break;
            }
            else
            {
                System.out.println("Wrong option chosen, please try again");
                System.out.println("\n");
            }
        }
    }
}
