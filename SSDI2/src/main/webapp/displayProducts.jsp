<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>
<link rel="stylesheet" type="text/css" href="../css/product.css">
<link rel="stylesheet" type="text/css" href="../css/login.css">

<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body ng-app="myapp">

<div id="header">
 <div class="container">
        <div class="leftbox">
            LOGO image
            </div>
<div class="rightbox" ng-controller="loginController">
 <form class="form-signin">
        <h2 class="form-signin-heading">Start selling right away!</h2>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="button" ng-click="goLogin()">Sign in</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" ng-click="goReg()">Register</button>
      </form>

</div> </div></div>

<div ng-controller="productController">

   <c:forEach items="${productList}" var="prod" varStatus="x">
   <div class="wrapper">
  <div class="container">
    <div class="top"><img alt="" style="width:200px" height="200px" src='<c:out value="${prod.imageurl}" />'></div>
    <div class="bottom">
      <div class="left">
        <div class="details">
          <h1><c:out value="${prod.name}"/></h1>
          <p>$<c:out value="${prod.basePrice}"/></p>
          <p></p>
        </div>
        <div class="buy"><i class="material-icons">add_shopping_cart</i></div>
      </div>
      <div class="right">
        <div class="done"><i class="material-icons">done</i></div>
        <div class="details">
        <p><label>Quote Price:    <input type="text" name="input"  ng-model="abc" id="${prod.id}" > </label><!-- id='"quotedPrice"+"{{$prod.id}}"' -->
        <button ng-click="quote(${prod.id},${prod.minPrice})" >Quote</button></p>
        <!-- <h1><c:out value="${prod.name}"/></h1> -->  
          <p>Added to your cart</p>
        </div>
        <div class="remove"><i class="material-icons">clear</i></div>
      </div>
    </div>
  </div>
  <div class="inside">
    <div class="icon"><i class="material-icons">info_outline</i></div>
    <div class="contents">
      <table>
        <tr>
          <th>Width</th>
          <th>Height</th>
        </tr>
      </table>
    </div>
  </div>
</div>
</c:forEach>

  <script>
var myApp = angular.module("myapp", []);
myApp.controller('loginController', ['$scope',function($scope) {
    $scope.goReg = function(){
    	 window.location = "/user/register";
    }
    
    $scope.goLogin = function(){   
   	 window.location = "/user/login";
   }
}]);

myApp.controller('productController', ['$scope',function($scope) {
	
    $scope.quote = function(prodId,minPrice){
    	var target  = document.getElementById(prodId).value;
    	window.alert("id "+target);
    	window.alert("the prodId" +prodId);
    	 if(prodId >= minPrice){
    		 window.alert("Hi");
    	 }
    	/*  window.alert(prodId);
    	 var myElement = angular.element(document.querySelector( 'quotedPrice'+prodId )).value;
    	 window.alert(myElement);
     */}
}]);


</script>
</div>
</body>
</html>