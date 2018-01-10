(function() {
    'use strict';

    angular.module('hello').factory('utils', function() {

    	
    	function getId(url) {
    		var id = url.substring(url.lastIndexOf('/') + 1);
    		return id;
    	}
    	

        return {
        	getId: getId
        };
        
    });

})();