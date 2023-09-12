import java.util.Random;
/**
 * Classe (Carte) permettant de représenter une carte à 2 faces avec ses caractéristiques (Carac)
 * Carte:(nom:String, visible:boolean, caracs:Carac[])
 * 
 * Exemple1: Carte("Lapin", false, [])
 * Exemple2: Carte("Grenouille", true, [("taille", 10.0), ("poids", 150.0)])
 */
public class Carte {
    
    /** 
     * attribut qui définit le nom de la carte
     */
    private String nom;
    
    /**
     * attribut qui définit si la face avec les caractéristiques est visible
     * true : face avec caractéristiques visible // false : seconde face visible
     */
    private boolean visible;

    /**
     * attribut qui définit toutes les caractéristiques (Carac) de la carte dans un tableau Carac[]
     */
    private Carac[] caracs;
    
    /**
     * Constructeur 1 paramètre qui crée un objet (Carte) avec le nom passé
     * en paramètre, face non visible et sans caractéristique.
     * 
     * Ex: Carte 'nom'="Frenouille" => ('Grenouille', false, [])
     * 
     * @param nom nom de la nouvelle carte objet (Carte)
     */
    public Carte(String nom){
        if (nom == null){
            nom = "inconnue";
        } 
        this.nom=nom;
        this.visible=false;
        this.caracs = new Carac[0];
        
    }

    /**
     * constructeur 2 paramètres chaines sous la forme CSV avec comme séparateur ";".
     * 
     * Ex: noms="nom;taille;poids"  valeurs="Lapin;20.0;300" 
     *     => Carte("Lapin",false,[("taille",20.0),("poids", 300.0)
     * 
     * Attention: aucune vérification de la conformité des paramètres
     * 
     * @param noms le nom des colonnes
     * @param valeurs les valeurs des colonnes
     */
    public Carte(String noms, String valeurs){
        String[] tabNoms = noms.split(";");
        String[] tabValeurs = valeurs.split(";");
        this.nom = tabValeurs[0];
        this.visible = false;
        this.caracs = new Carac[0];
        for (int i=1; i<tabNoms.length; i++){
            this.ajouterCarac(new Carac(tabNoms[i], Double.parseDouble(tabValeurs[i])));
        }
    }
    
    /**
     * Méthode permettant l'ajout d'une caractéristique (Carac)
     * à un objet (Carte) existant appelant la méthode
     * 
     * @param c objet (Carac) à ajouter à l'objet (Carte) appelant la méthode (non null)
     */
    public void ajouterCarac(Carac c){
        if(c != null && c.getNom()!=null){ // vérification objet != null et l'attribut 'nom' != null
            int lenTab = this.caracs.length;
            Carac[] newCaracs = new Carac[lenTab+1];
            for (int i=0; i<lenTab;i++){
                newCaracs[i]=this.caracs[i];
            }
            newCaracs[lenTab]=c;
            this.caracs = newCaracs;
        }
    }

    /**
     * Méthode permettant de renvoyer la valeur d'une caractéristique (Carac) 
     * donnée en paramètre par son nom par rapport à la liste de caratéristiques 
     * de l'objet (Carte) appelant la méthode
     * 
     * @param nom nom de l'objet (Carac) à chercher dans la liste de 
     *            caractéristiques 'caracs' de l'objet (Carte) appelant la méthode (non null)
     * @return la valeur de l'objet (Carac) si présent dans 'caracs' ou sinon renvoie -1.0
     */
    public double getValeur(String nom){
        double valeur = -1.0;
        if (nom != null && this.caracs.length != 0){
            int i=0;
            boolean trouve=false;
            while(i<this.caracs.length && ! trouve){
                if(this.caracs[i] != null){
                    if (this.caracs[i].etreEgal(nom)){
                        trouve=true;
                        valeur = this.caracs[i].getValeur();
                    }
                }
                i++;
            }
        }
        return valeur;
    }

    /**
     * méthode accesseur de récupération du nom de l'objet
     * ajoutée pour les libtests
     * 
     * @return l'attribut 'nom' de l'objet (Carte) appelant la méthode
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * méthode accesseur de récuperation de l'état de visibilité de la carte
     * ajoutée pour les libtests
     * 
     * @return l'attribut 'visible' de l'objet (Carte) appelant la méthode
     */
    public boolean getVisible(){
        return this.visible;
    }

    /**
     * méthode permettant de changer la valeur de l'attribut 'visible' en true si false
     */
    public void setVisible(){
        this.visible = true;
    }

    /**
     * méthode permettant l'affichage de l'objet (Carte) appelant la fonction
     * affichage des valeurs des caractéristiques selon l'attribut de validité
     * 
     * Ex: Carte("Lapin", false, []) ==> "Lapin ->"
     * Ex: Carte("Lapin", false, [("taille", 10.0)]) ==> "Lapin -> *taille ???*"
     * Ex: Carte("Lapin", true, [("taille", 10.0),("poids, 20.0")]) ==> "Lapin -> *taille 10.0* *poids 20.0*"
     * 
     * @return une chaine qui représente l'objet appelant méthode
     */
    public String toString(){
        String chaine = this.nom+" ->";
        String chaine2;
        if(this.caracs == null){
            this.caracs = new Carac[0];
        }
        for (int i=0; i<this.caracs.length; i++){
            chaine2 = " *"+this.caracs[i].getNom()+" ";
            if(this.visible){
                chaine2 += this.caracs[i].getValeur();
            }
            else{
                chaine2 += "???";
            }
            chaine += chaine2+"*";
        }
        return chaine;
    }

    /**
     * méthode permettant de prendre une caractéristique au hasard de la carte appelant la méthode
     * 
     * @return la caractéristique tirée au hasard
     */
    public Carac prendreCaracHasard(){
        int nombreCarac = this.caracs.length;
        return this.caracs[new Random().nextInt(nombreCarac)];
    }

}