package dao;

import models.Eleve;

import java.sql.SQLException;
import java.util.List;

public interface IEleveDao {


       public Eleve ajouter(Eleve eleve) throws SQLException;
       public Eleve modifier(Eleve eleve);
       public void supprimer(int id);
       public List<Eleve> listerEleve();

       public Eleve obtenir(int id);

}
