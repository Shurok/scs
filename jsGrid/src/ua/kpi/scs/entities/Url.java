package ua.kpi.scs.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The persistent class for the urls database table.
 * 
 */
@Entity
@Table(name = "urls")
public class Url implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Lob()
	@Column(name = "CONTENT")
	private String content;

	@Column(name = "PARENT_URL_ID")
	private int parentUrlId;

	@Column(name = "URL")
	private String url;

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

}