(function () {
  'use strict';

  angular.module('gp')
    .factory('Repositorio', Repositorio);

  Repositorio.$inject = ['Restangular', '$q'];

  function Repositorio(Restangular, $q) {

    var restangular = undefined;

    return function (tipoDeRepositorio) {
      restangular = Restangular.all(tipoDeRepositorio);
      var repositorio = {
        listar: listar,
        salvar: salvar,
        alterar: alterar,
        deletar: deletar,
        bucarPorCodigo: bucarPorCodigo,
        pesquisar: pesquisar
      };
      return repositorio;
    };

    function listar() {
      var deffered = $q.defer();
      restangular.getList().then(function (resultado) {
        resultado.remove = function (value) {
          if (this.indexOf(value) !== -1) {
            this.splice(this.indexOf(value), 1);
            return true;
          } else {
            return false;
          }
        };
        deffered.resolve(resultado);
      });
      return deffered.promise;
    }

    function salvar(entidade) {
      return restangular.post(entidade);
    }

    function alterar(produto) {
      return produto.put();
    }

    function deletar(codigo) {
      var deffered = $q.defer();
      restangular.one(String(codigo)).get().then(function (result) {
        return result.remove();
      }).then(function (result) {
        deffered.resolve(result);
      });
      return deffered.promise;
    }

    function bucarPorCodigo(codigo) {
      return restangular.one(codigo).get();
    }

    function pesquisar(campo, valor) {
      if(valor == '')
        return listar();

      return restangular.customGET("pesquisar", {'campo': campo, 'valor': valor} );
    }
  }

})();
