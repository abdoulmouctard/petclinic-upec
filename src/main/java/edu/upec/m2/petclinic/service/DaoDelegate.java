package edu.upec.m2.petclinic.service;
/**
 * 
 * @author s4665982
 *
 */
public class DaoDelegate {
	private static  EntityDao dao; 
    private DaoDelegate(){}

	public static final  <E> EntityDao getDaoImplementation(Class<E> entityClass){
		if(dao==null) {
			dao = new MemoryDatastoreDAO();
		}
		return dao;
	}
}
