import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de vérifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args liste d'arguments donnée en paramètre de l'exécution de la classe
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * test du constructeur vide
	 */
	public void test1_constructeur_1paramValide_et_methode_getNbCartes() {
		PaquetCarte paquet1 = new PaquetCarte("../cartes/animaux.csv");
		assertEquals("paquet devrait avoir 57 cartes", 57, paquet1.getNbCartes());
	}

	/**
	 * test des méthodes getCarte et setVisible
	 */
	public void test2_methode_getCarte_et_setVisible(){
		PaquetCarte paquet2 = new PaquetCarte("../cartes/animaux.csv");
		Carte c1 = paquet2.getCarte(0);
		assertEquals("chaine attendu", "lapin nain -> *taille ???* *poids ???* *longevite ???*", c1.toString());
		c1.setVisible();
		assertEquals("chaine attendu", "lapin nain -> *taille 19.0* *poids 1.3* *longevite 7.0*", c1.toString());

		Carte c2 = paquet2.getCarte(-1);
		assertEquals("indice non valide", null, c2);
	}

	/**
	 * test de la méthode ajouterCarteFin
	 */
	public void test3_methode_ajouterCarteFin(){
		PaquetCarte paquet1 = new PaquetCarte("../cartes/animaux.csv");
		Carte c1 = new Carte("nom;taille;poids;longevite","homme;180;80;80");

		paquet1.ajouterCarteFin(c1);
		assertEquals("indice non valide", "homme -> *taille ???* *poids ???* *longevite ???*", paquet1.getCarte(paquet1.getNbCartes()-1).toString());
		paquet1.getCarte(paquet1.getNbCartes()-1).setVisible();
		assertEquals("indice non valide", "homme -> *taille 180.0* *poids 80.0* *longevite 80.0*", paquet1.getCarte(paquet1.getNbCartes()-1).toString());
	}
	
	/**
	 * test de la méthode retirerCarte avec un paramètre valide
	 */
	public void test4_methode_retirerCarte_paramValide(){
		PaquetCarte paquet1 = new PaquetCarte("../cartes/animaux.csv");
		Carte c1 = paquet1.getCarte(0);
		assertEquals("chaine attendu", "lapin nain -> *taille ???* *poids ???* *longevite ???*", c1.toString());
		paquet1.retirerCarte(0);
		c1 = paquet1.getCarte(0);
		assertEquals("chaine attendu", "saint Bernard -> *taille ???* *poids ???* *longevite ???*", c1.toString());

		assertEquals("chaine attendu", null, paquet1.retirerCarte(-1));
	}

	/**
	 * test de la méthode retirerCarte avec un paramètre invalide
	 */
	public void test5_methode_retirerCarte_paramNonValide(){
		PaquetCarte paquet1 = new PaquetCarte("../cartes/animaux.csv");
		paquet1.retirerCarte(-1);
		Carte c1 = paquet1.getCarte(0);
		assertEquals("chaine attendu", "lapin nain -> *taille ???* *poids ???* *longevite ???*", c1.toString());

		paquet1.retirerCarte(paquet1.getNbCartes());
		assertEquals("chaine attendu", "lapin nain -> *taille ???* *poids ???* *longevite ???*", c1.toString());
	}
	
	/**
	 * test de la méthode toString
	 */
	public void test6_methode_toString(){
		PaquetCarte paquet1 = new PaquetCarte();
		assertEquals("chaine attendu", "", paquet1.toString());

		Carte[] tab = new Carte[1];
		tab[0] = new Carte("nom;taille","homme;180");
		PaquetCarte paquet2 = new PaquetCarte(tab);
		assertEquals("chaine attendu", "0. carte (homme -> *taille ???*)\n", paquet2.toString());
		
	}

	/**
	 * test de la méthode trouverCarteProche
	 */
	public void test7_methode_trouverCarteProche(){
		PaquetCarte paquet1 = new PaquetCarte("../cartes/animaux.csv");
		Carte c1 = paquet1.getCarte(10);
		assertEquals("indice attendue", 4, paquet1.trouverCarteProche(c1, "poids"));
		Carte c2 = paquet1.getCarte(5);
		assertEquals("indice attendue", 28, paquet1.trouverCarteProche(c2, "poids"));
	}


}