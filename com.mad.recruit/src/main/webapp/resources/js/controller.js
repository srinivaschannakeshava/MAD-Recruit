/**
 * 
 */
madRecruitApp.controller("candidateCtrl", [ '$scope', '$rootScope', '$http',
		'$timeout', function($scope, $rootScope, $http, $timeout) {
			$rootScope.selected = "candidateList";
			// $rootScope.candidateList;
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
				var url="/com.mad.recruit/rest/addtoken";
				var data=candidate;
				$http.put(url, data).then(function(response) {
					// success callback
//					alert(response.data.isError)
					if(response.data.isError=='true'){
						alert('!! Token No already exists')
						candidate.tokenNo=0;
					}else{
						alert('Token No alloted')
					}
				}, function(response) {
					// failure callback
					alert('failure '+response)
				});
			}

		} ]);

madRecruitApp.controller("interviewCtrl", [ '$scope', '$rootScope', '$http',
		'$timeout', function($scope, $rootScope, $http, $timeout) {
			// alert('hello')
			$rootScope.selected = "interviewList";

		} ]);