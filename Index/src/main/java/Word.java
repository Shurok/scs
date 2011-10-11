
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the word database table.
 * 
 */
@Entity
@Table(name="word")
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-many association to Page
	@ManyToMany(mappedBy="words", fetch=FetchType.EAGER)
	private List<Page> pages;

    public Word() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Page> getPages() {
		return this.pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
}