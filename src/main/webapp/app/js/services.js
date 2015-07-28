var services = angular.module('services', []);

services.factory('knjigaService',
		function($resource) {
			return $resource('service/knjige/:isbn', {
				isbn : '@isbn'
			}, {
				update : {
					method : 'PUT' // this method issues a PUT request
				}
			});
		});

services.factory('izdavaciService', function($resource){
	return $resource('service/izdavaci'	);
});
services.factory('autoriService', function($resource){
	return $resource('service/autori'	);
});
// servisi.factory('knjigaService', function($resource) {
// return $resource('service/knjige/:knjigaId', { knjigaId: 'isbn' }, {
// update: {
// method: 'PUT' // this method issues a PUT request
// }
// });
// });
