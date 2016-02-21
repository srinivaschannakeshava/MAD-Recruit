/**
 * 
 */
var madRecruitApp = angular.module("madRecruitApp", [ 'ngRoute' ,'checklist-model']);

madRecruitApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/candidatelist', {
		templateUrl : 'home',
	// controller:'candidateCtrl'
	}).when('/interviewlist', {
		templateUrl : 'interview',
	// controller:'interviewCtrl'
	}).when('/selectlist', {
		templateUrl : 'selected',
		// controller:'interviewCtrl'
		})
} ]);

madRecruitApp.run([ '$rootScope', '$http', '$timeout',
		function($rootScope, $http, $timeout) {
			var url = '/com.mad.recruit/rest/getcandidatelist';
			$http.get(url).success(function(response) {
				// alert(response)
				if (response) {
					$rootScope.candidateList = response;
				}
			});
		} ]);

madRecruitApp.directive('showtab', function() {
	return {
		link : function(scope, element, attrs) {
			element.click(function(e) {
				e.preventDefault();
				$(element).tab('show');
			});
		}
	};
});