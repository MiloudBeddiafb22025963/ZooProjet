package zoo;

public class EnclosVoltigeurs extends Enclos {
    private boolean verificationToit;

    public EnclosVoltigeurs(String nom, double superficie, int capaciteMax, boolean verificationToit) {
        super(nom, superficie, capaciteMax);
        this.verificationToit = verificationToit;
    }
}
