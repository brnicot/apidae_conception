public class EtatCoffre_Cache implements I_EtatCoffre {

    private static String nomEtat = "CacheParBibliotheque";
    private static EtatCoffre_Cache etatCoffre_cache;

    private EtatCoffre_Cache() {}

    public static EtatCoffre_Cache getInstance() {
        if(etatCoffre_cache == null) {
            etatCoffre_cache = new EtatCoffre_Cache();
        }
        return etatCoffre_cache;
    }

    @Override
    public void oterLivre(Coffre c) {
        c.setEtat(EtatCoffre_Ferme.getInstance());
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
    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }

    @Override
    public boolean peutOterLivreUML() {
        return true;
    }

}
