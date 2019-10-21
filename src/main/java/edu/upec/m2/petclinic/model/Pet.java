package edu.upec.m2.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pet extends NamedEntity{
	    private LocalDate birthDate;

	    private PetType type;

	    private Owner owner;

	    private transient Set<Visit> visits = new LinkedHashSet<>();

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public PetType getType() {
			return type;
		}

		public void setType(PetType type) {
			this.type = type;
		}

		public Owner getOwner() {
			return owner;
		}

		public void setOwner(Owner owner) {
			this.owner = owner;
		}

		public Set<Visit> getVisits() {
	        if (this.visits == null) {
	            this.visits = new HashSet<>();
	        }
	        return this.visits;
		}

		public void setVisits(Set<Visit> visits) {
			this.visits = visits;
		}
	    public void addVisit(Visit visit) {
	    	getVisits().add(visit);
	        visit.setPet(this);
	    }	    
}
