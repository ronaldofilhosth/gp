package br.net.sth.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue
	private Long codigo;

	private String descricao;

    public Produto(Long id, String description) {
        this.codigo = id;
        this.descricao = description;
    }

    public Produto(String description) {
        this.descricao = description;
    }

    public Produto() {
    }

    public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
