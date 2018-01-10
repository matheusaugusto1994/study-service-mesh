(function() {
    'use strict';

    angular.module('hello').controller('productListController', function($rootScope, utils, $http, $location, $route, $routeParams, productsService) {

    	var self = this;
    	self.type = 'products';
    	
    	self.getEditUrl = function(product){
    		var id = utils.getId(product._links.self.href);
    		return "/#/products/"+id+"/edit";
    	}
    	
    	self.remove = function(product){
    		productsService.remove(product).then(function(){
    			self.init();
    		});
    	}
    	
    	self.getItems = function(){
    		if(self.page)
    			return self.page._embedded.products;
    		return null;
    	}
    	
    	self.init = function (){
    		productsService.list().success(function(response){
    			self.page = response;
    		});
    	}
    	
    	self.init();
    	
    });

})();