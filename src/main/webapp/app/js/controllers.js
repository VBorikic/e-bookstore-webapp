var controllers = angular.module('controllers', []);

controllers.controller('prijavljivanjeController', function($scope, $location, $http,
		knjigaService) {
	
});

controllers.controller('knjigaController', function($scope, $location, $http,
		knjigaService) {
	$scope.knjige = knjigaService.query();	
	console.log('knjige');
	console.log($scope.knjige);
	$scope.obrisiKnjigu = function(knjiga){
		$http.delete('service/knjige/'+knjiga.isbn).
		 success(function() {
			 console.log('Knjiga je obrisana');
			    $scope.knjige = knjigaService.query(); 
			  }).
			  error(function() {
				  alert('Greska.');
			  });
	}
});

controllers.controller('knjigaDetaljiController', function($scope, $location, $routeParams,
			knjigaService) {
		$scope.isbn = $routeParams.isbn;
		console.log('trazim knjigu');
		$scope.knjiga = knjigaService.get({isbn:$scope.isbn}, function (){
			console.log('vracena knjiga');
			});
});

controllers.controller('knjigaNovaController', function($scope, $location,
		knjigaService, izdavaciService, autoriService) {
	  $scope.knjiga = new knjigaService(); 
	  // posalji zahtev za liste autora i izdavaca
	  $scope.autori = autoriService.query();
	  $scope.izdavaci = izdavaciService.query();
	  
	  $scope.dodajKnjigu = function() { 
	    $scope.knjiga.$save(function() {
	      // on success
	    	alert('Knjiga je sacuvana!');
	    	$location.path('admin/knjige');
	    });
	  };

});