(function() {
	'use strict';

	angular.module('hello').config(function($routeProvider) {
		
		$routeProvider.when('/products/', {
			templateUrl : 'app/core/item/item.list.html',
			controller : 'productListController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/products/new', {
			templateUrl : 'app/core/item/item.form.html',
			controller : 'productFormController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/products/:id/edit', {
			templateUrl : 'app/core/item/item.form.html',
			controller : 'productFormController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/services/', {
			templateUrl : 'app/core/item/item.list.html',
			controller : 'serviceListController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/services/new', {
			templateUrl : 'app/core/item/item.form.html',
			controller : 'serviceFormController',
			controllerAs : 'controller'
		});
		
		$routeProvider.when('/services/:id/edit', {
			templateUrl : 'app/core/item/item.form.html',
			controller : 'serviceFormController',
			controllerAs : 'controller'
		});
		
	});
})();
