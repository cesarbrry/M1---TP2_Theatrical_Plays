package theatricalplays;

public class Play {

  public enum TypePiece
  {
    TRAGEDY,
    COMEDY
  }

  public String name;
  public TypePiece type;

  public Play(String name, TypePiece type) {
    this.name = name;
    this.type = type;
  }

  public float getPrice(int audience) // La fonction getPrice va ( pour chaque piece ) retourner le prix que 
                                      // le client doit en fonction du type de piece et du nb de spectateurs
  {
      float price = 0;
      
      switch (this.type)
      {

          case TRAGEDY :
              price = 400;
              if (audience > 30) { price += 10 * (audience - 30);} 
          break;
          
          case COMEDY :
              price = 300;
              if (audience > 20) { price += 100 + 5 * (audience - 20);}
              price += 3 * audience;
          break;

          default:
              throw new Error("unknown name : " + this.name);

      }
      return price ;
  }
  
  public int getCredits(int audience) // La fonction getPrice va ( pour chaque piece ) retourner le nombre de crédit que 
                                      // le client gagne en fonction du type de piece et du nb de spectateurs
  {
      int credit = 0 ;
      credit += Math.max(audience - 30, 0);
      if (this.type == TypePiece.COMEDY) { credit += Math.floor(audience / 5); }
      return credit ;
  }

  public String getName() { return name; }

  public TypePiece getType() { return type; }

}
