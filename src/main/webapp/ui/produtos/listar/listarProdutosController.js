(function () {
  'use strict';

  angular.module('gp')
    .controller('ListarProdutosController', ListarProdutosController);

  ListarProdutosController.$inject = ['Repositorio'];

  function ListarProdutosController(Repositorio) {

    /*jshint validthis: true */
    var vm = this;
    var repositorio = new Repositorio('produtos');

    vm.produtos = [];
    vm.valorPesquisa = '';
    vm.camposParaPesquisa = [{desc: 'Código', valor: 'codigo'}, {desc: 'Descrição', valor: 'descricao'}];
    vm.campoParaPesquisa = vm.camposParaPesquisa[1].valor;

    vm.deletar = deletar;
    vm.pesquisar = pesquisar;

    inicializar();

    function inicializar() {
      repositorio.listar().then(function (resultado) {
        vm.produtos = resultado;
      });
    }

    function deletar(produto) {
      repositorio.deletar(produto.codigo).then(function (resultado) {
        vm.produtos.remove(produto);
      });
    }

    function pesquisar() {
      repositorio.pesquisar(vm.campoParaPesquisa, vm.valorPesquisa).then(function (resultado) {
        vm.produtos = resultado;
      });
    }

  }

})();
