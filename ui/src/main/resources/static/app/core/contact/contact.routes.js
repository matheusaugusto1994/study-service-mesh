(function() {
	'use strict';

	angular.module('hello').config(function($routeProvider) {
		
		$routeProvider.when('/contacts/new', {
			templateUrl : 'app/core/contact/contact.form.html',
			controller : 'contactFormController',
			controllerAs : 'contactFormController'
		});
		
		$routeProvider.when('/contacts/:id/edit', {
			templateUrl : 'app/core/contact/contact.form.html',
			controller : 'contactFormController',
			controllerAs : 'contactFormController'
		});
		
		$routeProvider.when('/contacts/', {
			templateUrl : 'app/core/contact/contact.list.html',
			controller : 'contactListController',
			controllerAs : 'contactListController'
		});
		
		
	});
})();
