package nba_statistics.services;

import nba_statistics.dao.classes.MatchesDao;
import nba_statistics.entities.Mecze;

import java.util.List;

public class MatchesService{
    private static MatchesDao matchesDao;

    public MatchesService(){
        matchesDao = new MatchesDao();
    }

    public List<Mecze> findAll(){
        matchesDao.openCurrentSession();
        List<Mecze> matches = matchesDao.findAll();
        matchesDao.closeCurrentSession();
        return matches;
    }
    public void getData(String home, String away, String date, String season){
        matchesDao.openCurrentSessionwithTransaction();
        matchesDao.getData(home, away, date,season);
        matchesDao.closeCurrentSessionwithTransaction();
    }

    public void persist(Mecze entity) {
        matchesDao.openCurrentSessionwithTransaction();
        matchesDao.persist(entity);
        matchesDao.closeCurrentSessionwithTransaction();
    }
}
