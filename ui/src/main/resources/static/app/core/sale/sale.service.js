(function() {
    'use strict';

    angular.module('hello').factory('salesService', function($rootScope, $http, $location, $route) {

    	
    	function list() {
            return $http({
                method: 'GET',
                url: 'core/sales/'
            });
    	}
    	
    	function get(id) {
            return $http({
                method: 'GET',
                url: 'core/sales/'+id
            });
    	}  
    	
    	function save(sale) {
    		
    		if(sale.id){
    			
                return $http({
                    method: 'PUT',
                    url: 'core/sales/'+sale.id,
                    data: sale
                });
                
    		} else {
    			
                return $http({
                    method: 'POST',
                    url: 'core/sales/',
                    data: sale
                });	
                
    		}
            
        }
    	
    	function remove(sale){
    		return $http({
                method: 'DELETE',
                url: sale._links.self.href
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