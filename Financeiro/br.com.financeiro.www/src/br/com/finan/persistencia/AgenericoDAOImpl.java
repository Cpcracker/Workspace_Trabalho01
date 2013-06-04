package br.com.finan.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.finan.util.ExceptionUtil;

/**
 * @author TecnologiaTi
 * 
 */
public class AgenericoDAOImpl<T, ID extends Serializable> implements
		AgenericoDAO<T, ID> {

	private EntityManager entityManager;
	private final Class<T> oClass;

	// Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	// Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public AgenericoDAOImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws ExceptionUtil
	 */
	public T incluir(T object) throws ExceptionUtil {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			throw new ExceptionUtil(e, "N�o foi poss�vel realizar a inclus�o.");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws ExceptionUtil
	 */
	public T alterar(T object) throws ExceptionUtil {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			throw new ExceptionUtil(e, "N�o foi poss�vel realizar a altera��o.");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * 
	 * @param id
	 * @return
	 * @throws ExceptionUtil
	 */
	public T consultar(Integer id) throws ExceptionUtil {
		T object = null;
		try {
			object = getEntityManager().find(getObjectClass(), id);
		} catch (EntityNotFoundException e) {
			throw new ExceptionUtil(e, "Registro n�o encontrado.");
		} catch (Exception e) {
			throw new ExceptionUtil(e, "N�o foi poss�vel realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T da base de dados
	 * 
	 * @param id
	 * @throws ExceptionUtil
	 */
	public void excluir(Integer id) throws ExceptionUtil {
		try {
			getEntityManager().remove(
					getEntityManager().getReference(getObjectClass(), id));
		} catch (EntityNotFoundException e) {
			throw new ExceptionUtil(e, "Registro n�o encontrado para exclus�o.");
		} catch (Exception e) {
			throw new ExceptionUtil(e, "N�o foi poss�vel realizar a exclus�o.");
		}

	}

	/**
	 * Lista os objetos T da base de dados
	 * 
	 * @return
	 * @throws ExceptionUtil
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws ExceptionUtil {
		List<T> lista = null;
		try {
			Query query = getEntityManager().createQuery(
					"SELECT object(o) FROM " + getObjectClass().getSimpleName()
							+ " AS o");
			lista = query.getResultList();
		} catch (Exception e) {
			throw new ExceptionUtil(e, "Problemas na localiza��o dos objetos");
		}
		return lista;
	}

}
