/**
 * 
 */
madRecruitApp.controller("candidateCtrl", [ '$scope', '$rootScope', '$http',
		'$timeout', function($scope, $rootScope, $http, $timeout) {
			$rootScope.selected = "candidateList";
		//	$rootScope.candidateList;
			$scope.$watch("candidateList", function(newValue, oldValue) {
				// do something
				if ($rootScope.candidateList.length != 0) {
					$timeout(function() {
						$('#candidateList').DataTable();
					}, 0);
				}
			});

			
			$scope.addToken = function(candidate) {
				console.log(candidate)
			}

		} ]);

madRecruitApp.controller("interviewCtrl", [ '$scope', '$rootScope', '$http',
		'$timeout', function($scope, $rootScope, $http, $timeout) {
			// alert('hello')
			$rootScope.selected = "interviewList";
		} ]);