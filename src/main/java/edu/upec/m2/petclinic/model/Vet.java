package edu.upec.m2.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{
	private Set<Specialty> specialties;
	
	protected Set<Specialty> getSpecialties() {
        if (this.specialties == null) {
            this.specialties = new HashSet<>();
        }
        return this.specialties;
    }

    protected void setSpecialtiesInternal(Set<Specialty> specialties) {
        this.specialties = specialties;
    }



    public int getNrOfSpecialties() {
        return getSpecialties().size();
    }

    public void addSpecialty(Specialty specialty) {
    	getSpecialties().add(specialty);
    }
	
}

