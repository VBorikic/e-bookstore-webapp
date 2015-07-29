angular.module('blogApp', ['services', 'controllers', 'ngRoute', 'ngResource','ui.bootstrap'])
	.config(
		['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

			$routeProvider
			.when('/', {
				templateUrl: 'app/partials/pocetna.html',
				controller: 'knjigaController'
			})
			.when('/prijava', {
				templateUrl: 'app/partials/prijava.html',
				controller: 'prijavljivanjeController'
			})
			.when('/knjige', {
				templateUrl: 'app/partials/knjige.html',
				controller: 'knjigaController'
			})
			.when('/admin/knjige', {
				templateUrl: 'app/partials/knjige_admin.html',
				controller: 'knjigaController'
			})
			.when('/knjige/:isbn/view', { 
				templateUrl: 'app/partials/knjigadetalji.html',
				controller: 'knjigaDetaljiController'
			})
			.when('/knjige/nova', { 
				templateUrl: 'app/partials/knjigaunos.html',
				controller: 'knjigaNovaController'
			})
			.otherwise({redirectTo:'/'});
			
//			$locationProvider.hashPrefix('!');
		}]
		 
	);
