package nba_statistics.dao.classes;

import nba_statistics.HibernateUtil;
import nba_statistics.dao.interfaces.IPlayersDao;
import nba_statistics.entities.Druzyny;
import nba_statistics.entities.Zawodnicy;
import nba_statistics.services.TeamsService;

public class PlayersDao extends Dao implements IPlayersDao {


    public PlayersDao(){

    }
    public void persist(Zawodnicy entity) {
        getCurrentSession().save(entity);
    }

    public void getData(String name, String surname, String date, float height, float weight, String team) {
        Zawodnicy z = new Zawodnicy(name, surname, date, height, weight);
        TeamsService teamsService = new TeamsService();
        Druzyny d = teamsService.getTeam(team);
        z.setDruzyna(d);
        persist(z);

    }

    public void updatePlayer(String name, String surname, String team){
        //Query<Zawodnicy> theQuery = getCurrentSession().createQuery("from Zawodnicy where imie = :name and nazwisko = :surname",Zawodnicy.class);
        TeamsService teamsService = new TeamsService();
        Druzyny d = teamsService.getTeam(team);
        int id = d.getId();

        getCurrentSession().createQuery("update Zawodnicy set id_druzyny = :id  where imie = :name and nazwisko = :surname")
                .setParameter("id", id)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .executeUpdate();


    }

}
