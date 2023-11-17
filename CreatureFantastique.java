public abstract class CreatureFantastique {
    String nom;
    String sexe;
    double poids;
    double taille;
    int age;
    int indicateurFaim;
    boolean dort;
    int indicateurSante;

    public CreatureFantastique(String nom, String sexe, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = 100; // À l'initialisation, la créature n'a pas faim
        this.dort = false; // À l'initialisation, la créature n'est pas endormie
        this.indicateurSante = 100; // À l'initialisation, la créature est en bonne santé
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getIndicateurFaim() {
        return indicateurFaim;
    }

    public boolean isDort() {
        return dort;
    }

    public int getIndicateurSante() {
        return indicateurSante;
    }

    public abstract void manger();

    public abstract void emettreSon();

    public abstract void soigner();

    public void dormir() {
        if (!dort) {
            System.out.println(nom + " s'endort...");
            dort = true;
        } else {
            System.out.println(nom + " est déjà endormi.");
        }
    }

    public void reveiller() {
        if (dort) {
            System.out.println(nom + " se réveille...");
            dort = false;
        } else {
            System.out.println(nom + " est déjà réveillé.");
        }
    }

    public void vieillir() {
        age++;
        System.out.println(nom + " vieillit. Age actuel : " + age);
        if (age == 10) {
            System.out.println(nom + " est devenu trop vieux et meurt.");
            indicateurSante = 0;
        }
    }
}
