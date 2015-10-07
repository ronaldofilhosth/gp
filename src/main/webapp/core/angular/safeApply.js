(function () {
  'use strict';

  safeApply.$inject = ['$rootScope'];

  angular.module('gp')
    .service('safeApply', safeApply);

  function safeApply($rootScope) {

    this.apply = apply;

    function apply(fn) {
      var phase = $rootScope.$$phase;
      if (phase == '$apply' || phase == '$digest') {
        if (fn && (typeof(fn) === 'function')) {
          fn();
        }
      } else {
        $rootScope.$apply(fn);
      }
    }

  }

})();
