/**
 * 
 */
madRecruitApp.controller("candidateCtrl", [
		'$scope',
		'$rootScope',
		'$http',
		'$timeout',
		function($scope, $rootScope, $http, $timeout) {
			$rootScope.selected = "candidateList";
			// $rootScope.candidateList;
			$scope.$watch("candidateList", function(newValue, oldValue) {
				// do something
				if ($rootScope.candidateList != undefined
						&& $rootScope.candidateList.length != 0) {
					$timeout(function() {
						$('#candidateList').DataTable();
					}, 0);
				}
			});

			$scope.addToken = function(candidate) {
				console.log(candidate)
				var url = "/com.mad.recruit/rest/addtoken";
				var data = candidate;
				$http.put(url, data).then(function(response) {
					// success callback
					// alert(response.data.isError)
					if (response.data.isError == 'true') {
						alert('!! Token No already exists')
						candidate.tokenNo = 0;
					} else {
						alert('Token No alloted')
					}
				}, function(response) {
					// failure callback
					alert('failure ' + response)
				});
			}

		} ]);

madRecruitApp.controller("interviewCtrl", [
		'$scope',
		'$rootScope',
		'$http',
		'$timeout',
		function($scope, $rootScope, $http, $timeout) {
			// alert('hello')
			$rootScope.selected = "interviewList";
			var url = '/com.mad.recruit/rest/getinterviewlist';
			$http.get(url).success(
					function(response) {
						// alert(response)
						if (response) {
							for ( var i in response) {
								response[i].availabilityPref = JSON
										.parse(response[i].availabilityPref);
								response[i].gradePref = JSON
										.parse(response[i].gradePref);
								response[i].subjectTaught = JSON
										.parse(response[i].subjectTaught);
								response[i].subjectPref = JSON
										.parse(response[i].subjectPref);
							}
							$scope.interviewList = response;
						}
					});
			$scope.$watch("interviewList", function(newValue, oldValue) {
				// do something
				if ($scope.interviewList != undefined
						&& $scope.interviewList.length != 0) {
					$timeout(function() {
						$('#interviewList').DataTable();
					}, 0);
				}
			});
			$scope.openInterview = function(candidate) {
				console.log(candidate)
				$scope.interviewCandidate = candidate;
				// $scope.interviewCandidate.pref=[];
				// $('#interviewModal').modal('show');
				$('#interviewModal').modal({
					backdrop : 'static',
					keyboard : false
				})
				// $scope.interviewCandidate.subpref=[];
			}
			$scope.avails = [ 'Weekdays', 'Weekends', 'Only Saturday',
					'Only Sunday' ]
			$scope.gradeprefs = [ 'Lower (5-7)', 'Higher (8-10)',
					'Propel (11-12)' ]
			$scope.subprefs = [ 'English', 'Math', 'Science', 'Accountancy',
					'Business studies' ];
			$scope.ratings = [ 1, 2, 3, 4, 5 ];

			$scope.saveInterviewDetails = function(interviewDetails) {
				var tempInterviewDetail = JSON.parse(JSON
						.stringify(interviewDetails));
				if (tempInterviewDetail.availabilityPref != null) {
					tempInterviewDetail.availabilityPref = JSON
							.stringify(tempInterviewDetail.availabilityPref)
				}
				if (tempInterviewDetail.gradePref != null) {
					tempInterviewDetail.gradePref = JSON
							.stringify(tempInterviewDetail.gradePref)
				}
				if (tempInterviewDetail.subjectTaught != null) {
					tempInterviewDetail.subjectTaught = JSON
							.stringify(tempInterviewDetail.subjectTaught)
				}
				if (tempInterviewDetail.subjectPref != null) {
					tempInterviewDetail.subjectPref = JSON
							.stringify(tempInterviewDetail.subjectPref)
				}
				console.log(interviewDetails)
				var url = "/com.mad.recruit/rest/updateinterviewdetails";
				$http.put(url, tempInterviewDetail).then(function(response) {
					// success callback
					// alert(response.data.isError)
					if (response.data.isError == 'false') {
						alert('Saved')
					} else {
						alert('Error in saving')
					}
				}, function(response) {
					// failure callback
					alert('failure ' + response)
				});
			}

		} ]);

madRecruitApp.controller("selectedCtrl", [ '$scope', '$rootScope', '$http',
		'$timeout', function($scope, $rootScope, $http, $timeout) {
			$rootScope.selected = "selectedList";
			var url = '/com.mad.recruit/rest/getselectedlist';
			$http.get(url).success(
					function(response) {
						// alert(response)
						if (response) {
							for ( var i in response) {
								response[i].availabilityPref = JSON
										.parse(response[i].availabilityPref);
								response[i].gradePref = JSON
										.parse(response[i].gradePref);
								response[i].subjectTaught = JSON
										.parse(response[i].subjectTaught);
								response[i].subjectPref = JSON
										.parse(response[i].subjectPref);
							}
							$scope.selectedList = response;
						}
					});
			$scope.$watch("selectedList", function(newValue, oldValue) {
				// do something
				if ($scope.selectedList != undefined
						&& $scope.selectedList.length != 0) {
					$timeout(function() {
						$('#selectedList').DataTable();
					}, 0);
				}
			});
		} ]);
