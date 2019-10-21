package edu.upec.m2.petclinic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import edu.upec.m2.petclinic.model.BaseEntity;

public class MemoryDatastoreDAO<E extends BaseEntity>  implements EntityDao<Long, E > {
    private Map<Long, E> db = new ConcurrentHashMap<>();

	@Override
	public void persist(E entity) {
		if(entity.isNew()) {
			entity.setId(Long.valueOf(db.size()+1));
		}
		db.put(entity.getId(), entity);
		
	}

	@Override
	public void remove(E entity) {
		db.remove(entity.getId());
		
	}

	@Override
	public E findById(Long id) {
		// 
		return db.get(id);
	}

	@Override
	public List<E> findAll() {
		return new ArrayList<E>(db.values());
	}

	@Override
	public List<E> findByParam(Map<String, ? extends BaseEntity> param) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void close() {
		throw new UnsupportedOperationException();
		
	}
	
}
