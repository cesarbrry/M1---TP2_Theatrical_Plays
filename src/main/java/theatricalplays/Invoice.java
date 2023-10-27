package theatricalplays;

import java.util.List;
import java.util.Map;

public class Invoice {

  public String customer;
  public List<Performance> performances;

  public Invoice(String customer, List<Performance> performances) 
  {
    this.customer = customer;
    this.performances = performances;
  }

}
