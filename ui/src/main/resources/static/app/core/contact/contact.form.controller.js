(function() {
    'use strict';

    angular.module('hello').controller('contactFormController', function($rootScope, $http, $location, $routeParams, contactsService) {

    	var self = this;
    	
    	self.id = $routeParams.id;
    	
    	
    	self.init = function(){
    		
    		if(self.id){
    			contactsService.get(self.id).success(function(response){
    				self.contact = response;
    				self.contact.id = self.id;
    			});
    		} else {
    			self.contact = {};
    		}
    		
    	}
    	
    	self.init();
    	
    	
    	
    	self.save = function(){
    		contactsService.save(self.contact).success(function(response){
    			$location.path('/contacts/')
    		});
    	}
    });

})();