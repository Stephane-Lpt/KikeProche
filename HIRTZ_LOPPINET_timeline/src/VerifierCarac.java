class VerifierCarac{
  // cette classe a pour objectif de vérifier que les noms des méthodes sont corrects

  public static void main(String args[]){
    Carac c = new Carac("taille",15.2);
    double val = c.getValeur();
    String n = c.getNom();
    boolean res = c.etreEgal("taille");
  }
}
