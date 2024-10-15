import java.util.Enumeration;
import java.util.Vector;

public class Compte {
    private Vector<Integer> depots;
    private Vector<Integer> retraits;
    private int decouvert;

    public Compte() {
        this.depots = new Vector<>();
        this.retraits = new Vector<>();
        this.decouvert = 0;
    }

    public Compte(int decouvertInitial) {
        this();
        this.decouvert = decouvertInitial;
    }

    public void depotDe(int montant) {
        depots.add(montant);
    }

    public void retraitDe(int montant) {
        if (verifDecouvert(montant)) {
            retraits.add(montant);
        } else {
            System.out.println("Solde insuffisant pour effectuer le retrait de " + montant);
        }
    }

    public boolean verifDecouvert(int montant) {
        int sommeDepots = getSommeDepots();
        int sommeRetraits = getSommeRetraits();
        return (sommeDepots - sommeRetraits - montant) >= -this.decouvert;
    }

    public int getSolde() {
        int sommeDepots = getSommeDepots();
        int sommeRetraits = getSommeRetraits();
        return sommeDepots - sommeRetraits + this.decouvert;
    }

    public int getSommeDepots() {
        int sum = 0;
        Enumeration<Integer> enumeration = depots.elements();
        while (enumeration.hasMoreElements()) {
            sum += enumeration.nextElement();
        }
        return sum;
    }

    public int getSommeRetraits() {
        int sum = 0;
        Enumeration<Integer> enumeration = retraits.elements();
        while (enumeration.hasMoreElements()) {
            sum += enumeration.nextElement();
        }
        return sum;
    }

    public int getDecouvert() {
        return this.decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    public static void main(String[] args) {
        Compte monCompte = new Compte(10000);

        System.out.println("Le solde initial contient " + monCompte.getDecouvert());

        monCompte.depotDe(200);
        System.out.println("Après dépôt le solde est " + monCompte.getSolde());

        monCompte.retraitDe(400);
        System.out.println("Après retrait le solde est " + monCompte.getSolde());
        System.out.println("Le solde final contient " + monCompte.getSolde());
    }
}
