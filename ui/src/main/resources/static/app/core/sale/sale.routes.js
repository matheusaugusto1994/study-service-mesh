(function() {
	'use strict';

	angular.module('hello').config(function($routeProvider) {
		
		$routeProvider.when('/sales/new', {
			templateUrl : 'app/core/sale/sale.form.html',
			controller : 'saleFormController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/sales/', {
			templateUrl : 'app/core/sale/sale.list.html',
			controller : 'saleListController',
			controllerAs : 'controller'
		});
		
		
	});
})();
