(function() {
    'use strict';

    angular.module('hello').controller('saleListController', function($rootScope, $http, $location, $routeParams, salesService) {

    	var self = this;
    	
    	self.init = function(){
    		
    		salesService.list().then(function(response){
    			self.response = response;
    		});
    		
    	}
    	
    	self.init();
    	
    });

})();