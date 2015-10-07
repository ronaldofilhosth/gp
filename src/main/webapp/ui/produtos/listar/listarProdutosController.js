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

    vm.deletar = deletar;

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

  }

})();
