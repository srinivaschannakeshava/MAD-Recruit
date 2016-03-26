/**
 * 
 */
madRecruitApp.service('loginService', function(httpService) {
	this.isLoggedIn = function(callback) {
		httpService.getRequest('login/isLoggedIn', callback);
	};

	this.getLoggedInUser = function(callback) {
		httpService.getRequest('login/loggedInUser', callback);
	};

	this.login = function(data, callback) {
		httpService.postRequest('/com.mad.recruit/j_spring_security_check', data,
				'application/x-www-form-urlencoded', callback);
	};

	this.logout = function(callback) {
		httpService.getRequest('/com.mad.recruit/j_spring_security_logout', callback);
	};

});