import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

	/**
	 * test du constructeur avec un nom
	 */

	public void test1_constructeur() {
		Carte carte = new Carte("grenouille");
		assertEquals("le nom de la carte doit être grenouille","grenouille",carte.getNom());
		assertEquals("la carte ne doit avoir aucune caractéristique",0,carte.getCaracs().length);
	}

	/**
	 * test de la méthode ajouterCarac
	 */

	public void test2_ajouterCarac() {
		Carte carte = new Carte("grenouille");
		Carac c = new Carac("force", 5.0);
		carte.ajouterCarac(c);
		assertEquals("le nom de la carte doit être grenouille","grenouille",carte.getNom());
		assertEquals("la carte doit avoir une caractéristique",1,carte.getCaracs().length);
	}

	public void test3_getValeur(){
		Carte carte = new Carte("grenouille");
		Carac c = new Carac("force", 5.0);
		carte.ajouterCarac(c);
		assertEquals("le nom de la carte doit être grenouille","grenouille",carte.getNom());
		assertEquals("la carte doit avoir une caractéristique",1,carte.getCaracs().length);
		assertEquals("la caractéristique force doit avoir la valeur 5.0",5.0,carte.getCaracs()[0].getValeur());
	}

	public void test4_getValeur(){
		Carte carte = new Carte("grenouille");
		Carac c = new Carac("force", 5.0);
		carte.ajouterCarac(c);
		assertEquals("le nom de la carte doit être grenouille","grenouille",carte.getNom());
		assertEquals("la carte doit avoir une caractéristique",1,carte.getCaracs().length);
		assertEquals("la caractéristique force doit avoir la valeur 5.0",5.0,carte.getCaracs()[0].getValeur());
	}



}
