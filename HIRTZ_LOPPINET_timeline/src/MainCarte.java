/**
 * classe (MainLecture) permettant de tester les méthodes et constructeurs de la classe (Carte)
 */
public class MainCarte {
    
    /**
     * méthode main exécutant les premières instructions au lancement du programme
     * 
     * @param args liste d'arguments donnée en paramètre de l'exécution de la classe
     */
    public static void main(String[] args){
        LectureFichier fichier = new LectureFichier("../cartes/animaux.csv");
        String[] tabCSV = fichier.lireFichier();

        Carte carte;
        for (int i=1; i<tabCSV.length; i++){
            carte = new Carte(tabCSV[0], tabCSV[i]);
            System.out.println(carte);
            carte.setVisible();
            System.out.println(carte);
            System.out.println("");
        }
    }
}
