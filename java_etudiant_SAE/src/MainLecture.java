public class MainLecture{
  public static void main(String[] args){
    LectureFichier fichier = new LectureFichier("../cartes/animaux.csv");
    String[] lignes = fichier.lireFichier();
    for(int i=0;i<lignes.length;i++){
      System.out.println(lignes[i]);
    }
  }
}
