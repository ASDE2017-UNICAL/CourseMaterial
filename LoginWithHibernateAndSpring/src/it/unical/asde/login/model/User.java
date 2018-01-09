package it.unical.asde.login.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author bernardo
 *
 */
@Entity
@Table
public class User {
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn
	@Cascade(value={CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private Credentials credentials;
	
	@OneToMany(mappedBy="owner")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private List<Car> cars;

	public User(Credentials credentials, List<Car> cars) {
		super();
		this.credentials = credentials;
		this.cars = cars;
	}
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	
	
}
