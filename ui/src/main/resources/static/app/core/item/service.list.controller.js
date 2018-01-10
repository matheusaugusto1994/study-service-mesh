(function() {
    'use strict';

    angular.module('hello').controller('serviceListController', function($rootScope, utils, $http, $location, $route, $routeParams, servicesService) {

    	var self = this;
    	
    	self.type = "services";
    	
    	self.getEditUrl = function(service){
    		var id = utils.getId(service._links.self.href);
    		return "/#/services/"+id+"/edit";
    	}
    	
    	self.remove = function(service){
    		servicesService.remove(service).then(function(){
    			self.init();
    		});
    	}
    	
    	self.getItems = function(){
    		if(self.page)
    			return self.page._embedded.services;
    		return null;
    	}
    	
    	self.init = function (){
    		servicesService.list().success(function(response){
    			self.page = response;
    		});
    	}
    	
    	self.init();
    	
    });

})();