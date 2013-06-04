package br.com.finan.persistencia;

import org.springframework.stereotype.Repository;

import br.com.finan.entidade.Cliente;

/**
 * @author TecnologiaTi
 * 
 */
@Repository
public class ClienteDAOImpl extends AgenericoDAOImpl<Cliente, Integer> implements
		ClienteDAO {

}
