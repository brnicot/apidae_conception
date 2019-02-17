public class ControleurCoffre implements ControleurStrategie {

    private Coffre coffre;

    ControleurCoffre(Coffre boite) {
        coffre = boite;
    }

    @Override
    public void oterLivre() {
        coffre.oterLivre();
    }

    @Override
    public void remettreLivre() {
        coffre.remettreLivre();
    }

    @Override
    public void tournerChandelleVersDroite() {
        coffre.tournerChandelleVersDroite();
    }

    @Override
    public void tournerChandelleVersGauche() {
        coffre.tournerChandelleVersGauche();
    }

    @Override
    public void fermerCoffre() {
        coffre.fermerCoffre();
    }

}
