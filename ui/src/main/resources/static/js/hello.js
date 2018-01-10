(function() {
    'use strict';
	angular.module('hello', [ 'ngRoute' ]).config(function($routeProvider, $httpProvider) {
	
		$routeProvider.when('/', {
			templateUrl : 'home.html',
			controller : 'home',
			controllerAs : 'controller'
		}).otherwise('/');
	
		$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
		$httpProvider.defaults.headers.common['Accept'] = 'application/json';
	
	}).controller('home', function($http) {
		var self = this;
	});
})();
