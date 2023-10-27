package theatricalplays;
import java.util.List;


public class Invoice {

  public String customer;
  public List<Performance> performances;

  public Invoice(String customer, List<Performance> performances) 
  {
    this.customer = customer;
    this.performances = performances;
  }

  public float SommePrix()  // Somme prix (SommePrix) va calculer la somme du prix total du par le client et le renvoyer dans notre classe d'affichage
  {
    float totPrice = 0 ;
    for (Performance perf : performances) { totPrice += perf.play.getPrice(perf.audience); } // On utilise une boucle for pour calculer le prix de toute les performances
    return totPrice;
  }

  public int SommeCred()    // Somme Credit (SommeCred) va calculer le credit total que le client a obtenu et le renvoyer dans notre classe d'affichage
  {
    int totCredit = 0 ;
    for (Performance perf : performances) { totCredit += perf.play.getCredits(perf.audience); } // On utilise une boucle for pour calculer le credit de toute les performances
    return totCredit;
  }

}
