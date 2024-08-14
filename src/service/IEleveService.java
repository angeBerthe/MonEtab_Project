package service;

import models.Eleve;

import java.util.List;

public interface IEleveService {

    Eleve save(Eleve eleve);
    Eleve update(Eleve eleve);
    void delete(int id);
    List<Eleve> getAll();

    Eleve getOne(int id);


}
