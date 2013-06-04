package br.com.finan.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.finan.util.ExceptionUtil;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Tec
 *
 */
public interface AgenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws ExceptionUtil
	 */
	public T incluir(T object) throws ExceptionUtil;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws ExceptionUtil
	 */
	public T alterar(T object) throws ExceptionUtil;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws ExceptionUtil
	 */
	public T consultar(Integer id) throws ExceptionUtil;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws ExceptionUtil
	 */
	public void excluir(Integer id) throws ExceptionUtil;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws ExceptionUtil
	 */
	public List<T> listar() throws ExceptionUtil;
}
