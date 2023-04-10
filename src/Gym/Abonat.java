package Gym;

public class Abonat extends Persoana{
    int progres;

    public Abonat(String nume, int varsta, int progres){
        super(nume, varsta);
        this.progres = progres;
    }

    @Override
    void afiseazaInformatii(){
        System.out.println("Abonatul se numește " + nume + ", are varsta " + varsta + " și are progresul egal cu  " + progres);
    }
}
