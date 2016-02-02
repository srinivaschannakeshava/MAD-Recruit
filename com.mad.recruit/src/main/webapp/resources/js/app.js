/**
 * 
 */
var madRecruitApp = angular.module("madRecruitApp", [ 'ngRoute' ]);

madRecruitApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/candidatelist', {
		templateUrl : 'home',
	// controller:'candidateCtrl'
	}).when('/interviewlist', {
		templateUrl : 'interview',
	// controller:'interviewCtrl'
	})
} ]);