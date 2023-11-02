import java.util.Arrays;

public class Ecole {
    private String Nom;
    private int nbrEtudiants;
Etudiant[] Etudiants=new Etudiant[500];
    public Ecole(String nom) {
        Nom = nom;
    }
    public Etudiant[] getEtudiants() {
        return Etudiants;
    }

    public void setEtudiants(Etudiant[] etudiants) {
        Etudiants = etudiants;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }


    void ajouterEtudiant(Etudiant e) throws EtudiantExisteException {
        try {
        if (rechercherEtudiant(e) != -1)
            throw new EtudiantExisteException("etudiant existe deja");
        }

        catch (EtudiantExisteException ex){

        }
        if (nbrEtudiants == 500)
            System.out.println("School is FULL");
        else {
        Etudiants[nbrEtudiants] = e;
        nbrEtudiants++;
        System.out.println("etudiant ajoutée!"); }
        }

    int rechercherEtudiant (Etudiant e) {
        int index = -1;
        for (int i = 0; i < nbrEtudiants; i++) {
            if (e.getIdentifiant()== Etudiants[i].getIdentifiant())
                return i;
        }
        return index;
    }
    float getMoyenneDes3A() {
        float moy=0f;
        float moyenne3A=0f;
        int i=0;
        for (Etudiant etud : Etudiants) {

            if (etud instanceof Etudiant3eme) {
                if (((Etudiant3eme) etud).getBranche().equals("A"))
                    moy = moy+((Etudiant3eme) etud).getMoyenne();
                i++;
            }
        }
        moyenne3A=moy/i;
        return moyenne3A;
    }

    int moyenneSalaireAlternants(){
        int moyS=0;
        int moyenneEtudAlternant=0;
        int i=0;
        for (Etudiant etudiant : Etudiants) {

            if (etudiant instanceof EtudiantAlternance) {
                moyS= moyS +((EtudiantAlternance)etudiant).getSalaire();
                i++;
            }
        }
        moyenneEtudAlternant=moyS/i;
        return moyenneEtudAlternant;
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "Nom='" + Nom + '\'' +
                ", Etudiants=" + Arrays.toString(Etudiants) +
                '}';
    }

    boolean removeEtudiant(Etudiant e) {
        int indexE = rechercherEtudiant(e);
        if (indexE == -1)
            return false;
        for (int i = indexE; i < nbrEtudiants; i++) {
            Etudiants[i] = Etudiants[i + 1];
            Etudiants[nbrEtudiants] = null;
            this.nbrEtudiants--;
        }
        return true;
    }
    boolean changerEcole(Etudiant etd, Ecole e){
        boolean test=false;
        if(this.Nom.equals(e.getNom())) {
            if (rechercherEtudiant(etd) != -1)
                test = removeEtudiant(etd);
          return true;
        }
         else
            return false;
    }


}
