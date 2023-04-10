package Gym;

import java.sql.SQLOutput;

public class SalaFitness {
    Persoana[] persoane = new Persoana[3];
    int nrPersoane;
    boolean esteDeschisa;

    private void deschide(){
        esteDeschisa = true;
        System.out.println("Sala s-a deschis.");
    }

    private void adaugaAntrenor(String nume, int varsta, int nrAbonati){
        Antrenor antrenor = new Antrenor(nume, varsta, nrAbonati);

        if(nrPersoane < 3){
            for(int i=0; i < persoane.length; i++){
                if(persoane[i] == null) {
                    persoane[i] = antrenor;
                    break;
                }
            }
            nrPersoane++;
            System.out.println("A intrat in sala antrenorul " + nume);
        }
        else{
            System.out.println("Din pacate sala este plina si " + nume + " nu mai poate intra.");
        }
    }

    private void adaugaAbonat(String nume, int varsta, int progres){
        Abonat abonat = new Abonat(nume, varsta, progres);

        if(nrPersoane < 3){
            for(int i=0; i < persoane.length; i++){
                if(persoane[i] == null){
                    persoane[i] = abonat;
                    break;
                }
            }
            nrPersoane++;
            System.out.println("A intrat in sala abonatul " + nume);
        }
        else{
            System.out.println("Din pacate sala este plina si " + nume + " nu mai poate intra.");
        }
    }

    private void afiseazaPersoane(){
        if(nrPersoane > 0){
            System.out.println("In sala se afla urmatoarele persoane: ");
            for(Persoana persoana : persoane){
                if(persoana != null){
                    persoana.afiseazaInformatii();
                }
            }
        } else {
            System.out.println("Sala este goala.");
        }
    }

    private void afiseazaAntrenori(){
        boolean existaAntrenori = false;
        for(Persoana persoana : persoane){
            if(persoana instanceof Antrenor){
                existaAntrenori = true;
                persoana.afiseazaInformatii();
            }
        }
        if(!existaAntrenori){
            System.out.println("Nu sunt antrenori in sala de fitness.");
        }
    }

    private void afiseazaAbonatCuProgresMax(){
        int max = -1;
        Persoana persoanaCuProgresMax = null;
        for(Persoana persoana : persoane){
            if(persoana instanceof Abonat){
                if(((Abonat) persoana).progres > max){
                    max = ((Abonat) persoana).progres;
                    persoanaCuProgresMax = persoana;
                }
            }
        }

        if(max == -1){
            System.out.println("Nu exista niciun abonat in sala.");
        } else {
            System.out.println("Persoana cu cel mai mare progres din sala este: " + persoanaCuProgresMax.nume);
        }
    }

    private void eliminaPersoana(int id) throws PersoanaNuExista {
        boolean persoanaGasita = false;
        for(int i=0; i < persoane.length; i++){
            if(persoane[i] != null && persoane[i].id == id){
                System.out.println("Persoana " + persoane[i].nume + " iese din sala.");
                persoane[i] = null;
                nrPersoane--;
                persoanaGasita = true;
            }
        }

        if (!persoanaGasita){
            throw new PersoanaNuExista();
        }
    }

    private void inchide(){
        esteDeschisa = false;
        System.out.println("Sala s-a inchis.");
    }

    void Actiune(Actiune actiune) throws PersoanaNuExista {
        if(esteDeschisa == false && actiune != Actiune.DESCHIDE){
            throw new SalaInchisa();
        }

        switch(actiune){
            case DESCHIDE: {
                deschide();
                break;
            }

            case ADAUGA_ANTRENOR: {
                adaugaAntrenor(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaNrAbonati());
                break;
            }

            case ADAUGA_ABONAT: {
                adaugaAbonat(ClasaUtilitara.genereazaNume(), ClasaUtilitara.genereazaVarsta(), ClasaUtilitara.genereazaProgres());
                break;
            }

            case AFISEAZA_PERSOANE: {
                afiseazaPersoane();
                break;
            }

            case AFISEAZA_ABONAT_MAX: {
                afiseazaAbonatCuProgresMax();
                break;
            }

            case ELIMINA_PERSOANA: {
                eliminaPersoana(ClasaUtilitara.genereazaId());
                break;
            }

            case INCHIDE: {
                inchide();
                break;
            }

            default: {
                System.out.println("Actiunea nu este valida.");
            }
        }
    }

}
