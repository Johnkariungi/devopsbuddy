package com.devopsbuddy.backend.persistence.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plan implements Serializable {
	
	/** The Serial Version UID for serializable classes. */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id; /** use int for we have a tiny number of plans, just 2 */
	private String name;

	/** Default constructor. */
	public Plan() {}

	/** getters and setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/** has and equals method solely on the id attribute for this is the primary key */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
