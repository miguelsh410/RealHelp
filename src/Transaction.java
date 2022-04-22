import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

 class Transaction implements Comparable<Transaction>{
    String name;
    Date date;
    double amount;
    static double numOfTransactions = 0;

    Transaction(String name, Date date, double amount){
        this.name = name;
        this.date = date;
        this.amount = amount;
        numOfTransactions++;
    }

     @Override
     public int compareTo(Transaction t) {
         return this.date.compareTo(t.date);
     }

     @Override
     public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return "Description: " + this.name + " (INCOME)" +
                "\n\tAmount: " + Math.round(this.amount * 100.0) / 100.0 + " USD" +
                "\n\tDate: " + dateFormat.format(this.date);
     }
 }
