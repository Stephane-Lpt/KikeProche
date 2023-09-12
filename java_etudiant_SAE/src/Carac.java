public class Carac{
  private String nomCarac;
  private double valeur;

  public Carac(String nom, double val){
    this.nomCarac = nom;
    this.valeur = val;
  }

  public double getValeur(){
    return this.valeur;
  }

  public boolean etreEgal(String nom){
    return (this.nomCarac.equals(nom));
  }

}
