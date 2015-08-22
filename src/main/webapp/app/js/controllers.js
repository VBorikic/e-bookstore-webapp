var controllers = angular.module('controllers', []);

controllers.controller('prijavljivanjeController', function($scope, $location, $http,
		korisnikService,sesijaService) {
	
	//ovde mora da se proveri da li postoji user
	$scope.login = function(){
		//alert("radi registracija dugme"+ $scope.korisnik.password);
		sesijaService.login($scope.korisnik);
		alert("uspes"+$scope.korisnik.password);
		$location.path("pocetna");
	};
});
controllers.controller('registracijaController', function($scope, $location, $http,
		korisnikService) {
	//ovde mora da se rpvoeri da li postoji user pa ako da ne sme
	$scope.korisnik = new korisnikService(); 
	$scope.registracija = function(){
		alert("radi registracija dugme"+ $scope.korisnik.userName);
		
		    $scope.korisnik.$save(function() {
		      // on success
		    	alert('Korisnik je sacuvan!');
		    	$location.path('prijava');
		    });
		  
	};
});
controllers.controller("LogovanjeController",function($scope,sesijaService){
	$scope.isLogedIn = sesijaService.isLogedIn;
	$scope.logout = sesijaService.logout;
	
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

controllers.controller('knjigaIzmenaController', function($scope, $location, $routeParams,
		knjigaService, izdavaciService, autoriService) {
	$scope.isbn = $routeParams.isbn;
	console.log('trazim knjigu');
	$scope.knjiga = knjigaService.get({isbn:$scope.isbn}, function (){
		console.log('vracena knjiga');
		});
	
	  // posalji zahtev za liste autora i izdavaca
	  $scope.autori = autoriService.query();
	  $scope.izdavaci = izdavaciService.query();
	  
	  //cuvanje izmena
	 $scope.izmeniKnjigu = function(){
		 $scope.knjiga.$update(function() {
		      //on success
			 alert('Knjiga je izmenjena!');
		    	$location.path('admin/knjige');
		    }); 
		 
	 };
});

controllers.controller('CarouselSlideController', function ($scope,knjigaService) {
	  $scope.myInterval = 2000;
	  $scope.noWrapSlides = false;
	
	  
	  $scope.knjige = knjigaService.query();
	});