var servisi = angular.module('services', []);

// services.factory('blogService', function($resource) {
//	
// return $resource('service/blog/:blogId', {blogId: '@blogId'});
// // return $resource('service/knjige/:blogId', {blogId: '@blogId'});
// });

servisi.factory('knjigaService', function($resource) {

	return $resource('service/knjige/:knjigaId', {
		knjigaId : '@ISBN'
	}, {
		update : {
			method : 'PUT'
		}
	});

});
