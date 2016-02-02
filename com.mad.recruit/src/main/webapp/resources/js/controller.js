/**
 * 
 */
madRecruitApp.controller("candidateCtrl", [ '$scope','$rootScope', '$http','$timeout',
		function($scope,$rootScope, $http,$timeout) {
	$rootScope.candidateList;
			var url = '/com.mad.recruit/rest/getcandidatelist'
				$scope.$watch("candidateList", function(newValue, oldValue){
				    // do something
					if($rootScope.candidateList.length!=0){
						$timeout(function() {
							$('#candidateList').DataTable();
					    },0);
					}
				});	
				
			$http.get(url).success(function(response) {
				//alert(response)
				if(response){
					$rootScope.candidateList=response;
				}
			});
			$scope.addToken=function(candidate){
				console.log(candidate)
			}
			
			
		} ]);

madRecruitApp.controller("interviewCtrl", [ '$scope', '$http',
		function($scope, $http) {

		} ]);