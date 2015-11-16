package br.net.sth.produto;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/pesquisar", method=RequestMethod.GET)
    Collection<Produto> pesquisar(@RequestParam(value="campo", defaultValue="codigo") String campo,
                                  @RequestParam(value="valor", defaultValue="0") String valor) {
        return produtoService.pesquisar(campo, valor);
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
