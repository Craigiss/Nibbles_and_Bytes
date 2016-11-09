package com.nb.gnome.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
/**
 * @author Nibbles and Bytes
 * @version 1.0
 * 
 *          This class is for the suppliers used by NB Gardens business and uses
 *          variables to model the data needed for the system.
 **/


@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "name", nullable = false, length =225)
	@NotNull
	@Size(min = 2, max = 225)
	private String name;
	/**
	 * @return the id
	 */
	
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;
	
	
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setId(int i) {
		this.id = i;
		
	}
	
}
