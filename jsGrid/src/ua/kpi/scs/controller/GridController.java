package ua.kpi.scs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.kpi.model.Page;
import ua.kpi.service.PageService;

@Controller
public class GridController {
	private static final Logger LOGGER = Logger.getLogger(GridController.class);

	@RequestMapping(value = "process.htm")
	public String showPage(final HttpServletRequest request) {

		return "process";
	}

	@RequestMapping(value = "getpage.htm")
	@ResponseBody
	public Page getPage(final HttpServletRequest request) {
		new PageService().getPage();
		LOGGER.error("fffffffffffffffffffffffffff");
		return new PageService().getPage();
	}
}
