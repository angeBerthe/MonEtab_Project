package service;

import models.Eleve;

import java.sql.SQLException;
import java.util.List;

public interface IEleveService {

    public Eleve save(Eleve eleve) throws SQLException;
    public Eleve update(Eleve eleve);
    public void delete(int id);
    public List<Eleve> getAll();

   public Eleve getOne(int id);


}
