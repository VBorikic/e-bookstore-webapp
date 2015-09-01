var services = angular.module('services', []);

services.factory('knjigaService',
		function($resource) {
			return $resource('service/knjige/:isbn', {isbn : '@isbn'}, 
			{
				update : {method : 'PUT'}
//				delete:{method:'DELETE', params{isbn:'@isbn'}}
			});
		});
//services.factory('jednaKnjigaService',
//		function($resource) {
//			return $resource('service/knjige/:isbn', {}, 
//			{
//				update : {method : 'PUT'},
//				delete:  {method:'DELETE', params{isbn:'@isbn'}}
//			});
//		});

services.factory('izdavaciService', function($resource){
	return $resource('service/izdavaci'	);
});
services.factory('autoriService', function($resource){
	return $resource('service/autori'	);
});
services.factory('korisnikService', function($resource){
	return $resource('service/korisnici/:korisnikId',{korisnikId: '@korisnikId'});
	
});
//services.factory('pretragaService', function($resource){
//	var pretraga={};
//	pretraga.pretrazi = function(data){
//		 return $resource('service/https://www.googleapis.com/books/v1/volumes?q=inauthor:'+data.ime+'+'+data.prezime+'&key=AIzaSyBBIVptarwDSWM4BrZQaYZNI_ors8QMtLs');
//	};
	
//});
services.factory('sesijaService', function($http){
	var session={};
	session.login = function(data){
//		 localStorage.setItem("session",data);
		alert("pozvana login f-ja");
        return $http.post("/bookstore/login", "username=" + data.userName +
                "&password=" + data.password, {
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                } ).then(function(data) {
                    alert("login successful");
                    localStorage.setItem("session", {});
                }, function(data) {
                    alert("error logging in");
                });
	};
	
	session.logout=function(){
		localStorage.removeItem("session");
		
	};
	
	session.isLogedIn = function(){
		
		return localStorage.getItem("session")!==null;
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
