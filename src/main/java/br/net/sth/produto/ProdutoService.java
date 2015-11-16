package br.net.sth.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    Collection<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    Produto salvar(@RequestBody @Valid Produto produto) {
        return produtoRepository.saveAndFlush(produto);
    }

    Produto buscar(long codigo) {
        return produtoRepository.findOne(codigo);
    }

    private Collection<Produto> buscar(String codigo){
        Collection<Produto> resultado = new ArrayList<>();
        Produto produto = buscar(Long.valueOf(codigo));
        if(produto!=null)
            resultado.add(produto);
        return resultado;
    }

    Collection<Produto> pesquisar(String campo, String valor) {
        switch (campo){
            case "codigo":
                return buscar(valor);
            case "descricao":
                return produtoRepository.findByDescricaoLike("%" + valor + "%");
        }
        return new ArrayList<>();
    }

    Produto alterar(Produto produto) {
        return produtoRepository.save(produto);
    }

    void deletar(long codigo) { produtoRepository.delete(codigo); }
}
