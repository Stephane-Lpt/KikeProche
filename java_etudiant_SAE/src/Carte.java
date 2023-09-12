public class Carte{
  private String nom;
  private boolean visible;
  private Carac[] caracs;

  public Carte(String nomCarte){
    this.nom = nomCarte;
    this.caracs = new Carac[0];
  }

  public Carte(String carac, String valeurs){
    String[] tabCarac = carac.split(";");
    String[] tabVal = valeurs.split(";");
    this.nom = tabVal[0];
    int n = tabCarac.length;
    this.caracs = new Carac[n-1];
    Carac c;
    for(int i=1;i<n;i++){
      c = new Carac(tabCarac[i],Double.parseDouble(tabVal[i]));
      this.caracs[i-1] = c;
    }
  }

  public void ajouterCarac(Carac c){
    int n = this.caracs.length;
    this.caracs = new Carac[n+1];
    caracs[n] = c;
  }

  public double getValeur(String nom){
    int n = this.caracs.length;
    for(int i=0;i<n;i++){
      if(this.caracs[i].etreEgal(nom)){
        return this.caracs[i].getValeur();
      }
    }
    return -1.0;
  }

  public String getNom(){
    return this.nom;
  }

  public boolean getVisible(){
    return this.visible;
  }

  public Carac[] getCaracs(){
    return this.caracs;
  }
}
