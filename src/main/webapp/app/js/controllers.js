var controllers = angular.module('controllers', []);


controllers.controller('knjigaController', function($scope, $location, $http,
		knjigaService) {
	$scope.knjige = knjigaService.query();
	
	console.log('knjige');
	console.log($scope.knjige);
	
// $scope.obrisiKnjigu = function(knjiga) { // Delete a movie. Issues a DELETE
// to /api/movies/:id
// knjiga.$delete(function() {
// // on success
// alert('Knjiga je obrisana!');
// }
// };
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
	  $scope.knjiga = new knjigaService();  // create new movie instance.
											// Properties will be set via
											// ng-model on UI
	  // posalji zahtev za liste autora i izdavaca
	  $scope.autori = autoriService.query();
	  $scope.izdavaci = izdavaciService.query();
	  
  
	  $scope.dodajKnjigu = function() { // create a new movie. Issues a POST to
										// /api/movies
	    $scope.knjiga.$save(function() {
	      // on success
	    	alert('Knjiga je sacuvana!');
	    	$location.path('admin/knjige');
	    });
	  };

});