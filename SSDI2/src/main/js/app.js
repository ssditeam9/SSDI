var app = angular.module('myApp', []);
//Controller
app.controller("MyController", ["$scope", "$http",function($scope, $http){

 $scope.getStateDataFromServer = function() {
   $http({method: 'GET', url: 'http://localhost:8080/states'}).
    success(function(data, status, headers, config) {
        $scope.data = state;
    }).
    error(function(data, status, headers, config) 
    });
 }
}]);