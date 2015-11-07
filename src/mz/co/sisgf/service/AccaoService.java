package mz.co.sisgf.service;

import java.util.List;

import mz.co.sisgf.model.Accao;
import mz.co.sisgf.model.dao.AccaoDAO;
import mz.co.sisgf.model.dao.SimpleEntityManager;

public class AccaoService {

	private AccaoDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public AccaoService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new AccaoDAO(simpleEntityManager.getEntityManager());
	}

	public void salvar(Accao accao) {
		try {
			this.simpleEntityManager.beginTransaction();
			dao.save(accao);
			this.simpleEntityManager.commit();
		} catch (Exception e) {
			this.simpleEntityManager.rollBack();
		}
	}

	public void apagar(Accao accao) {
		try {
			this.simpleEntityManager.beginTransaction();
			dao.delete(dao.getById(accao.getId()));
			System.out.println("Apagar............");
			this.simpleEntityManager.commit();
		} catch (Exception e) {
			this.simpleEntityManager.rollBack();
		}
	}

	public List<Accao> todos() {
		try {
			return dao.findAll();
		} catch (Exception e) {
			this.simpleEntityManager.rollBack();
		}
		return null;
	}
}
