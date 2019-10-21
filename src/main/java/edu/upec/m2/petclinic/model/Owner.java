package edu.upec.m2.petclinic.model;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author s4665982
 *
 */
public class Owner extends Person{
    private String address;

    private String city;

    private String telephone;

    private Set<Pet> pets;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
     if (this.pets == null) {
            this.pets = new HashSet<>();
     }
     return this.pets;
	}
    public void addPet(Pet pet) {
        if (pet.isNew()) {
        	getPets().add(pet);
        }
        pet.setOwner(this);
    }
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	/**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Pet getPet(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Pet pet : getPets()) {
            if (!ignoreNew || !pet.isNew()) {
                String compName = pet.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return pet;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new StringBuilder()

                .append("id : "+this.getId()).append("new : "+this.isNew())
                .append("lastName : "+ this.getLastName())
                .append("firstName : "+ this.getFirstName()).append("address : "+ this.address)
                .append("city : "+this.city).append("telephone : "+ this.telephone).toString();
    }
    
}
