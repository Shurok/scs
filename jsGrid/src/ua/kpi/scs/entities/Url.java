package ua.kpi.scs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = Url.GET_FREE_NOT_PARSED_URL, query = "SELECT p FROM Url p WHERE p.locked = false AND p.content IS NULL"),
		@NamedQuery(name = Url.GET_URL_BY_ADDRESS, query = "SELECT p FROM Url p WHERE p.url=:url") })
@Table(name = "urls")
public class Url implements Serializable {

	public static final String GET_FREE_NOT_PARSED_URL = "freeUrl";
	public static final String GET_URL_BY_ADDRESS = "urlByAddress";
	public static final int MAX_URL_LENGTH = 1000;

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob()
	@Column(name = "CONTENT")
	private String content;

	@Column(name = "PARENT_URL_ID")
	private int parentUrlId;

	@Column(name = "URL", length = MAX_URL_LENGTH)
	private String url;

	@Column(name = "LOCKED")
	private boolean locked;

	public Url() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParentUrlId() {
		return this.parentUrlId;
	}

	public void setParentUrlId(int parentUrlId) {
		this.parentUrlId = parentUrlId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}