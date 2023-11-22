import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lycanthrope extends Creature implements Creature.Vivipare {
    private static final double POIDS_NAISSANCE = 10;
    private static final double POIDS_MAXIMUM = 80;
    private static final double TAILLE_NAISSANCE = 10;
    private static final double TAILLE_MAXIMUM = 25;

    private List<Lycanthrope> enfants;
    private static List<Lycanthrope> adultes;

    public Lycanthrope(String nomEspece, char sexe, double poids, double taille, int age,
                       int indicateurFaim, int indicateurSommeil, int indicateurSante) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante);
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    public Lycanthrope seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Lycanthrope bebeLycanthrope = new Lycanthrope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 1, 0, 0, 0, 0);
            enfants.add(bebeLycanthrope);
            return bebeLycanthrope;
        } else {
            System.out.println("Ce Lycanthrope n'est pas un adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    public void accoucher() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Lycanthrope bebeLycanthrope = new Lycanthrope("Bébé Lycanthrope", sexeEnfant, poidsEnfant, 1, 0, 0, 0, 0);
        enfants.add(bebeLycanthrope);
        System.out.println("Le Lycanthrope a accouché !");
    }

    public void vieillir() {
        if (getAge() >= 7) {
            this.taille = TAILLE_MAXIMUM;
            this.poids = POIDS_MAXIMUM;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
    }

    public void mettreAJourEtat() {
        vieillir();
    }

    public void attribuerAEnclos() {
        if (this instanceof Lycanthrope) {
            Enclos enclos = new Enclos("Enclos Simple", 10, 10, false, false);
            enclos.ajouterCreature(this);
            System.out.println("Le Lycanthrope est placé dans un enclos simple.");
        } else {
            System.out.println("Cette créature devrait être assignée à un autre type d'enclos.");
        }
    }
}
