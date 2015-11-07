package mz.co.sisgf.service;

import java.util.List;

import mz.co.sisgf.model.Banco;
import mz.co.sisgf.model.dao.BancoDAO;
import mz.co.sisgf.model.dao.SimpleEntityManager;

public class BancoService {
	
	private BancoDAO bancoDao;
	private SimpleEntityManager simpleEntityManager;

	public BancoService(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
		bancoDao = new BancoDAO(simpleEntityManager.getEntityManager());
	}

	public void salvar(Banco b) {
		try {
			simpleEntityManager.beginTransaction();
			bancoDao.save(b);
			simpleEntityManager.commit();
		} catch (Exception e) {
			simpleEntityManager.rollBack();
		}
	}

	public List<Banco> todos() {
		return bancoDao.findAll();
	}

	public void apagar(Banco banco) {
		try {
			simpleEntityManager.beginTransaction();
			bancoDao.delete(bancoDao.getById(banco.getId()));
			simpleEntityManager.commit();
		} catch (Exception e) {
			simpleEntityManager.rollBack();
		}
	}
}
