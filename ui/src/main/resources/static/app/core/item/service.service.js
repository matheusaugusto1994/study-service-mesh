(function() {
    'use strict';

    angular.module('hello').factory('servicesService', function($rootScope, $http, $location, $route) {

    	
    	function list() {
            return $http({
                method: 'GET',
                url: 'core/services/'
            });
    	}
    	
    	function get(id) {
            return $http({
                method: 'GET',
                url: 'core/services/'+id
            });
    	}  
    	
    	function save(service) {
    		
    		if(service.id){
    			
                return $http({
                    method: 'PUT',
                    url: 'core/services/'+service.id,
                    data: service
                });
                
    		} else {
    			
                return $http({
                    method: 'POST',
                    url: 'core/services/',
                    data: service
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