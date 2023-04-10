package Gym;

public class Persoana {
    String nume;
    int varsta;
    int id;
    static int nrPersoane = 0;

    public Persoana(String nume, int varsta){
        this.nume = nume;
        this.varsta = varsta;
        this.id = nrPersoane;
        nrPersoane++;
    }

    void afiseazaInformatii(){
        System.out.println("Persoana se numeste: " + nume + " si are varsta " + varsta);
    }
}
