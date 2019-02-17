import java.util.ArrayList;

public class Coffre implements I_CoffreChateau {

	private I_EtatCoffre etatCoffre;
	private boolean chienLibre;
	private boolean lapinLibre;
	private ArrayList<Observateur> auditeurs;

	/*
	 DONE :
		- Pattern état
		- Test coverage : OK avec 89% de coverage des lignes du projet entier
		- Pattern observateur
		- Pattern Stratégie & MVC
	 TODO :
	 	- Pattern Façade
	*/

	public Coffre() {
		auditeurs = new ArrayList<Observateur>();
		setEtat(EtatCoffre_Cache.getInstance());
	}

	@Override
	public void oterLivre() {
		etatCoffre.oterLivre(this);
		avertir();
	}

	@Override
	public void remettreLivre() {
		etatCoffre.remettreLivre(this);
		avertir();
	}

	@Override
	public void tournerChandelleVersDroite() {
		etatCoffre.tournerChandelleVersDroite(this);
		avertir();
	}

	@Override
	public void tournerChandelleVersGauche() {
		etatCoffre.tournerChandelleVersGauche(this);
		avertir();
	}

	@Override
	public void fermerCoffre() {
		etatCoffre.fermerCoffre(this);
		avertir();
	}

	@Override
	public boolean lapinEstLibere() {
		return lapinLibre;
	}

	@Override
	public boolean chienEstLibere() {
		return chienLibre;
	}

	@Override
	public String nomEtat() {
		return etatCoffre.getNomEtat();
	}

	@Override
	public boolean peutOterLivreUML() {
		return etatCoffre.peutOterLivreUML();
	}

	@Override
	public boolean peutTournerChandelleVersDroite() {
		return etatCoffre.peutTournerChandelleVersDroite();
	}

	@Override
	public boolean peutTournerChandelleVersGauche() {
		return etatCoffre.peutTournerChandelleVersGauche();
	}

	@Override
	public boolean peutRemettreLivreUML() {
		return etatCoffre.peutRemettreLivreUML();
	}

	@Override
	public boolean peutFermerCoffre() {
		return etatCoffre.peutFermerCoffre();
	}

	void lacherChien() {
		this.chienLibre = true;
		avertir();
	}

	void recupererChien() {
		this.chienLibre = false;
		avertir();
	}

	void lacherLapin() {
		this.lapinLibre = true;
		avertir();
	}

	I_EtatCoffre setEtat(I_EtatCoffre state) {
		this.etatCoffre = state;
		avertir();
		return etatCoffre;
	}

	boolean attacher(Observateur o) {
		auditeurs.add(o);
		o.mettreAJour(this);
		return true;
	}

	private void avertir() {
		for(Observateur o: auditeurs) {
			o.mettreAJour(this);
		}
	}

}
