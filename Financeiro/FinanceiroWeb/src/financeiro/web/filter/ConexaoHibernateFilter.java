package financeiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import financeiro.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter{

	private SessionFactory sessionFactory;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		try {
			this.sessionFactory.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sessionFactory.getCurrentSession().getTransaction().commit();
			this.sessionFactory.getCurrentSession().close();
		} catch (Throwable e) {
			try {
				if (this.sessionFactory.getCurrentSession().getTransaction().isActive()){
					this.sessionFactory.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
