package gnome;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Category")
public class Category {
	// Connor

	@OneToMany
	@JoinColumn(name = "id", nullable = false)
	private int Id;
	@Id
	@Column(name = "name", nullable = false, length =225)
	@NotNull
	@Size(min = 2, max = 225)
	private String name;
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
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
	
}
