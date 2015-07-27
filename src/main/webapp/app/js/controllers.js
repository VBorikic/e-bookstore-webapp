var controllers = angular.module('controllers', []);


controllers.controller('knjigaController', function($scope, $location,
		knjigaService) {
	$scope.knjige = knjigaService.query();
	
	console.log('knjige ');
	console.log($scope.knjige);

});

controllers.controller('knjigaDetaljiController', function($scope, $location, $routeParams,
		knjigaService) {
	$scope.isbn = $routeParams.isbn;
	console.log('trazim knjigu');
	$scope.knjiga = knjigaService.get({isbn:$scope.isbn}, function (){
		console.log('vracena knjiga');
	});
	// debug
//	console.log($scope.knjiga);
});

controllers.controller('knjigaNovaController', function($scope, $location,
		knjigaService) {
	  $scope.knjiga = new knjigaService();  //create new movie instance. Properties will be set via ng-model on UI
	  
	  $scope.dodajKnjigu = function() { //create a new movie. Issues a POST to /api/movies
	    $scope.knjiga.$save(function() {
	      // on success
	    	alert('Knjiga je sacuvana!');
	    });
	  };

});