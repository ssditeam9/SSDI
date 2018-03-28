<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>

<script>
var myApp = angular.module("myApp", []);

myApp.controller('GreetingController', ['$scope', function($scope) {
	  $scope.greeting = 'Hola!';
	}]);


$scope.test = function(text) {
	  alert(text);
	}

function GetController($scope, $http) {

    $scope.goLogin = function() {

        // $http.defaults.useXDomain = true;
        alert("hello");

        var response = $http.get('http://localhost:8080/user/signUp');

        response.success(function(data, status, headers, config) {

            alert("Ok.");

        });

        response.error(function(data, status, headers, config) {
            alert("Error.");
        });

    };

}

.controller('LoginCtrl', function($scope, $location) {
    $scope.form = {
        username: null,
        password: null
    };

    $scope.goLogin = function() {
    	alert("hello");
        $location.url('http://test.com/login.jsp?un='+ $scope.form.username +'&pw="+ $scope.form.password);
    };
})



</script>


<style>
table, th , td {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>



<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body ng-app="">

<table border="1">
<tr height="100"> <b> Welcome to E-Commerce</b> </tr>
<tr height="100"><td></td><td align="right">Seller: <button ng-click="test(game)">Log in</button><button ng-click="goLogin()">Register</button></td></tr>
<tr height="100"> 
<td width="100"> </td>


<td> 
<table class="CalendarReservationsBodyTable">
  <thead>
    <tr>
      <th colspan="30" width="100">List of Products</th>
    </tr>
    <tr>
      <th class="corner wideRow">Name</th>
      <th class="odd" colspan="4">Image</th>
      <th class="corner wideRow" colspan="4">Description</th>
      <th class="corner wideRow" colspan="4">Quantity Available</th>
      <th class="odd" colspan="4">Seller Info</th>
      <th class="odd" colspan="4">Base Price</th>
      <th class="odd" colspan="4">Buy Now</th>
      
    </tr>
  </thead>
  <tbody>
  
   <c:forEach items="${productList}" var="prod" varStatus="x">
        <tr>
            <td><c:out value="${prod.name}"/></td>
            <td colspan="4"><img src='<c:out value="${prod.imageurl}" />' style='width:100px;height:100px;' alt="Mountain View"></td>
            <td colspan="4" class="alignRight wideRow"><c:out value="${prod.description}"/></td>
	      	<td colspan="4" class=" borderLeft"><c:out value="${prod.quantity}"/></td>
	     	<td colspan="4" class="odd">Id:<c:out value="${prod.sellerId}"/></td>
	      	<td colspan="4" class="">$ <c:out value="${prod.basePrice}"/></td>
	      	<td colspan="4" class="">
	      	<p><label>Quote Price:    <input type="text" name="input" ng-model="example.text" ng-pattern="example.word" required ng-trim="false"> </label></p>
	      	<p>Quoting {{example.text}} $</p>
	      	
	      	<button ng-click="count = count + 1" ng-init="count=0">Quote & Buy</button>
	      	<p>Clicks {{count}}</p>
	      	
	      	
	     
	      	
	      	
	      	</td>
      
        </tr>
    </c:forEach>
  
    <tr>
      
     
    </tr>
  </tbody>
</table>  </td>


</tr>


</table>

  
    




</body>

</html>