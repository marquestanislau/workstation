package com.project.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(servletNames={"Faces Servlet"})
public class HibernateSessionFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtil.getSession();
		Transaction trx = null;
		
		try {
			trx = session.beginTransaction();
			
			request.setAttribute("session", session);
			System.out.println("Init ...");
			
			chain.doFilter(request, response);
			
			trx.commit();
			System.out.println("closing ...");
		} catch (Exception e) {
			if(trx != null) {
				trx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}

}
