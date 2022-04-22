import java.util.Locale;
import java.util.Scanner;

public class myClass {
    public static void main(String[] args) {
        Balance myBal = new Balance("Miguel");

        // ----------------------------------------------Income--------------------------------------------
        myBal.singIncome("Chase Checking", "today", 13367.8, "usd");
        myBal.singIncome("Chase Savings", "today", 1257.01, "usd");
        myBal.singIncome("Cash dollars", "today", 565,"usd");
        myBal.singIncome("Cash dollars", "2023-02-02", 1065,"mxn");


        // ----------------------------------------------Spending-----------------------------------------------

        myBal.singSpend("General1", "2022-02-21", 744.86, "usd");
        myBal.singSpend("General2", "2022-03-03", 162.49, "usd");
        myBal.singSpend("General3", "2022-03-16", 400, "usd");
        myBal.singSpend("General4", "2022-03-12", 15, "usd");
        myBal.singSpend("General5", "2022-04-20", 55, "usd");
        myBal.singSpend("General6", "2022-05-24", 180, "usd");
        myBal.singSpend("General7", "2022-05-12", 55, "usd");
        myBal.singSpend("General8", "2022-06-07", 171, "usd");


        // ----------------------------------------------Evaluate--------------------------------------------------

        //System.out.println(myBal);
        //myBal.showTransactions();
        //myBal.balanceToDate("2021-09-02");
        //myBal.transactionsToDate("2021-09-02");

        // ----------------------------------------------Interactive-----------------------------------------------

        Scanner input = new Scanner(System.in);
        boolean done = false;
        String menu = "\n\n1 - To show the balance for every recorded transaction." +
                "\n2 - To show every recorded transaction." +
                "\n3 - To show the balance up to a specified date." +
                "\n4 - To show transactions up to a specified date." +
                "\n\nThen press ENTER or RETURN: ";

        System.out.print("Welcome to RealHelp. Type: " + menu);


        while (!done){
            String option = input.next();

            switch (option) {
                case "1" -> System.out.println(myBal);
                case "2" -> myBal.showTransactions();
                case "3" -> {
                    System.out.print("Type the specified date using the format yyyy-MM-dd: ");
                    myBal.balanceToDate(input.next());
                }
                case "4" -> {
                    System.out.print("Type the specified date using the format yyyy-MM-dd: ");
                    myBal.transactionsToDate(input.next());
                }
                default -> System.out.println("Option not available.");
            }

            System.out.println("\nWould you like to display the menu again?" +
                    "\ny - Yes" +
                    "\nn - No");

            if (!input.next().toLowerCase(Locale.ROOT).equals("y")) { done = true; }
            else { System.out.print(menu); }
        }
    }
}
