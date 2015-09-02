var services = angular.module('services', []);

services.factory('knjigaService', function($resource) {
	return $resource('service/knjige/:isbn', {
		isbn : '@isbn'
	}, {
		update : {
			method : 'PUT'
		}
	// delete:{method:'DELETE', params{isbn:'@isbn'}}
	});
});
// services.factory('jednaKnjigaService',
// function($resource) {
// return $resource('service/knjige/:isbn', {},
// {
// update : {method : 'PUT'},
// delete: {method:'DELETE', params{isbn:'@isbn'}}
// });
// });

services.factory('izdavaciService', function($resource) {
	return $resource('service/izdavaci');
});
services.factory('autoriService', function($resource) {
	return $resource('service/autori');
});
services.factory('korisnikService', function($resource) {
	return $resource('service/korisnici/:username', {
		username : '@username'
	});

});

services.factory('korpaService', function($http) {
	var korpa = [];
	var funkcijaDodaj = function(data) {
		console.log("pozvano push u servisu");
		korpa.push(data);
		console.log(korpa);
	};

	var funkcijaVratiArtikle = function() {
		return korpa;
	};
	
	var funkcijaKupi = function() {
		return $http.post("/bookstore/service/narudzbenica",
				korpa).then(function(data) {
			alert("Narucivanje uspesno!");
		}, function(data) {
			alert("Greska pri narucivanju");
		});
	};
	
	var funkcijaIzbrisiArtikal = function(index) {
		korpa.splice(index, 1);
	};
	
	var funkcijaIsprazniKorpu = function() {
		korpa = [];
	};
	
	return {
		dodajUKorpu : funkcijaDodaj,
		prikaziArtikle : funkcijaVratiArtikle,
		ukloniArtikal : funkcijaIzbrisiArtikal,
		kupiKnjige : funkcijaKupi,
		isprazniKorpu : funkcijaIsprazniKorpu
	};
});

// services.factory('registracijaService', function($http,$scope){
// var dataObj = {
// ime : $scope.korisnik.ime,
// prezime : $scope.korisnik.prezime,
// username : $scope.korisnik.username,
// password : $scope.korisnik.password
// };
// return $http.post("/service/register", ).then(function(data) {
// alert("login successful");
// localStorage.setItem("session", {});
// }, function(data) {
//                
//	
// });
 services.factory('pretragaService', function($resource){
 var pretraga={};
 pretraga.pretrazi = function(data){
 return
 $resource('service/https://www.googleapis.com/books/v1/volumes?q=inauthor:'+data.ime+'+'+data.prezime+'&key=AIzaSyBBIVptarwDSWM4BrZQaYZNI_ors8QMtLs');
 };

 });
services.factory('sesijaService', function($http, $resource) {
	var session = {};

	session.login = function(data) {
		// localStorage.setItem("session",data);
		alert("pozvana login f-ja");
		return $http.post("/bookstore/login",
				"username=" + data.userName + "&password=" + data.password, {
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).then(function(data) {
			alert("login successful");
			localStorage.setItem("session", {});
		}, function(data) {
			alert("error logging in");
		});
	};
	//	
	// session.vratiKorisnika = function(data){
	// return $resource('korisnici/');
	// };

	session.logout = function() {
		// alert("pozvana login f-ja");
		localStorage.removeItem("session");
		return $http.post("/bookstore/logout").then(function(data) {
			alert("logout successful");
			// localStorage.removeItem("session");
		}, function(data) {
			alert("error logging out");
		});
		localStorage.removeItem("session");

	};

	session.isLogedIn = function() {

		return localStorage.getItem("session") !== null;
	}
	return session;
});
// servisi.factory('knjigaService', function($resource) {
// return $resource('service/knjige/:knjigaId', { knjigaId: 'isbn' }, {
// update: {
// method: 'PUT' // this method issues a PUT request
// }
// });
// });
