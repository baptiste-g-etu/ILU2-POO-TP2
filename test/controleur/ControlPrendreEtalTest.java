package controleur;

import static org.junit.jupiter.api.Assertions.*;
import personnages.*;
import villagegaulois.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private ControlPrendreEtal controleur;
	private ControlVerifierIdentite ctrl_id;
	private Gaulois asterix;
	
	
	@BeforeEach
	public void setUpBeforeClass() {
		System.out.println("Initialisation du Village.");
		village = new Village("La Gaule antique", 10, 1);
		chef = new Chef("Abbraracourcix", 1, village);
		village.setChef(chef);
		
		asterix = new Gaulois("Astérix", 5);
		village.ajouterHabitant(asterix);
		
		ctrl_id = new ControlVerifierIdentite(village);
		controleur = new ControlPrendreEtal(ctrl_id, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controleur, "Null");
		
	}

	@Test
	void testResteEtals() {
		assertTrue(controleur.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		assertEquals(controleur.prendreEtal("Asterix", "Epee", 0), -1);
		assertEquals(controleur.prendreEtal("Astérix", "Epee", 5), 0);
		assertEquals(controleur.prendreEtal("Obélix ", "Epee", 5),-1);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controleur.verifierIdentite("Astérix"));
		assertFalse(controleur.verifierIdentite("Obélix"));
	}

}
