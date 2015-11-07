package mz.co.sisgf.service;

import java.util.List;

import mz.co.sisgf.model.Utilizador;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.model.dao.UtilizadorDao;
import mz.co.sisgf.util.ApenasUmUsuarioException;

public class UtilizadorService {

	private UtilizadorDao dao;
	private SimpleEntityManager simpleEntityManager;

	public UtilizadorService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		dao = new UtilizadorDao(simpleEntityManager.getEntityManager());
	}

	public List<Utilizador> todos() {
		try {
			return dao.findAll();
	
		} catch (Exception e) {
			simpleEntityManager.rollBack();
		}
		return null;
	}

	public void salvar(Utilizador utilizador) {
		try {
			this.simpleEntityManager.beginTransaction();
			System.out.println(todos().isEmpty());
			if (todos().isEmpty()) {
				dao.save(utilizador);
				this.simpleEntityManager.commit();
			} else {
				throw new ApenasUmUsuarioException("O sistema suporta apenas um utilizador!");
			}
		} catch (Exception e) {
			this.simpleEntityManager.rollBack();
		}
	}
}
