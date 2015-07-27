var servisi = 
	angular.module('services', []).factory('knjigaService',
		function($resource) {
			return $resource('service/knjige/:isbn', {
				isbn : '@isbn'
			}, {
				update : {
					method : 'PUT' // this method issues a PUT request
				}
			});
		});


// servisi.factory('knjigaService', function($resource) {
// return $resource('service/knjige/:knjigaId', { knjigaId: 'isbn' }, {
// update: {
// method: 'PUT' // this method issues a PUT request
// }
// });
// });
