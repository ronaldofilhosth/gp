package br.net.sth.produto;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

	@RequestMapping
	Collection<Produto> listarTodos() {
        return produtoService.listarTodos();
	}

    @RequestMapping(method = RequestMethod.POST)
    Produto salvar(@RequestBody @Valid Produto produto) {
        return produtoService.salvar(produto);
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    Produto buscar(@PathVariable("codigo") long codigo) {
        return produtoService.buscar(codigo);
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.PUT)
    Produto alterar(@PathVariable("codigo") long codigo, @RequestBody @Valid Produto produto) {
        return produtoService.alterar(produto);
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.DELETE)
    ResponseEntity<Boolean> deletar(@PathVariable("codigo") long codigo) {
        produtoService.deletar(codigo);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
