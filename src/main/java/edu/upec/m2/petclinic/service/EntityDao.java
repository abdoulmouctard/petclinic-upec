package edu.upec.m2.petclinic.service;

import java.util.List;
import java.util.Map;

import edu.upec.m2.petclinic.model.BaseEntity;

/**
 * 
 * @author s4665982
 *
 */
public interface EntityDao<K, E extends BaseEntity> {
    void persist(E entity);
    void remove(E entity);
    E findById(K id);
    List<E> findAll();
    List<E> findByParam(Map<String, ? extends BaseEntity> param);
    void close();
}