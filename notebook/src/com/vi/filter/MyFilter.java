package com.vi.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vi.util.HibernateUtil;

public class MyFilter extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session s=null;
		Transaction ts=null;
		try{
			s=HibernateUtil.getCurrentSession();
			ts=s.beginTransaction();
			arg2.doFilter(arg0, arg1);
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			HibernateUtil.closeSessionFactory();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
