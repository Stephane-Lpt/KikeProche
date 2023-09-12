import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de vérifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args liste d'arguments donnée en paramètre de l'exécution de la classe
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}
	
	/**
	 * test du constructeur d'une carte avec un paramètre valide
	 */
	public void test_01_constructeur_carte_1paramValide(){
		Carte c1 = new Carte("Grenouille");
		assertEquals("nom carte attendu= 'Grenouille'","Grenouille",c1.getNom());
	}

	/**
	 * test du constructeur d'une carte avec un paramètre invalide
	 */
	public void test_02_constructeur_carte_1paramNonValide(){
		Carte c1 = new Carte(null);
		assertEquals("nom carte non valide","inconnue",c1.getNom());
	}

	/**
	 * test de la méthode ajouterCarac avec un paramètre invalide
	 */
	public void test_03_methode_ajouterCarac_paramNonValide(){
		Carte c1 = new Carte("Grenouille");
		Carac ca1 = new Carac(null, 10.0);
		c1.ajouterCarac(ca1);
		assertEquals("caractéristique donné a c1",-1.0,c1.getValeur(null));
		assertEquals("création de l'objet donc face cachée",false,c1.getVisible());
	}

	/**
	 * test de la méthode ajouterCarac avec un paramètre valide et un getteur valide
	 */
	public void test_04_methode_ajouterCarac_paramValide_et_getValeur_paramValide(){
		Carte c1 = new Carte("Grenouille");
		Carac ca1 = new Carac("taille", 10.0);
		c1.ajouterCarac(ca1);
		assertEquals("caractéristique donné a c1",10.0,c1.getValeur("taille"));
		assertEquals("création de l'objet donc face cachée",false,c1.getVisible());
	}
	
	/**
	 * test de la méthode ajouterCarac avec un paramètre valide et un getteur invalide
	 */
	public void test_05_methode_ajouterCarac_paramValide_et_getValeur_paramNonValide(){
		Carte c1 = new Carte("Grenouille");
		Carac ca1 = new Carac("taille", 10.0);
		c1.ajouterCarac(ca1);
		assertEquals("caractéristique donné a c1",-1.0,c1.getValeur("test"));
		assertEquals("caractéristique donné a c1",-1.0,c1.getValeur(null));
		assertEquals("création de l'objet donc face cachée",false,c1.getVisible());
	}

	/**
	 * test du constructeur d'une carte avec des paramètres valides
	 */
	public void test_06_constructeur_2param_paramValide(){
		Carte c1 = new Carte("nom;carac1;carac2;carac3","Grenouille;10.0;20.0;05;0");
		assertEquals("attribut nom a 'Grenouille'","Grenouille",c1.getNom());
		assertEquals("attribut visisble sur false'",false,c1.getVisible());
	}

	/**
	 * test de la méthode changerVisible
	 */
	public void test_07_methode_changerVisible(){
		Carte c1 = new Carte("nom;carac1;carac2;carac3","Grenouille;10.0;20.0;05;0");
		assertEquals("attribut visisble sur false'",false,c1.getVisible());
		c1.setVisible();
		assertEquals("attribut visisble sur true'",true,c1.getVisible());		
	}
	
	/**
	 * test de la méthode toString
	 */
	public void test_08_methode_toString(){
		Carte c1 = new Carte("nom;carac1","Grenouille;10.0");
		Carte c2 = new Carte("nom;taille;poid", "Lapin;10.0;20.0");
		assertEquals("chaine a avoir'","Grenouille -> *carac1 ???*",c1.toString());
		assertEquals("chaine a avoir","Lapin -> *taille ???* *poid ???*",c2.toString());
		c1.setVisible();
		c2.setVisible();
		assertEquals("chaine a avoir'","Grenouille -> *carac1 10.0*",c1.toString());
		assertEquals("chaine a avoir","Lapin -> *taille 10.0* *poid 20.0*",c2.toString());
	}
}