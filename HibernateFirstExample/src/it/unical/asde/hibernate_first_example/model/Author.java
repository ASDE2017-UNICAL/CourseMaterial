package it.unical.asde.hibernate_first_example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String provenance;
	
	
	public Author() {
		super();
	}

	public Author(String name, String provenance) {
		super();
		this.name = name;
		this.provenance = provenance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
