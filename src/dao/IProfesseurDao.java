package dao;

import models.Professeur;

import java.util.List;

public interface IProfesseurDao {

        Professeur ajouter(Professeur professeur);
        Professeur modifier(Professeur professeur);
        void supprimer(int id);
        List<Professeur> listerProfesseurs();
        Professeur obtenir(int id);

}
