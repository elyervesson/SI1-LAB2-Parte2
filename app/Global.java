import play.*;
import models.Meta;
import models.dao.GenericDAO;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    public void onStart(Application app) {
        JPA.withTransaction(() -> {
            /*
            dao.persist(new Meta("Estudar SI", "Preciso melhorar minha nota no lab", "baixa", 1));
            dao.persist(new Meta("Estudar ES", "Preciso melhorar minha nota no mini-teste", "media", 2));
            dao.persist(new Meta("Estudar Linear", "Preciso entender algum assunto do segundo estagio", "alta", 3));
            dao.persist(new Meta("Estudar OAC", "Preciso ganhar os 1s decimos", "baixa", 4));
            dao.persist(new Meta("Estudar Logica Matematica", "Essa materia não tem logica '-'", "media", 5));
            dao.persist(new Meta("Estudar p/ Projeto", "Preciso aprender d3 =/", "alta", 6));
            */
        });
    }
}
