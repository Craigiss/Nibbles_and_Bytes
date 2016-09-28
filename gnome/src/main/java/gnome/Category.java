package gnome;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Category {
	//Connor

	@OneToMany
	@JoinColumn(name = "id", nullable = false)
	private int Id;
	@JoinColumn(name = "name", nullable = false)
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
