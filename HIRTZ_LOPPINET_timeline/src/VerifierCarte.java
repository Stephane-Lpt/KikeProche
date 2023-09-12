class VerifierCarte{
  // cette classe a pour objectif de vérifier que les méthodes
  // de la classe Carte sont correctement écrites

  public static void main(String[] args){
    Carte carte = new Carte("dauphin");
    carte.ajouterCarac(new Carac("taille",15.2));
    double taille = carte.getValeur("taille");
    carte.setVisible();

    Carte carte2 = new Carte("nom;taille;poids;longevite","lapin;19.0;1.3;7.0");
    String aff = carte2.toString();
  }

}
