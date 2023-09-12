/**
 * classe (MainLecture) permettant de tester les méthodes et constructeurs de la classe (LectureFichier)
 */
public class MainLecture {
    
    /**
     * méthode main exécutant les premières instructions au lancement du programme
     * 
     * @param args liste d'arguments donnée en paramètre de l'exécution de la classe
     */
    public static void main(String[] args){
        LectureFichier fichier = new LectureFichier("../cartes/animaux.csv");
        String[] tabCSV = fichier.lireFichier();

        for (int i=0; i<tabCSV.length; i++){
            System.out.println(tabCSV[i]);
        }
    }
}
