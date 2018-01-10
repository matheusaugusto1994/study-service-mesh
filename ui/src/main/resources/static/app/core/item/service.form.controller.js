(function() {
    'use strict';

    angular.module('hello').controller('serviceFormController', function($rootScope, utils, $http, $location, $route, $routeParams, servicesService) {

    	var self = this;
    	
    	self.type = "services";
    	
    	self.id = $routeParams.id;
    	
    	self.save = function(){
    		servicesService.save(self.item).success(function(response){
    			$location.path('/services/')
    		});
    	}
    	
    	self.init = function (){
    		
    		if(self.id){
    			servicesService.get(self.id).success(function(response){
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