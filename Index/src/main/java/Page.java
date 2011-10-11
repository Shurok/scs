
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the page database table.
 * 
 */
@Entity
@Table(name="page")
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="URL")
	private String url;

	//bi-directional many-to-many association to Word
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="word_has_page"
		, joinColumns={
			@JoinColumn(name="PAGE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="WORD_ID")
			}
		)
	private List<Word> words;

    public Page() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Word> getWords() {
		return this.words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
	
}