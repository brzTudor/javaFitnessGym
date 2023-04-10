package Gym;

public class Antrenor extends Persoana{
    int nrAbonati;

    public Antrenor(String nume, int varsta, int nrAbonati){
        super(nume, varsta);
        this.nrAbonati = nrAbonati;
    }

    @Override
    void afiseazaInformatii(){
        System.out.println("Antrenorul se numeste: " + nume + ", are varsta " + varsta + " si " + nrAbonati + " abonati.");
    }
}
