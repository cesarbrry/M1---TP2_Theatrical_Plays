package theatricalplays;

public class Performance {

  public Play play;
  public int audience;

  public Performance(Play play, int audience) {
    this.play = play;
    this.audience = audience;
  }

  public int getAudience()
  {
    return audience;
  }

  public Play getPlay()
  {
    return play ;
  }

}