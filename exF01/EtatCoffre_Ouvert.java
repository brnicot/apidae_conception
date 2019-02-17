public class EtatCoffre_Ouvert implements I_EtatCoffre {

    private static String nomEtat = "Ouvert";
    private static EtatCoffre_Ouvert etatCoffre_ouvert;

    private EtatCoffre_Ouvert() {}

    public static EtatCoffre_Ouvert getInstance() {
        if(etatCoffre_ouvert == null) {
            etatCoffre_ouvert = new EtatCoffre_Ouvert();
        }
        return etatCoffre_ouvert;
    }

    @Override
    public void oterLivre(Coffre c) {

    }

    @Override
    public void remettreLivre(Coffre c) {

    }

    @Override
    public void tournerChandelleVersDroite(Coffre c) {

    }

    @Override
    public void tournerChandelleVersGauche(Coffre c) {

    }

    @Override
    public void fermerCoffre(Coffre c) {
        c.setEtat(EtatCoffre_Ferme.getInstance());
    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }

    @Override
    public boolean peutFermerCoffre() {
        return true;
    }
}
