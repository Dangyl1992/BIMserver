package org.bimserver.servlets;

import javax.servlet.ServletConfig;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.bimserver.BimServer;
import org.bimserver.web.RestAuthentication;

public class RestServlet extends CXFNonSpringJaxrsServlet {
	private static final long serialVersionUID = 6288864278630843847L;
	
	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
		getBus().getInInterceptors().add(new RestAuthentication(bimServer));
	}
}