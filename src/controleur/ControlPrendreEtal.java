package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide() != false;
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		
	}

	public boolean verifierIdentite(String nomVendeur) {
		
		return village.trouverHabitant(nomVendeur) != null;
	}
}
