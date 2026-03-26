package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder texte = new StringBuilder();
		if(!nomVendeurConnu) {
			System.out.println(nomVendeur);
			texte.append("Je suis désolé " + nomVendeur + " mais il faut être un habitant du village pour commercer ici.\n");
			System.out.println(texte.toString());
		
		}else {
			texte.append(String.format("Bonjour %s, je vais regarder si je peux vous trouvez un étal.\n", nomVendeur));
			System.out.println(texte.toString());
			texte.setLength(0);
			
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				texte.append(String.format("Désolé %s, je n'ai plus d'étal qui ne soit pas déjà occupé.\n", nomVendeur));
				System.out.println(texte.toString());
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder texte = new StringBuilder();
		texte.append("C'est parfait, il me reste un étal pour vous !\n"
				+ "Il me faudrait quelques renseignements : \n"
				+ "Quel produit souhaitez vous vendre ?");
		String produit = Clavier.entrerChaine(texte.toString());
		
		int nb = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nb);
		
		if(numeroEtal != -1) {
			System.out.println(String.format("Le vendeur %s s'est installé(e) à l'étal n°%d", nomVendeur, numeroEtal));
		}
		
	}
}














