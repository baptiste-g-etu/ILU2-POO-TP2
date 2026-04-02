package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	ControlEmmenager controleur;
	
	@BeforeEach
	public void init() {
		System.out.println("Initialisation du Village.");
		village = new Village("La Gaule antique", 10, 1);
		chef = new Chef("Macronix", 1, village);
		village.setChef(chef);
		controleur = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controleur, "Le constructeur ne renvoie pas null.");
		
	}

	@Test
	void testIsHabitant() {
		
		assertTrue(controleur.isHabitant("Macronix"));
		assertFalse(controleur.isHabitant("Brigittix"));
	}

	@Test
	void testAjouterDruide() {
		controleur.ajouterDruide("Panoramix", 5, 1, 10);
		assertTrue(controleur.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		controleur.ajouterGaulois("Asterix", 15);
		assertTrue(controleur.isHabitant("Asterix"));
		
		
		assertThrows(AssertionError.class, () -> {
			controleur.ajouterGaulois("Gaulois_invalide", -3);
		});
		
	}

}
