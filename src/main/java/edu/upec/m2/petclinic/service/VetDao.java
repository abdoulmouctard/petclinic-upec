package edu.upec.m2.petclinic.service;

import java.util.List;
import java.util.Map;

import edu.upec.m2.petclinic.model.BaseEntity;
import edu.upec.m2.petclinic.model.Vet;
/**
 * 
 * @author s4665982
 *
 */
public class VetDao implements EntityDao<Long, Vet>{
	private EntityDao<Long, Vet> dao = DaoDelegate.getDaoImplementation(Vet.class);
	@Override
	public void persist(Vet entity) {
		dao.persist(entity);
		
	}

	@Override
	public void remove(Vet entity) {
		dao.remove(entity);
		
	}

	@Override
	public Vet findById(Long id) {

		return dao.findById(id);
	}

	@Override
	public List<Vet> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Vet> findByParam(Map<String, ? extends BaseEntity> param) {
		return dao.findByParam(param);
	}

	@Override
	public void close() {
		dao.close();
		
	}

}
