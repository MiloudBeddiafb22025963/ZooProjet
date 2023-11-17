package zoo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Licorne extends Creature implements Creature.vivipaire {
    private static double poidsNaissance = 60;
    private static double poidsMaximum = 90;
    private static double tailleNaissance = 1.70;
    private static double tailleMaximum = 200;

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
            double poidsEnfant = poidsNaissance;
            Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, age, poidsNaissance, poidsMaximum);
            enfants.add(bebeLicorne);
            return bebeLicorne;
        } else {
            System.out.println("Cette licorne n'est pas adulte et ne peut pas se reproduire !");
            return null;
        }
    }
    public void canMettreBas() {
        Random rand = new Random();
        char sexeEnfant = rand.nextBoolean() ? 'F' : 'M';
        double poidsEnfant = poidsNaissance;

        Licorne bebeLicorne = new Licorne("Bébé Licorne", sexeEnfant, poidsEnfant, 0.5, 0, 0, 0, getAge(), poidsNaissance, poidsMaximum);
        enfants.add(bebeLicorne);
        System.out.println("La licorne a mis bas !");
    }
    
    public void vieillir() {
        if (getAge() >= 5) {
            this.taille = tailleMaximum;
            this.poids = poidsMaximum;
            if (!adultes.contains(this)) {
                adultes.add(this);
            }
        }
    }

    public int getAge() {
        return 0;
    }

    public void miseAJourEtat() {
        vieillir();
    }
    public void creatureTerrestre(EnclosSimple enclos) {
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
