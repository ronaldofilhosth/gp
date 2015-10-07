(function () {
  'use strict';

  /**
   * @ngdoc overview
   * @name gp
   * @description
   *
   * Modulo principal da aplicação.
   */
  angular
    .module('gp', [
      'ngResource',
      'ngRoute',
      'ngTouch',
      'restangular'
    ])
    .config(config);

  function config($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'ui/dashboard/dashboard.html'
      })
      .when('/produtos', {
        templateUrl: 'ui/produtos/listar/listarProdutos.html',
        controller: 'ListarProdutosController',
        controllerAs: 'vm'
      })
      .when('/produtos/editar/:codigo', {
        templateUrl: 'ui/produtos/manter/manterProduto.html',
        controller: 'ManterProdutoController',
        controllerAs: 'vm'
      })
      .when('/produtos/inserir', {
        templateUrl: 'ui/produtos/manter/manterProduto.html',
        controller: 'ManterProdutoController',
        controllerAs: 'vm'
      })
      .when('/404', {
        templateUrl: '404.html'
      })
      .otherwise({
        redirectTo: '/404'
      });
  }

})();
