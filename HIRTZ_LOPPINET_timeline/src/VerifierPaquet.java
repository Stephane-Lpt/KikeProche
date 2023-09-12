class VerifierPaquet{
  // cette classe a pour objectif de vérifier que les méthodes
  // de la classe Paquet sont correctement écrites

  public static void main(String[] args){
    // constructeurs
    PaquetCarte paq = new PaquetCarte();

    // méthodes Q9
    paq.ajouterCarteFin(new Carte("dauphin"));
    paq.retirerCarte(0);

    // méthode Q11
    Carte c = paq.piocherHasard();

    // méthode Q12
    int res = paq.trouverCarteProche(c,"taille");

  }

}
