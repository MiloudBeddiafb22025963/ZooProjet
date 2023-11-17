package zoo;

public class Enclos {
    private String nomEnclos;
    private double superficie;
    private int capaciteMax;
    private int nombreCreaturesPresentes;
    private String degreProprete;

    // Constructeur
    public Enclos(String nomEnclos, double superficie, int capaciteMax) {
        this.nomEnclos = nomEnclos;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.nombreCreaturesPresentes = 0;
        this.degreProprete = "Propre";
    }
    public void definirNomEnclos(String nomEnclos) {
        this.nomEnclos= nomEnclos;
    }
    // Afficher les caractéristiques de l'enclos
    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nomEnclos);
        System.out.println("Superficie: " + superficie + " m²");
        System.out.println("Capacité maximale: " + capaciteMax + " créatures");
        System.out.println("Nombre de créatures présentes: " + nombreCreaturesPresentes);
        System.out.println("Degré de propreté: " + degreProprete);
    }

    // Ajouter une créature à l'enclos
    public void ajouterCreature() {
        if (nombreCreaturesPresentes < capaciteMax) {
            nombreCreaturesPresentes++;
            System.out.println("Une créature a été ajoutée à l'enclos.");
        } else {
            System.out.println("L'enclos est plein. Impossible d'ajouter une nouvelle créature.");
        }
    }	

    // Enlever une créature de l'enclos
    public void enleverCreature() {
        if (nombreCreaturesPresentes > 0) {
            nombreCreaturesPresentes--;
            System.out.println("Une créature a été enlevée de l'enclos.");
        } else {
            System.out.println("L'enclos est vide. Aucune créature à enlever.");
        }
    }

    // Nourrir les créatures
    public void nourrirCreatures() {
        System.out.println("Les créatures de l'enclos ont été nourries.");
    }

    // Vérifier la propreté et le vide de l'enclos
    public void verifierPropreteEtVide() {
        if (nombreCreaturesPresentes == 0) {
            System.out.println("L'enclos est vide.");
        }

        if (degreProprete.equals("Sale")) {
            System.out.println("L'enclos est sale. Il a besoin d'être nettoyé.");
        }
    }

    // Setters pour la propreté de l'enclos
    public void setProprete(String degreProprete) {
        this.degreProprete = degreProprete;
    }
	public String getNom() {
		return null;
	}
	public int getNombreCreaturesPresentes() {
		// TODO Auto-generated method stub
		return 0;
	}
}


