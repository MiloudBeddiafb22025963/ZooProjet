package zoo;

public class EnclosNageurs extends Enclos {
    private boolean verificationProfondeur;
    private boolean verificationSanite;

    public EnclosNageurs(String nom, double superficie, int capaciteMax, boolean verificationProfondeur, boolean verificationSanite) {
        super(nom, superficie, capaciteMax);
        this.verificationProfondeur = verificationProfondeur;
        this.verificationSanite = verificationSanite;
    }

    public void afficherCaracteristiques() {
        super.afficherCaracteristiques();
        System.out.println("Vérification de profondeur nécessaire : " + verificationProfondeur);
        System.out.println("Vérification de la santé de l'eau : " + verificationSanite);
    }

    public void ajouterCreature(Creature creature) {
        if (super.getNombreCreaturesPresentes() < super.getCapaciteMax()) {
            super.ajouterCreature();
            System.out.println(creature.getNomEspece() + " a été ajouté(e) à l'enclos " + super.getNom() + ".");
        } else {
            System.out.println("L'enclos " + super.getNom() + " est plein, impossible d'ajouter " + creature.getNomEspece() + ".");
        }
    }

    public void enleverCreature(Creature creature) {
        super.enleverCreature();
        System.out.println(creature.getNomEspece() + " a été enlevé(e) de l'enclos " + super.getNom() + ".");
    }

    public void nourrirCreatures() {
        System.out.println("Les créatures de l'enclos " + super.getNom() + " ont été nourries.");
    }

    public void signalerSaleEtVide() {
        super.verifierPropreteEtVide();
    }
}
