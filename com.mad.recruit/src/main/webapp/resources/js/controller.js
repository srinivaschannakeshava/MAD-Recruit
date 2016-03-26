/**
 * 
 */
madRecruitApp.controller("loginCtrl", [
		'$scope',
		'$rootScope',
		'$timeout',
		'$location',
		'httpService',
		'loginService',
		function($scope, $rootScope, $timeout,$location, httpService,loginService) {
			$scope.username = "";
			$scope.password = "";
			
//			var data = "username=admin&password=admin";
			$scope.login = function() {
				var data = "username=" + $scope.username + "&password="	+ $scope.password;
				loginService.login(data,function(response) {
							if(response.login == "success"){
								$location.path("/candidatelist");
								$rootScope.isLoggedIn = true;
							} else if(response.login == "failure"){
								$location.path("/login");
							}
						});

			}
			$rootScope.selected = "login";
		} ]);
madRecruitApp.controller("candidateCtrl", [
		'$scope',
		'$rootScope',
		'$timeout',
		'httpService',
		function($scope, $rootScope, $timeout, httpService) {
			var url = '/com.mad.recruit/rest/getcandidatelist';
			httpService.getRequest(url,function(response) {
				$rootScope.candidateList = response;
			});
			
			
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
				// var url = "/madrecruit/rest/addtoken";
				var data = candidate;
				httpService.putRequest(url, data, "application/json", function(
						response) {
					if (response.isError == 'true') {
						alert('!! Token No already exists')
						candidate.tokenNo = 0;
					} else {
						alert('Token No alloted')
					}
				});
				/*
				 * $http.put(url, data).then(function(response) { // success
				 * callback // alert(response.data.isError) if
				 * (response.data.isError == 'true') { alert('!! Token No
				 * already exists') candidate.tokenNo = 0; } else { alert('Token
				 * No alloted') } }, function(response) { // failure callback
				 * alert('failure ' + response) });
				 */
			}
			$scope.saveNewCandidate = function(newCandidate) {
				console.log(newCandidate)
				var url = "/com.mad.recruit/rest/addnewcandidate";
				// var url = "/madrecruit/rest/addtoken";
				var data = newCandidate;
				httpService.putRequest(url, data, "application/json", function(
						response) {
					// success callback
					// alert(response.data.isError)
					if (response.isError == 'true') {
						alert('!! Failed to add Candidate ')
						candidate.tokenNo = 0;
					} else {
						alert('Candidate saved')
					}
				});
			}

		} ]);

madRecruitApp
		.controller(
				"interviewCtrl",
				[
						'$scope',
						'$rootScope',
						'$timeout',
						'httpService',
						function($scope, $rootScope, $timeout, httpService) {
							// alert('hello')
							$rootScope.selected = "interviewList";
							var url = '/com.mad.recruit/rest/getinterviewlist';
							// var url = "/madrecruit/rest/getinterviewlist";
							httpService
									.getRequest(
											url,
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
							$scope.$watch("interviewList", function(newValue,
									oldValue) {
								// do something
								if ($scope.interviewList != undefined
										&& $scope.interviewList.length != 0) {
									$timeout(function() {
										$('#interviewList').DataTable();
									}, 0);
								}
							});

							$scope.openGroupActivy = function(candidate) {
								$('#groupActivityModal').modal({
									backdrop : 'static',
									keyboard : false
								})
								$scope.candidateGA = candidate;
								$scope.canGA;
								if ($scope.candidateGA.groupActivity != null) {
									$scope.canGA = JSON
											.parse($scope.candidateGA.groupActivity);
								} else {
									$scope.canGA = null;
								}

								$scope.saveCandidateGA = function(canGA) {
									$scope.candidateGA.groupActivity = JSON
											.stringify($scope.canGA);
									var tempInterviewDetail = JSON.parse(JSON
											.stringify($scope.candidateGA));
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
									// console.log($scope.candidateGA)
									var url = "/com.mad.recruit/rest/updateinterviewdetails";

									httpService
											.putRequest(
													url,
													tempInterviewDetail,
													"application/json",
													function(response) {
														// success callback
														// alert(response.data.isError)
														if (response.isError == 'false') {
															alert('Saved')
														} else {
															alert('Error in saving')
														}
													});
								}

							}

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
							$scope.avails = [ 'Weekdays', 'Weekends',
									'Only Saturday', 'Only Sunday' ]
							$scope.gradeprefs = [ 'Lower (5-7)',
									'Higher (8-10)', 'Propel (11-12)' ]
							$scope.subprefs = [ 'English', 'Math', 'Science',
									'Accountancy', 'Business studies' ];
							$scope.ratings = [ 1, 2, 3, 4, 5 ];

							$scope.saveInterviewDetails = function(
									interviewDetails) {
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
								// var url =
								// "/madrecruit/rest/updateinterviewdetails";
								httpService.putRequest(url,
										tempInterviewDetail,
										"application/json", function(response) {
											// success callback
											// alert(response.data.isError)
											if (response.isError == 'false') {
												alert('Saved')
											} else {
												alert('Error in saving')
											}
										});
							}

						} ]);

madRecruitApp.controller("selectedCtrl", [
		'$scope',
		'$rootScope',
		'$timeout',
		'httpService',
		function($scope, $rootScope, $timeout, httpService) {
			$rootScope.selected = "selectedList";
			var url = '/com.mad.recruit/rest/getselectedlist';
			// var url = '/madrecruit/rest/getselectedlist';
			httpService.getRequest(url, function(response) {
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
			$scope.viewResult = function(candidate) {
				$('#viewResultModal').modal({
					backdrop : 'static',
					keyboard : false
				})
				console.log(candidate)
				$scope.candResult = candidate;
				$('#result-viewer').jsonViewer(candidate, {
					collapsed : false
				});

			}

		} ]);
