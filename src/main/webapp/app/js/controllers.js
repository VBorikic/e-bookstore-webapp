var controllers = angular.module('controllers', []);

// controllers.controller('blogController', function($scope, $location,
// blogService) {
// $scope.blogEntries = blogService.query();
//
// $scope.deleteBlogEntry = function(blogEntry) {
// blogEntry.$remove({
// blogId : blogEntry.id
// }, function() {
// $scope.blogEntries = blogService.query();
// });
// };
//
// $scope.blogEntry = new blogService();
//
// $scope.saveBlog = function() {
// $scope.blogEntry.$save(function() {
// $location.path('/');
// });
// };
// });

controllers.controller('knjigaController', function($scope, $location,
		knjigaService) {
	$scope.knjige = knjigaService.query();
//	$scope.knjiga = 1;
//	$scope.knjiga = new knjigaService();

	// debug
	console.log($scope.knjige);
});