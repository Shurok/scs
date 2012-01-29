package ua.kpi.scs.dao.impl;

import org.springframework.stereotype.Component;

import ua.kpi.scs.dao.AbstractDao;
import ua.kpi.scs.entities.Url;

@Component
public class UrlDaoImpl extends AbstractDao {

	public Url findUrlById(final Integer urlId) {
		return this.em.find(Url.class, urlId);
	}

	public Url save(final Url url) {
		return this.em.merge(url);
	}

}