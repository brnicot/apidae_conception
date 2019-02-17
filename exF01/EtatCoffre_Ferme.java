public class EtatCoffre_Ferme extends EtatCoffre_Visible implements I_EtatCoffre {

    private static String nomEtat = "Fermé";
    private static EtatCoffre_Ferme etatCoffre_ferme;

    private EtatCoffre_Ferme() {}

    public static EtatCoffre_Ferme getInstance() {
        if(etatCoffre_ferme == null) {
            etatCoffre_ferme = new EtatCoffre_Ferme();
        }
        return etatCoffre_ferme;
    }

    @Override
    public void oterLivre(Coffre c) {

    }

    @Override
    public void tournerChandelleVersDroite(Coffre c) {
        c.lacherChien();
        c.setEtat(EtatCoffre_PresqueOuvert.getInstance());
    }

    @Override
    public void fermerCoffre(Coffre c) {

    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }
}
