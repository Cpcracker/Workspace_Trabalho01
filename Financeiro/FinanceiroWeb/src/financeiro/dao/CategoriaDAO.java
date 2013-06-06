package financeiro.dao;

import java.util.List;
import financeiro.entity.Categoria;
import financeiro.entity.Usuario;

public interface CategoriaDAO {
	public Categoria salvar(Categoria categoria);
	public void excluir(Categoria categoria);
	public Categoria carregar(Integer categoria);
	public List<Categoria> listar(Usuario usuario);
}
