public abstract class EtatCoffre_Visible implements I_EtatCoffre {

    private static String nomEtat = "Visible";

    @Override
    public void oterLivre(Coffre c) {

    }

    @Override
    public void remettreLivre(Coffre c) {
        c.recupererChien();
        c.setEtat(EtatCoffre_Cache.getInstance());
    }

    @Override
    public void tournerChandelleVersDroite(Coffre c) {

    }

    @Override
    public void tournerChandelleVersGauche(Coffre c) {
        c.lacherLapin();
        c.setEtat(EtatCoffre_Bloque.getInstance());
    }

    @Override
    public void fermerCoffre(Coffre c) {

    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }

    @Override
    public boolean peutRemettreLivreUML() {
        return true;
    }

    @Override
    public boolean peutTournerChandelleVersGauche() {
        return true;
    }

    @Override
    public boolean peutTournerChandelleVersDroite() {
        return true;
    }
}
