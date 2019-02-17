public class EtatCoffre_Bloque implements I_EtatCoffre {

    private static String nomEtat = "Bloqué";
    private static EtatCoffre_Bloque etatCoffre_bloque;

    private EtatCoffre_Bloque() {}

    public static EtatCoffre_Bloque getInstance() {
        if(etatCoffre_bloque == null) {
            etatCoffre_bloque = new EtatCoffre_Bloque();
        }
        return etatCoffre_bloque;
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

    }

    @Override
    public String getNomEtat() {
        return nomEtat;
    }
}
