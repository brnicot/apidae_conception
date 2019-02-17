public interface I_EtatCoffre {

    public static String nomEtat = "";

    public void oterLivre(Coffre c);

    public void remettreLivre(Coffre c);

    public void tournerChandelleVersDroite(Coffre c);

    public void tournerChandelleVersGauche(Coffre c);

    public void fermerCoffre(Coffre c);

    public String getNomEtat();

    default boolean peutOterLivreUML() {
        return false;
    }

    default boolean peutTournerChandelleVersDroite() {
        return false;
    }

    default boolean peutTournerChandelleVersGauche() {
        return false;
    }

    default boolean peutRemettreLivreUML() {
        return false;
    }

    default boolean peutFermerCoffre() {
        return false;
    }
}
