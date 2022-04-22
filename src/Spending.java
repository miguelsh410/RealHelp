import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Spending extends Transaction{
    Spending(String name, Date date, double amount) {
        super(name, date, -amount);
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return "Description: " + this.name + " (SPENDING)" +
                "\n\tAmount: " + Math.round(this.amount * 100.0) / 100.0 + " USD" +
                "\n\tDate: " + dateFormat.format(this.date);
    }
}
