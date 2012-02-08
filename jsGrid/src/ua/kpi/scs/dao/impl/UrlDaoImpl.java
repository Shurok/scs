package ua.kpi.scs.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ua.kpi.scs.dao.AbstractDao;
import ua.kpi.scs.entities.Url;

@Component
public class UrlDaoImpl extends AbstractDao {

	public Url findUrlById(final Integer urlId) {
		return this.em.find(Url.class, urlId);
	}

	@Transactional(readOnly = false)
	public String findAddressToParse() {
		final Query query = this.em
				.createNamedQuery(Url.GET_FREE_NOT_PARSED_URL);

		final Url url = (Url) query.getResultList().get(0);
		url.setLocked(true);
		this.em.merge(url);
		return url.getUrl();
	}

	// @Transactional(readOnly = false)
	// public Url unlock(final String address, String content) {
	// final Query query = this.em.createNamedQuery(Url.GET_URL_BY_ADDRESS);
	// query.setParameter(0, address);
	// final Url url = (Url) query.getSingleResult();
	// final Url url2 = this.em.merge(url);
	// return url2;
	// }

	@Transactional(readOnly = false)
	public Url save(final Url url) {
		Url url2Return = url;
		final Query query = this.em.createNamedQuery(Url.GET_URL_BY_ADDRESS);
		query.setParameter("url", url.getUrl());
		if (query.getResultList().size() == 0) {
			url2Return = this.em.merge(url);
			em.flush();
		}
		return url2Return;
	}

}