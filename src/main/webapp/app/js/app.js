angular.module('blogApp', ['services', 'controllers', 'ngRoute', 'ngResource'])
	.config(
		['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

			$routeProvider
			.when('/', {
				templateUrl: 'app/partials/pocetna.html',
				controller: 'knjigaController'
			})
			.when('/knjige', {
				templateUrl: 'app/partials/knjige.html',
				controller: 'knjigaController'
			})
			.when('/knjige/:isbn/view', { 
				templateUrl: 'app/partials/knjigadetalji.html',
				controller: 'knjigaDetaljiController'
			})
			.otherwise({redirectTo:'/'});
			
//			$locationProvider.hashPrefix('!');
		}]
		 
	);
