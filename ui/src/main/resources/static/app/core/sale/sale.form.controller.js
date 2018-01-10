(function() {
    'use strict';

    angular.module('hello').controller('saleFormController', function($rootScope, $http, $location, $routeParams, salesService) {

    	var self = this;
    	
    	self.id = $routeParams.id;
    	
    	self.sale = {};
    	self.sale.items = [];
    	
    	self.selectItemEdit = {};
    	self.quantity = 0;
    	self.itemType='PRODUCT';
    	
    	self.itemUrl="";
    	
    	self.init = function(){
    		
    	}
    	
    	self.init();
    	
    	
    	
    	self.save = function(){
    		salesService.save(self.sale).success(function(response){
    			$location.path('/sales/')
    		});
    	}
    	
    	self.addItem = function(){
    		
    		$http({
                method: 'GET',
                url: self.itemUrl
            }).success(function(response){
            	
            	self.selectItemEdit = response;
            	self.selectItemEdit.quantity = self.quantity;
        		self.selectItemEdit.itemType = self.itemType;
        		self.sale.items.push(self.selectItemEdit);
        		
        		self.quantity='';
        		self.selectItemEdit = {};
        		
            });
    		
    	}
    });

})();