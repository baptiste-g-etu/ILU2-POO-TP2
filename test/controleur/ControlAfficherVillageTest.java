package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;

class ControlAfficherVillageTest {

	private Village village;
	private Chef chef;
	private ControlAfficherVillage controleur;
	
	@BeforeEach
	public void init() {
		System.out.println("Initialisation du Village.");
		village = new Village("La Gaule antique", 10, 1);
		chef = new Chef("Abbraracourcix", 1, village);
		village.setChef(chef);
		controleur = new ControlAfficherVillage(village);
	}
	
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controleur);
	}

	@Test
	void testDonnerNomsVillageois() {
		village.ajouterHabitant(new Druide("Panoramix", 5, 1, 10));
		village.ajouterHabitant(new Gaulois("Asterix", 10));
		village.ajouterHabitant(new Gaulois("Obélix", 99));
		
		String[] tab = {"Abbraracourcix", "le druide Panoramix", "Asterix", "Obélix"};
		String[] tabRetourne = controleur.donnerNomsVillageois();
		
		
		for(int i=0; i<tabRetourne.length; ++i) {
			assertTrue(tab[i].equals(tabRetourne[i]));
		}
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
