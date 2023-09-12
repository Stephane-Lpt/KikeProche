/**
 * Classe qui permet de lancer un jeu KiKéProche
 */
public class ProgJeu {
    
    /**
     * méthode main qui lance le jeu
     * 
     * @param args liste d'arguments donnée en paramètre de l'exécution de la classe
     */
    public static void main(String[] args){
        String nomFichier = "../cartes/animaux.csv";
        Jeu j = new Jeu(nomFichier, 10);
        while (j.getNbCarteMain()!=1 && j.getNbCartePioche()!= 0){
            Carte cartePiocher = j.tirerCartePioche();
            String carac = j.choisirCarac(cartePiocher);
            int indice = j.choixCartePlusProche();
            j.verifCartePlusProche(cartePiocher, carac, indice);
        }

        if(j.getNbCarteMain()<= 1){
            System.out.println("Bravo, vous avez gagné");
        }else{
            System.out.println("Dommage, vous avez perdu");
        }
    }
}
