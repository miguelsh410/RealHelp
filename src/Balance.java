import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Balance {
    String ownerName;
    double balance;
    double spending;
    double income;
    static double dollarPrice = 20;
    List<Transaction> transactions = new LinkedList<Transaction>() {};

    Balance(String ownerName){ this.ownerName = ownerName; }

    public void singSpend(String spendName, String dateYYYY_MM_DD, double spendAmount, String currency){
        if (currency.toLowerCase(Locale.ROOT).equals("mxn")){
            spendAmount = mxnToUSD(spendAmount);
        }

        this.balance -= spendAmount;
        this.spending += spendAmount;
        Transaction singleSpending = new Spending(spendName, parseDate(dateYYYY_MM_DD), spendAmount);
        transactions.add(singleSpending);
        Collections.sort(transactions);
    }

    public void singIncome(String incName, String dateYYYY_MM_DD, double incAmount, String currency) {
        if (currency.toLowerCase(Locale.ROOT).equals("mxn")){
            incAmount = mxnToUSD(incAmount);
        }

        this.balance += incAmount;
        this.income += incAmount;
        Transaction singleIncome = new Transaction(incName, parseDate(dateYYYY_MM_DD), incAmount);
        transactions.add(singleIncome);
        Collections.sort(transactions);
    }

    // https://stackoverflow.com/questions/22326339/how-create-date-object-with-values-in-java/22326440
    private static Date parseDate(String date) {
        if (date.toLowerCase(Locale.ROOT).equals("today")) {
            date = java.time.LocalDate.now().toString();
        }

        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            System.out.println("Not a valid date or date format.");
            return null;
        }
    }

    public void showTransactions() {
        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println();
    }

    public void balanceToDate(String dateYYYY_MM_DD) {
        double curSpending = 0;
        double curIncome = 0;

        for (Transaction trans : transactions){
            if (trans.date.compareTo(parseDate(dateYYYY_MM_DD)) <= 0){
                if (trans.amount < 0) { curSpending += trans.amount; }
                else { curIncome += trans.amount; }
            }
        }

        System.out.println("Dollar price: " + dollarPrice + "\n" +
                "\nOwner Name = " + this.ownerName +
                "\nIncome: " + Math.round(curIncome * 100.0) / 100.0 + " USD" +
                "\nSpending: " + Math.round(curSpending * 100.0) / 100.0 + " USD" +
                "\nBalance to " + dateYYYY_MM_DD + ": " + Math.round((curIncome + curSpending) * 100.0) / 100.0 + " USD\n");
    }

    public void transactionsToDate(String dateYYYY_MM_DD) {
        for (Transaction trans : transactions){
            if (trans.date.compareTo(parseDate(dateYYYY_MM_DD)) <= 0){
                System.out.println(trans);
            }
        }
    }

    public static void setDollarPrice(double newDollarPrice) { dollarPrice = newDollarPrice; }

    private static double mxnToUSD(double amountInPesos) { return amountInPesos / dollarPrice; }

    private static double usdToMXN(double amountInDollars) { return amountInDollars * dollarPrice; }

    @Override
    public String toString() {
        return "Dollar price: " + dollarPrice + "\n" +
                "\nOwner Name = " + this.ownerName +
                "\nIncome = " + Math.round(this.income * 100.0) / 100.0 +
                "\nSpending = " + Math.round(this.spending * 100.0) / 100.0 +
                "\nBalance = " + Math.round(this.balance * 100.0) / 100.0 + "\n";
    }
}
