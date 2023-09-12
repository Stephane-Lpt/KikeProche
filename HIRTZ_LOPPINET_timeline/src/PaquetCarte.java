import java.util.Random;
/**
 * représentation d'un paquet de cartes de type Carte
 */
public class PaquetCarte{

    /** 
     * attribut qui représente toutes les cartes <Carte> d'un paquet dans un tableau Carte[]
     */
    private Carte[] cartes;

    /**
     * Constructeur sans paramètre qui initialise l'attribut cartes à un tableau vide
     * 
     */
    public PaquetCarte(){
        this.cartes = new Carte[0];
    }

    /**
     * Constructeur 1 paramètre qui associe à l'attribut cartes un tableau de cartes passé en paramètre.
     * 
     * @param tableau un paquet de cartes qui fera office de nouveau paquet
     */
    public PaquetCarte(Carte[] tableau){
        this.cartes = tableau;
    }

    /**
     * Constructeur 1 paramètre qui crée un paquet de cartes directement à partir d’un nom de fichier
     * 
     * @param nom nom du fichier contenant les cartes
     */
    public PaquetCarte(String nom){
        LectureFichier fichier = new LectureFichier(nom);
        String[] tabCSV = fichier.lireFichier();
        String noms = tabCSV[0];

        Carte[] tabCartes = new Carte[tabCSV.length-1];
        
        for (int i=1; i<tabCSV.length; i++){
            tabCartes[i-1] = new Carte(noms, tabCSV[i]);
        }
        this.cartes = tabCartes;
    }

    /**
     * méthode accesseur de récupération de la longueur du tableau cartes (nombre de cartes du paquet)
     * 
     * @return l'attribut 'cartes' de l'objet (PaquetCarte) appelant la méthode
     */
    public int getNbCartes(){
        return this.cartes.length;
    }

    /**
     * méthode accesseur de récupération d'une carte à la place indiquée
     * 
     * @param place indice de la carte à récupérer
     * @return la carte demandée à l'indice place du tableau si la place est valide et null sinon.
     */
    public Carte getCarte(int place){
        if (place < 0 || place >= this.cartes.length){
            return null;
        }
        return this.cartes[place];
    }

    /**
     * Méthode permettant l'ajout d'une carte (Carte) 
     * au tableau cartes d'un objet (PaquetCarte) appelant la méthode
     * 
     * @param newC objet (Carte) à ajouter au tableau cartes de l'objet (PaquetCarte)
     */
    public void ajouterCarteFin(Carte newC){
        Carte[] newTab = new Carte[(this.cartes.length)+1];
        for (int i=0; i<this.cartes.length; i++){
            newTab[i]=this.cartes[i];
        }
        newTab[newTab.length-1]=newC;
        this.cartes = newTab;
    }

    /**
     * Méthode permettant de retirer la carte (Carte) située à une place
     * du tableau cartes d'un objet (PaquetCarte) appelant la méthode
     * 
     * @param place indice de la carte à retirer
     * @return la carte supprimée
     */
    public Carte retirerCarte(int place){
        Carte aSup=null;
        if (place < 0 || place >= this.cartes.length){
            return null;
        }
        Carte[] newTab = new Carte[this.cartes.length-1];
        
        for (int i=0; i<this.cartes.length;i++){
            if (i != place){
                if (aSup != null){
                    newTab[i-1] = this.cartes[i];
                }
                else{
                    newTab[i] = this.cartes[i];
                } 
            }
            else{
                aSup = this.cartes[i];
            }
        }
        this.cartes = newTab;
        return aSup;
    }

    /**
     * méthode permettant d'afficher toutes les cartes du tableau cartes de l'objet (PaquetCarte) appelant la méthode
     * 
     * @return une chaine contenant les informations des cartes du tableau cartes (Une ligne pour chaque carte) 
     */
    public String toString(){
        String chaine="";
        for (int i=0; i<this.cartes.length; i++){
            chaine += i+". carte ("+this.cartes[i]+")\n";
        }
        return chaine;
    }




    /**
     * méthode permettant de piocher une carte parmi toutes les cartes contenues dans le tableau cartes de l'objet (PaquetCarte)
     * 
     * @return une carte au hasard du paquet de cartes
     */
    public Carte piocherHasard(){
        if(this.cartes.length > 0){
            System.out.println(this.getNbCartes());
            return this.cartes[new Random().nextInt(this.cartes.length-1)];
        }
        return null;
    }

    /**
     * méthode permettant de trouver la carte du tableau cartes de l'objet (PaquetCarte) ayant la caractéristique la plus proche
     * de celle de la carte donnée en paramètre.
     * 
     * @param c carte à comparer aux cartes du tableau cartes
     * @param nomCarac nom de la caractéristique à comparer
     * @return l'indice de la carte du tableau cartes ayant la caractéristique la plus proche.
     */
    public int trouverCarteProche(Carte c, String nomCarac){
        int indice = -1;
        double ecartMin = -1;
        if (this.cartes.length > 1){  //on considère que l'objet c est toujours bien dans le paquet
                                      //donc il faut toujours au moins 2 cartes
            double ecart;
            for (int i=0; i<this.cartes.length; i++){ 
                if (this.cartes[i]!=c){
                    ecart = this.cartes[i].getValeur(nomCarac)-c.getValeur(nomCarac);
                    if (ecart < 0){
                        ecart = ecart*(-1);
                    }
                    if (indice==-1){
                        indice = i;
                        ecartMin = ecart;
                    }
                    else{
                        if(ecart < ecartMin){
                            indice = i;
                            ecartMin = ecart;
                        }
                    }
                }
            }
        }
        return indice;
    }
}
