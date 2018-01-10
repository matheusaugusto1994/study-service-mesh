(function() {
    'use strict';

    angular.module('hello').controller('productFormController', function($rootScope, utils, $http, $location, $route, $routeParams, productsService) {

    	var self = this;
    	
    	self.type = "products";
    	
    	self.id = $routeParams.id;
    	
    	self.save = function(){
    		productsService.save(self.item).success(function(response){
    			$location.path('/products/')
    		});
    	}
    	
    	self.init = function (){
    		
    		if(self.id){
    			productsService.get(self.id).success(function(response){
    				self.item = response;
    				self.item.id = self.id;
    			});
    		} else {
    			self.item = {};
    		}
    		
    	}
    	
    	self.init();
    	
    });

})();