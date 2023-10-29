package theatricalplays;
import java.util.List;


public class Invoice {

  public Customer customer ;
  public List<Performance> performances;

  public Invoice(Customer customer, List<Performance> performances) 
  {
    this.customer = customer;
    this.performances = performances;
  }

  public float SommePrix()  // Somme prix (SommePrix) va calculer la somme du prix total du par le client et le renvoyer dans notre classe d'affichage
  {
    float totPrice = 0 ;
    for (Performance perf : performances) { totPrice += perf.play.getPrice(perf.audience); } // On utilise une boucle for pour calculer le prix de toute les performances
    if (this.customer.PointDeFidelite >= 150)
    {
      totPrice -= 15;
      this.customer.PointDeFidelite -= 150;
    }
    return totPrice;
  }

  public int SommeCred()    // Somme Credit (SommeCred) va calculer le credit total que le client a obtenu et le renvoyer dans notre classe d'affichage
  {
    int totCredit = 0 ;
    for (Performance perf : performances) { totCredit += perf.play.getCredits(perf.audience); } // On utilise une boucle for pour calculer le credit de toute les performances
    return totCredit;
  }

  public int CreditFinal()
  {
    if( customer.getPointDeFidelite() >= 150)
    {
      customer.PointDeFidelite = ((customer.getPointDeFidelite()) + SommeCred()) - 150 ;
    }

    else
    {
      customer.PointDeFidelite = ((customer.getPointDeFidelite()) + SommeCred()) ;
    }

    return customer.PointDeFidelite;
  }

  public Customer getCustomer() {return customer;}

  public String getCustomerName(){return customer.getName();}

  public List<Performance> getPerformances() {return performances;}
}
