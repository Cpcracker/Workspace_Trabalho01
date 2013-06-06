package financeiro.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import financeiro.web.ContextoBean;

/**
 * Classe criada apenas para obter o contextoBean da sessão corrente.
 * @author manoel.freitasjunior
 *
 */
public class ContextoUtil {
	/**
	 * Obtem o ContextoBean da sessão corrente.
	 * @return ContextoBean
	 */
	public static ContextoBean getContextoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		return contextoBean;
	}
	
	
}
