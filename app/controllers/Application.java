package controllers;

import models.Meta;
import models.dao.GenericDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {


	private static final GenericDAO dao = new GenericDAO();

	@Transactional
	public static Result index() {
		List<Meta> listaDeMetas = dao.findAllByClassName(Meta.class.getName());
		return ok(index.render(listaDeMetas));
	}

	@Transactional
	public static Result criaMeta(){
		DynamicForm form = Form.form().bindFromRequest();

		String nome = form.get("Nome");
		String semana = form.get("Semana");
		String descricao = form.get("Descricao");
		String prioridade = form.get("Prioridade");

		Meta meta = new Meta(nome, descricao, prioridade, Integer.parseInt(semana));
		dao.persist(meta);

		return index();
	}

	@Transactional
	public static Result setMetaAtingida(long id){
		Meta meta = dao.findByEntityId(Meta.class, id);
		meta.setStatus(true);
		dao.merge(meta);

		return index();
	}

	@Transactional
	public static Result deletaMeta(long id){
		DynamicForm form = Form.form().bindFromRequest();
		dao.removeById(Meta.class, id);

		return index();
	}
}

