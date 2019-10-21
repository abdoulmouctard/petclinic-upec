package edu.upec.m2.petclinic.model;
/**
 * 
 * @author s4665982
 *
 */
public class NamedEntity extends BaseEntity{
	private String name;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return this.getName();
    }	
}
