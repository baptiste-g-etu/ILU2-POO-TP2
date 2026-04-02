package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.*;
import personnages.*;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void init() {
		System.out.println("Initialisation du Village.");
		village = new Village("La Gaule antique", 10, 1);
		chef = new Chef("Macronix", 1, village);
		village.setChef(chef);
	}
	
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controleur = new ControlVerifierIdentite(village);
		assertNotNull(controleur);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controleur = new ControlVerifierIdentite(village);
		assertTrue(controleur.verifierIdentite("Macronix"));
		assertFalse(controleur.verifierIdentite("Panoramix"));
	}

}
