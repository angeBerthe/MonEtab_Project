package service.impl;

import dao.impl.EleveDaoImpl;
import models.Eleve;
import service.IEleveService;


import java.sql.SQLException;
import java.util.List;

public class EleveServiceImpl implements IEleveService {

    private EleveDaoImpl eleveDao;

    public  EleveServiceImpl (EleveDaoImpl eleveDao){
        this.eleveDao = new EleveDaoImpl();
    }
    @Override
    public Eleve save(Eleve eleve) throws SQLException {
        return eleveDao.ajouter(eleve);
    }

    @Override
    public Eleve update(Eleve eleve) {
        return eleveDao.modifier(eleve);
    }

    @Override
    public void delete(int id) {
        eleveDao.supprimer(id);
    }

    @Override
    public List<Eleve> getAll() {
        return eleveDao.listerEleve();
    }

    @Override
    public Eleve getOne(int id) {
        return eleveDao.obtenir(id);
    }
}