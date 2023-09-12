import java.util.Scanner;
import java.util.Random;

/**
 * Classe (Jeu) permettant de représenter une partie du jeu KiKéProche
 * Jeu:(main:PaquetCarte, pioche:PaquetCarte, nomFichier:String, nombreCarte:int, taille:int)
 */
public class Jeu {
    /**
     * attribut qui stocke les cartes de la main du joueur
     */
    private PaquetCarte main;
    /**
     * attribut qui stocke les cartes de la pioche
     */
    private PaquetCarte pioche;
    /**
     * attribut qui stocke le nom du fichier CSV
     */
    private String nomFichier;
    /**
     * attribut qui stocke le nombre de cartes 
     */
    private int nombreCarte;
    /**
     * attribut qui stocke la taille des titres
     */
    private int taille=60;

    /**
     * constructeur 2 paramètres pour créer une partie
     * 
     * @param nomFichier nom du fichier CSV à ouvrir
     * @param nombreCarte nombre de cartes dans la main du joueur
     */
    public Jeu(String nomFichier, int nombreCarte){
        this.pioche = new PaquetCarte(nomFichier);
        this.main = new PaquetCarte();
        for (int i=0; i<nombreCarte; i++){
            this.main.ajouterCarteFin(this.pioche.retirerCarte(new Random().nextInt(this.pioche.getNbCartes()-1)));
        }
        this.nomFichier = nomFichier;
        this.nombreCarte = nombreCarte;
    }

    /**
     * méthode privée pour écrire un titre avec une taille totale en longueur = this.taille
     * 
     * @param titre titre à afficher
     */
    private void ouvrirTitre(String titre){
        String vide="";
        for (int i=0; i<(this.taille-titre.length())/2;i++){
            vide+="-";
        }
        System.out.print(vide+titre+vide+"\n");
    }

    /** 
     * affiche une ligne de "-" de taille this.taille
     */
    private void fermerTitre(){
        String chaine="";
        for (int i=0; i<this.taille;i++){
            chaine += "-";
        }
        System.out.print(chaine+"\n\n");
    }

    /**
     * méthode pour tirer une carte au hasard dans la pioche et l'afficher
     * 
     * @return la carte piochée
     */
    public Carte tirerCartePioche(){
        this.ouvrirTitre("CARTE ET CARAC");
        Carte c = this.pioche.piocherHasard();
        c.setVisible();
        System.out.print(c+"\n");
        return c;
    }
    
    /**
     * méthode pour choisir une caractéristique au hasard dans un objet (Carte)
     * 
     * @param c l'objet où il faut choisir la carac 
     * @return attribut 'nom' de l'objet (Carac) choisie
     */
    public String choisirCarac(Carte c){
        String nom =c.prendreCaracHasard().getNom();
        System.out.print("caracteristique testee :"+nom+"\n");
        this.fermerTitre();
        return nom;
    }

    /**
     * méthode qui demande à l'utilisateur la carte la plus proche de sa main
     * 
     * @return valeur choisie par l'utilisateur
     */
    public int choixCartePlusProche(){
        this.ouvrirTitre("MAIN DU JOUEUR");
        System.out.print(this.main);
        this.fermerTitre();
        this.ouvrirTitre("CHOIX");
        System.out.print("quelle carte de votre main est la plus proche ?\n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        this.fermerTitre();
        return input;
    }
    
    /**
     * méthode qui vérifie si la carte d'indice 'indice' de main est bien la plus proche de c par rapport à carac
     * 
     * @param c Carte de référence
     * @param carac Carac de référence
     * @param indice indice de la carte choisie par l'utilisateur
     */
    public void verifCartePlusProche(Carte c, String carac, int indice){
        this.ouvrirTitre("CARTE JOUEE");
        this.main.getCarte(indice).setVisible();
        System.out.print(this.main.getCarte(indice)+"\n");
        this.ouvrirTitre("REPONSE");
        int indicePlusProche = this.main.trouverCarteProche(c, carac);
        this.main.getCarte(indicePlusProche).setVisible();
        if(this.main.getCarte(indicePlusProche)==this.main.getCarte(indice)){
            System.out.print("bien joue, y avait pas mieux\n");
            this.main.retirerCarte(indicePlusProche);
        }else{
            System.out.print("eh non, il y avait une carte plus proche:\n");
            System.out.print(this.main.getCarte(indicePlusProche)+"\n");
            System.out.print("on les retire et on ajoute deux nouvelles cartes\n");
            this.main.retirerCarte(indicePlusProche);
            if(indicePlusProche<indice){
                this.main.retirerCarte(indice-1);
            }
            else{
                this.main.retirerCarte(indice);
            }
            
            for (int i=0; i<2; i++){
                this.main.ajouterCarteFin(this.pioche.retirerCarte(new Random().nextInt(this.pioche.getNbCartes()-1)));
            }
        }

        this.fermerTitre();
    }

    /**
     * méthode qui permet de renvoyer le nombre de cartes dans la main du joueur
     * 
     * @return le nombre de cartes dans la main du joueur
     */
    public int getNbCarteMain(){
        return this.main.getNbCartes();
    }

    /**
     * méthode qui permet de renvoyer le nombre de cartes dans la pioche
     * 
     * @return le nombre de cartes dans la pioche
     */
    public int getNbCartePioche(){
        return this.pioche.getNbCartes();
    }
}
