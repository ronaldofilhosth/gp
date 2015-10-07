package br.net.sth.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Collection;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository descricaoRepository;

    Collection<Produto> listarTodos() {
        return descricaoRepository.findAll();
    }

    Produto salvar(@RequestBody @Valid Produto produto) {
        return descricaoRepository.saveAndFlush(produto);
    }

    Produto buscar(long codigo) {
        return descricaoRepository.findOne(codigo);
    }

    Produto alterar(Produto produto) {
        return descricaoRepository.save(produto);
    }

    void deletar(long codigo) {
        descricaoRepository.delete(codigo);
    }
}
