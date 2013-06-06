package financeiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

@Entity
@Table (name = "USUARIO")
public class Usuario implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8955797734659639554L;

	@Id
	@GeneratedValue
	@Column (name = "codigo",  nullable = false, length = 11)
	private Integer codigo;
	
	@Column (name = "nome", length = 50)
	private String nome;
	
	@Column (name = "email", length = 100)
	private String email;
	
	@NaturalId
	@Column (name = "login", length = 50)
	private String login;
	
	@Column (name = "senha", length = 11)
	private String senha;
	
	@Column (name = "nascimento")
	private Date nascimento;
	
	@Column (name = "celular", length = 25)
	private String celular;
	
	@Column (name = "idioma", length = 5, nullable = false)
	private String idioma;
	
	@Column (name = "ativo", length = 1, nullable = false)
	private boolean ativo;
	
	@ElementCollection (targetClass = String.class)
	@JoinTable (name = "USUARIO_PERMISSAO",
				uniqueConstraints = {@UniqueConstraint(columnNames={"usuario", "permissao"})},
				joinColumns = @JoinColumn(name = "usuario")
			)
	@Column (name = "permissao", length = 50)
	private Set<String> permissao = new HashSet<String>();
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
}
