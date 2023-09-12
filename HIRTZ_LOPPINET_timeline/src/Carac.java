/**
 * Classe (Carac) qui représente une caractéristique avec un nom et une valeur
 * Carac:(nomCara:String, valeur:double)
 * 
 * Exemple : Carac('taille',10.6) 
 */
public class Carac{
    /**
     * attribut qui définit le nom de la caractéristique
     */
    private String nomCarac;
    /**
     * attribut représentant la valeur de la caractéristique
     */
    private double valeur;

    /**
     * constructeur 2 paramètres
     * 
     * Ex: 'newNomCarac'="Grenouille" et 'newValeur'=10.0 donne Carac("Grenouille", 10.0)
     * 
     * Attention: si 'newNomCarac' est égal à null alors utilisation constructeur par défaut
     * 
     * @param newNomCarac  nom de la nouvelle caractéristique (non null sinon="inconnu")
     * @param newValeur    valeur réelle de la nouvelle caractéristique
     */
    public Carac(String newNomCarac, double newValeur){
        if(newNomCarac == null){
            newNomCarac = "inconnu";
        }
        this.nomCarac = newNomCarac;
        this.valeur = newValeur;
    }

    /**
     * méthode accesseur de récupération de l'attribut 'nomCarac'
     * 
     * @return l'attribut 'nomCarac' de l'objet (Carac) appelant la méthode
     */
    public String getNom(){
        return this.nomCarac;
    }

    /**
     * méthode accesseur de récupération de l'attribut 'valeur'
     * 
     * @return l'attribut 'valeur' de l'objet appelant la méthode
     */
    public double getValeur(){
        return this.valeur;
    }

    /**
     * méthode qui vérifit si l'attribut 'nomCarac' de l'objet 
     * appelant la méthode est égal au paramètre 'nom' de la méthode
     * 
     * @param nom chaine de caractères à comparer
     * @return true: 'nomCarac'='nom' / false: 'nomCarac'!='nom'
     */
    public boolean etreEgal(String nom){
        return this.nomCarac.equals(nom);
    }
}