package zoo;

public abstract class Creature {
    protected String nomEspece;
    protected char sexe;
    protected double poids;
    protected double taille;
    protected int age;
    protected int indicateurFaim;
    protected int indicateurSommeil;
    protected int indicateurSante;
    protected int indicateurProprete;


    public Creature(String nomEspece, char sexe, double poids, double taille, int age,
                    int indicateurFaim, int indicateurSommeil, int indicateurSante, int indicateurProprete) {
        this.nomEspece = nomEspece;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.indicateurFaim = indicateurFaim;
        this.indicateurSommeil = indicateurSommeil;
        this.indicateurSante = indicateurSante;
        this.indicateurProprete = indicateurProprete;
    }

    public void manger() {
        if (indicateurSommeil == 0) {
            if (indicateurFaim < 100) {
                indicateurFaim += 20;
                System.out.println(nomEspece + " mange.");
                System.out.println("Indicateur de faim : " + indicateurFaim);
            } else {
                System.out.println(nomEspece + " n'a pas faim pour le moment.");
            }
        } else {
            System.out.println(nomEspece + " ne peut pas manger car il dort.");
        }
    }
    
    public int getIndicateurProprete() {
        return indicateurProprete;
    }

    public void setIndicateurProprete(int indicateurProprete) {
        this.indicateurProprete = indicateurProprete;
    }

    public void updateSanteFromProprete() {

        if (indicateurProprete <= 25) {
            indicateurSante -= 10; 
        }
    }

    public void sEndormir() {
        if (indicateurSommeil == 1) {
            System.out.println(nomEspece + " est déjà endormi(e).");
        } else {
            indicateurSommeil = 1;
            System.out.println(nomEspece + " s'endort.");
        }
    }

    public void emettreSon() {
        System.out.println(nomEspece + " émet un son.");
    }

    public void vieillir() {
        age++;
        if (age >= 100) {
            System.out.println(nomEspece + " est décédé(e) de vieillesse.");
        }
    }

    public interface Run {
        void canRun();
    }

    public interface CanSwim {
        void canSwim();
    }

    public interface canFly {
		void canfly();
    }
    public void pandre() {
    	if (this instanceof vivipaire && getSexe() == 'F') {
            vivipaire creatureVivipaire = (vivipaire) this;
            creatureVivipaire.canMettreBas();
        } else {
            System.out.println("Cette créature ne peut pas pandre !");
        }
    	
    }
    public interface ovipaire{
    	void canPandre();
    	
    }
    public void mettreBas() {
        if (this instanceof vivipaire && getSexe() == 'F') {
            vivipaire creatureVivipaire = (vivipaire) this;
            creatureVivipaire.canMettreBas();
        } else {
            System.out.println("Cette créature ne peut pas mettre bas !");
        }
    }

    public interface vivipaire {
        void canMettreBas();
    }

    public String getNomEspece() {
        return nomEspece;
    }

    public char getSexe() {
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

    public int getIndicateurSommeil() {
        return indicateurSommeil;
    }

    public int getIndicateurSante() {
        return indicateurSante;
    }

    // Setters
    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }

    public void setIndicateurSommeil(int indicateurSommeil) {
        this.indicateurSommeil = indicateurSommeil;
    }

    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }

}
