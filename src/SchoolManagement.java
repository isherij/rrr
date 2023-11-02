public class SchoolManagement {
    public static void main(String [] args) throws EtudiantExisteException {
        Ecole E =new Ecole("pere blanc");
        Etudiant etd1 =(Etudiant) new Etudiant3eme(1,"erij","mazouz",17.5f,"A");
        Etudiant etd2 =(Etudiant) new Etudiant3eme(2,"EEE","fff",14.5f,"A");
        Etudiant3eme etd3 =new Etudiant3eme(3,"cc","ww",11.5f,"A");
        Etudiant3eme etd6 =new Etudiant3eme(5,"cc","ww",17.8f,"A");
        EtudiantAlternance etd4 =new EtudiantAlternance(4,"rr","bbb",11.7f,1000);
        Etudiant etd5 =(Etudiant)new EtudiantAlternance(5,"ss","uuu",10.5f,2000);

        try {
            E.ajouterEtudiant(etd2);
        } catch (EtudiantExisteException e) {
            System.out.println(e.getMessage());
        }
        try {
            E.ajouterEtudiant(etd1);
        } catch (EtudiantExisteException e) {
            System.out.println(e.getMessage());
        }
        try {
            E.ajouterEtudiant(etd3);
        } catch (EtudiantExisteException e) {
            System.out.println(e.getMessage());
        }
        try {
            E.ajouterEtudiant(etd4);
        } catch (EtudiantExisteException e) {
            System.out.println(e.getMessage());
        }
        try {
            E.ajouterEtudiant(etd6);
        } catch (EtudiantExisteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(E.getMoyenneDes3A());
        System.out.println(E.moyenneSalaireAlternants());
        System.out.println(E.toString());
        System.out.println(E.changerEcole(etd2,E));
        System.out.println(E.toString());
    }
}
