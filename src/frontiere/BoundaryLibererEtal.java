package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//StringBuilder histoire = new StringBuilder();
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché auj !");
		}else {
			String [] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0] != null) {
				System.out.println(String.format("Vous avez vendu %s sur %s %s. \nAu revoir %s, passez une bonne journée", donneesEtal[4], donneesEtal[3], donneesEtal[2], donneesEtal[1]));
			}
		}
	}

}
