angular.module('blogApp', ['services', 'controllers', 'ngRoute', 'ngResource'])
	.config(
		['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
			
//			$routeProvider
//				.when('/blog/create', {
//				templateUrl: 'app/partials/blog-create.html',
//				controller: 'knjigaController'
//			})
			$routeProvider.when('/knjige', {
				templateUrl: 'app/partials/knjige.html',
				controller: 'knjigaController'
			});
					
			$routeProvider.otherwise({
				templateUrl: 'app/partials/knjige.html',
				controller: 'knjigaController'
			});
			
//			$locationProvider.hashPrefix('!');
		}]
		 
	);
