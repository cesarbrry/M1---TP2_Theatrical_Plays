package theatricalplays;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

  public String print(Invoice invoice) 
  {

    String name ;
    float totPrice = 0 ;
    int totCredit = 0 ;

    StringBuffer result     = new StringBuffer("Statement for " + invoice.customer + "\n");
    NumberFormat frmt       = NumberFormat.getCurrencyInstance(Locale.US);
    

    for (Performance perf : invoice.performances) 
    
    {
      name = perf.play.name;
      totPrice += perf.play.getPrice(perf.audience);
      totCredit += perf.play.getCredits(perf.audience);

      result.append(String.format("  %s: %s (%s seats)\n", name , frmt.format(perf.play.getPrice(perf.audience)), perf.audience));
    }
    
    
    result.append(String.format("Amount owed is %s\n", frmt.format(totPrice)));
    result.append(String.format("You earned %s credits\n", totCredit));
    
    return result.toString();
  }
}

