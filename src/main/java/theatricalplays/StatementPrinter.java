package theatricalplays;
import freemarker.template.*;

import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

  public String print(Invoice invoice) 
  {
    StringBuffer result     = new StringBuffer("Statement for " + invoice.customer.getName() + "\n");
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


  public String toHtml(Invoice invoice) {
    try {
      Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
      cfg.setClassForTemplateLoading(StatementPrinter.class, "/");
      cfg.setDefaultEncoding("UTF-8");
      cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
      cfg.setLocale(Locale.FRANCE);

      Template template = cfg.getTemplate("htmlTemplate.ftlh");

      /* Create a data-model */
      Map<String, Object> root = new HashMap<>();
      root.put("invoice", invoice);

      StringWriter writer = new StringWriter();
      template.setOutputEncoding("UTF-8");
      template.process(root, writer);
      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}

