package theatricalplays;
import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String print(Invoice invoice) 
  {
    StringBuffer result     = new StringBuffer("Statement for " + invoice.customer + "\n");
    NumberFormat frmt       = NumberFormat.getCurrencyInstance(Locale.US);
    
    for (Performance perf : invoice.performances) // La boucle for nous permet de parcourir toutes les performance presentes dans notre liste
                                                  // de performances dans notre classe invoice.
    {
      // Pour chaque performance, on va calculer le prix unitaire et l'afficher a coté du nom de la piece
      result.append(String.format("  %s: %s (%s seats)\n", perf.play.name , frmt.format(perf.play.getPrice(perf.audience)), perf.audience));
    }

    result.append(String.format("Amount owed is %s\n", frmt.format(invoice.SommePrix())));  // On affiche ensuite le montant total de la facture
    result.append(String.format("You earned %s credits\n", invoice.SommeCred()));           // Ainsi que le nombre de credits gagne par le client
    return result.toString();
  }
}

