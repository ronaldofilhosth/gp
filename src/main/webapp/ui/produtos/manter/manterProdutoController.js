(function () {
  'use strict';

  angular.module('gp')
    .controller('ManterProdutoController', ManterProdutoController);

  ManterProdutoController.$inject = ['$routeParams', '$location', 'Repositorio', 'safeApply'];

  function ManterProdutoController($routeParams, $location, Repositorio, safeApply) {

    /*jshint validthis: true */
    var vm = this;
    var repositorio = new Repositorio('produtos');

    this.status = $routeParams.codigo ? 'Editar' : 'Inserir';
    this.produto = {codigo: undefined};

    this.salvar = salvar;
    this.editar = editar;
    this.alterar = alterar;

    inicializar();

    function inicializar() {
      if ($routeParams.codigo)
        vm.editar($routeParams.codigo);
    }

    function salvar() {
      repositorio.salvar(vm.produto).then(function (resultado) {
        voltarParaListagem();
      });
    }

    function editar(codigo) {
      repositorio.bucarPorCodigo(codigo).then(function (resultado) {
        vm.produto = resultado;
      });
    }

    function alterar() {
      repositorio.alterar(vm.produto).then(function (resultado) {
        voltarParaListagem();
      });
    }

    function voltarParaListagem() {
      safeApply.apply($location.path('/produtos'));
    }

  }

})();
