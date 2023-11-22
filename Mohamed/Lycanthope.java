import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Licorne extends Creature implements Creature.Vivipare {
    private static final double POIDS_NAISSANCE = 60;
    private static final double POIDS_MAXIMUM = 90;
    private static final double TAILLE_NAISSANCE = 1.70;
    private static final double TAILLE_MAXIMUM = 200;

    private List<Licorne> enfants;
    private static List<Licorne> adultes;

    public Licorne(String nomEspece, char sexe, double poids, double taille, int age,
                   int indicateurFaim, int indicateurSommeil, int indicateurSante,
                   double poidsNaissance, double poidsMaximum) {
        super(nomEspece, sexe, poids, taille, age, indicateurFaim, indicateurSommeil, indicateurSante, indicateurSante);
        this.poidsNaissance = poidsNaissance;
        this.poidsMaximum = poidsMaximum;
        this.enfants = new ArrayList<>();

        if (adultes == null) {
            adultes = new ArrayList<>();
        }
    }

    public Licorne seReproduire() {
        if (adultes.contains(this)) {
            Random rand = new Random();
            char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
            double poidsEnfant = POIDS_NAISSANCE;
            Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
            enfants.add(bebeLicorne);
            return bebeLicorne;
        } else {
            System.out.println("Cette licorne n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }

    public void mettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = POIDS_NAISSANCE;

        Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), POIDS_NAISSANCE, POIDS_MAXIMUM);
        enfants.add(bebeLicorne);
        System.out.println("La licorne a mis bas !");
    }
    
    public void vieillir() {
        if (getAge() >= 5) {
            this.taille = TAILLE_MAXIMUM;
            this.poids = POIDS_MAXIMUM;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
    }

    public int getAge() {
        return 0; // À remplacer par la vraie logique de calcul de l'âge
    }

    public void miseAJourEtat() {
        vieillir();
    }
    
    public void attribuerAEnclos(EnclosSimple enclos) {
        if (this instanceof Licorne) {
            if (enclos instanceof EnclosSimple) {
                enclos.ajouterCreature(this);
                System.out.println("La Licorne ne vole pas et ne nage pas, elle doit être dans un enclos simple.");
            } else {
                System.out.println("Cette créature terrestre doit être attribuée à un enclos simple.");
            }
        } else {
            System.out.println("Cette créature doit être attribuée à un autre enclos.");
        }
    }
}
