package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder form_druide = new StringBuilder();
		form_druide.append("Bienvenue duide " + nomVisiteur + ".\nQuelle est votre force?");
		int forceDruide = Clavier.entrerEntier(form_druide.toString());
		int effetPotionMin = 0;
		int effetPotionMax = 0;
		
		do {
			form_druide.setLength(0);
			form_druide.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(form_druide.toString());
			
			form_druide.setLength(0);
			form_druide.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(form_druide.toString());
			
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Prenez garde, Druide, vous vous êtes trompé entre le min et le max.");
			}
		}while(effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder form_gaulois = new StringBuilder();
		form_gaulois.append("Bonjour villageois " + nomVisiteur + ".\nQuelle est votre force?");
		int force = Clavier.entrerEntier(form_gaulois.toString());
		
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
	
}
