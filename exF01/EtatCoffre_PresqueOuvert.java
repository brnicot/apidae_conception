public class EtatCoffre_PresqueOuvert extends EtatCoffre_Visible implements I_EtatCoffre {

    private static String nomEtat = "PresqueOuvert";
    private static EtatCoffre_PresqueOuvert etatCoffre_presqueOuvert;

    private EtatCoffre_PresqueOuvert() {}

    public static EtatCoffre_PresqueOuvert getInstance() {
        if(etatCoffre_presqueOuvert == null) {
            etatCoffre_presqueOuvert = new EtatCoffre_PresqueOuvert();
        }
        return etatCoffre_presqueOuvert;
    }

    @Override
    public void oterLivre(Coffre c) {

    }

    @Override
    public void tournerChandelleVersDroite(Coffre c) {
        c.setEtat(EtatCoffre_Ouvert.getInstance());
    }

    @Override
    public void fermerCoffre(Coffre c) {

    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }
}
