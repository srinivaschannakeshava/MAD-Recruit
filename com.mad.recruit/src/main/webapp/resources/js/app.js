/**
 * 
 */
var madRecruitApp = angular.module("madRecruitApp", [ 'ngRoute',
		'checklist-model' ]);

madRecruitApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/candidatelist', {
		resolve : {
			loggedin : checkLoggedIn
		},
		templateUrl : 'home'
	// controller:'candidateCtrl'
	}).when('/interviewlist', {
		resolve : {
			loggedin : checkLoggedIn
		},
		templateUrl : 'interview'

	// controller:'interviewCtrl'
	}).when('/selectlist', {
		resolve : {
			loggedin : checkLoggedIn
		},
		templateUrl : 'selected'

	// controller:'interviewCtrl'
	}).when('/login', {
		resolve : {
			loggedin : checkLoggedIn
		},
		templateUrl : 'login'

	})
} ]);

madRecruitApp.run([
		'$rootScope',
		'$http',
		'$timeout',
		'$location',
		'loginService',
		function($rootScope, $http, $timeout, $location, loginService) {
			loginService.isLoggedIn(function(data) {
				$rootScope.addCandidate = function() {
					$('#addUserModal').modal({
						backdrop : 'static',
						keyboard : false
					})
					$rootScope.newCandidate = {};
				}
				if (data.loggedin == "true") {
					$rootScope.isLoggedIn = true;
					loginService.getLoggedInUser(function(adminUser) {
						$rootScope.centerprefs=adminUser.centers;
						$rootScope.collection = adminUser.collection;
						var url = '/com.mad.recruit/rest/'
								+ $rootScope.collection + '/getcandidatelist';
						$http.get(url).success(function(response) {
							// alert(response)
							if (response) {
								$rootScope.candidateList = response;
							}
						});
					})

				} else if (data.loggedin == "false") {
					$rootScope.isLoggedIn = false;
				}
			});

			$rootScope.logout = function() {
				loginService.logout(function(response) {
					if (response.logout == "success") {
						$location.path("/login");
						$rootScope.isLoggedIn = false;
						for ( var prop in $rootScope) {
							if (prop.substring(0, 1) !== '$') {
								delete $rootScope[prop];
							}
						}
					}
				});
			};
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

var checkLoggedIn = function($http, $location, $rootScope, loginService) {
	loginService.isLoggedIn(function(data) {
		if (data.loggedin == "true") {
			$rootScope.isLoggedIn = true;
			loginService.getLoggedInUser(function(adminUser) {
				console.log(adminUser);
				$rootScope.centerprefs=adminUser.centers;
				$rootScope.collection = adminUser.collection;
			})
		} else {
			$rootScope.isLoggedIn = false;
			$location.path("/login");
		}
	});
}
