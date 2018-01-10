(function() {
    'use strict';

    angular.module('hello').factory('productsService', function($rootScope, $http, $location, $route) {

    	
    	function list() {
            return $http({
                method: 'GET',
                url: 'core/products/'
            });
    	}
    	
    	function get(id) {
            return $http({
                method: 'GET',
                url: 'core/products/'+id
            });
    	}  
    	
    	function save(product) {
    		
    		if(product.id){
    			
                return $http({
                    method: 'PUT',
                    url: 'core/products/'+product.id,
                    data: product
                });
                
    		} else {
    			
                return $http({
                    method: 'POST',
                    url: 'core/products/',
                    data: product
                });	
                
    		}
            
        }
    	
    	function remove(contact){
    		return $http({
                method: 'DELETE',
                url: contact._links.self.href
            });
    	}

        return {
        	list: list,
        	save: save,
        	get: get,
        	remove: remove
        };
    });

})();