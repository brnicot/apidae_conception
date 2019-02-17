import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffreTest {
	
	private I_CoffreChateau coffre;

	@Before
	public void setUp() throws Exception {
		coffre = new Coffre();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	// PLJ
	public void testAuDemarrage() {
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	// PLJ
	public void testApresAvoirOteLeLivreDeLaBibliotheque() {
		coffre.oterLivre();
		assertEquals("Fermé",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	// PLJ
	public void testApresAvoirRemisLeLivreDansLaBibliothequeSansAvoirTouchePrealablementALaChandelle() {
		coffre.oterLivre();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	// CAS NORMAUX
	@Test
	public void testApresAvoirOteLeLivreDeLaBibliothequeEtTourneChandelleADroiteUneFois() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		assertEquals("PresqueOuvert",coffre.nomEtat());
		assertTrue(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
	
	@Test
	public void testApresAvoirOteLeLivreDeLaBibliothequeEtTourneChandelleADroiteDeuxFois() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertEquals("Ouvert",coffre.nomEtat());
		assertTrue(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
	
	@Test
	public void testApresAvoirOteLeLivreDeLaBibliothequeEtTourneChandelleADroiteDeuxFoisEtFermeCoffre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		assertEquals("Fermé",coffre.nomEtat());
		assertTrue(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
	
	@Test
	public void testApresAvoirOteLeLivreDeLaBibliothequeEtTourneChandelleADroiteDeuxFoisEtFermeCoffreEtRemettreLivre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		coffre.fermerCoffre();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	public void testApresAvoirOteLeLivreDeLaBibliothequeEtTournerChandelleAGauche() {
		coffre.oterLivre();
		coffre.tournerChandelleVersGauche();
		assertEquals("Bloqué",coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertTrue(coffre.lapinEstLibere());
	}

	// CAS TIRÉS PAR LES CHEVEUX
	@Test
	public void testApresAvoirTourneChandelleAGaucheUneFois() {
		coffre.tournerChandelleVersGauche();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	public void testApresAvoirTourneChandelleAGaucheDeuxFois() {
		coffre.tournerChandelleVersGauche();
		coffre.tournerChandelleVersGauche();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());	}

	@Test
	public void testApresAvoirTourneChandelleADroiteUneFois() {
		coffre.tournerChandelleVersDroite();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	public void testApresAvoirTourneChandelleADroiteDeuxFois() {
		coffre.tournerChandelleVersDroite();
		coffre.tournerChandelleVersDroite();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}

	@Test
	public void testApresAvoirOteLeLivreEtRemisLeLivre() {
		coffre.oterLivre();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
	
	@Test
	public void testApreAvoirOteLivrePuisTourneChandelleADroitePuisRemisLivre() {
		coffre.oterLivre();
		coffre.tournerChandelleVersDroite();
		coffre.remettreLivre();
		assertEquals("CacheParBibliotheque", coffre.nomEtat());
		assertFalse(coffre.chienEstLibere());
		assertFalse(coffre.lapinEstLibere());
	}
	
	

}
