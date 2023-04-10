package Gym;

public class Program {
    public static void main(String[] args) {
        Actiune[] actiuni = {Actiune.DESCHIDE, Actiune.ADAUGA_ABONAT, Actiune.AFISEAZA_PERSOANE, Actiune.ADAUGA_ANTRENOR, Actiune.AFISEAZA_ABONAT_MAX, Actiune.AFISEAZA_ANTRENORI, Actiune.AFISEAZA_PERSOANE, Actiune.ELIMINA_PERSOANA, Actiune.INCHIDE};
        SalaFitness sala = new SalaFitness();

        try{
            for(Actiune actiune : actiuni){
                sala.Actiune(actiune);
            }
        }   catch (PersoanaNuExista e){
            System.out.println("Exceptie.");
            e.printStackTrace();
        }
    }
}
