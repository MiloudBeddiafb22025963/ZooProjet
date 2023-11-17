package zoo;

public class MaitreZoo {
    private String nom;
    private boolean sexe; // true pour masculin, false pour féminin
    private int age;

    // Constructeur
    public MaitreZoo(String nom, boolean sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    // Examiner un enclos pour voir ses caractéristiques
    public void examinerEnclos(Enclos enclos) {
        System.out.println("Examen de l'enclos : " + enclos.getNom());
        enclos.afficherCaracteristiques();
    }

    // Nettoyer un enclos
    public void nettoyerEnclos(Enclos enclos) {
        enclos.setProprete("Propre");
        System.out.println("L'enclos " + enclos.getNom() + " a été nettoyé.");
    }

    // Nourrir les créatures dans un enclos
    public void nourrirCreatures(Enclos enclos) {
        enclos.nourrirCreatures();
        System.out.println("Les créatures de l'enclos " + enclos.getNom() + " ont été nourries.");
    }

    // Transférer une créature d'un enclos à un autre
    public void transfererCreature(Enclos source, Enclos destination) {
        if (source != destination) {
            source.enleverCreature();
            destination.ajouterCreature();
            System.out.println("Une créature a été transférée de l'enclos " + source.getNom() +
                    " vers l'enclos " + destination.getNom() + ".");
        } else {
            System.out.println("Les enclos source et destination sont identiques. Aucun transfert effectué.");
        }
    }
}
