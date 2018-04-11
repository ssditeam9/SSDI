<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product added</title>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: white;
    background-color: #53CACE;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

</style>
</head>
<body>
<!-- <h1>Your Product has been added successfully</h1>
<h2>To add another product <a href="http://localhost:8080/api/addproduct">Click here</a> or
 <a href="http://localhost:8080/user/logout">logout</a></h2>  -->
 
 <div class="container">

<header>
   <h1>Your Product has been added successfully</h1>
</header>
  
<nav>
  <ul>
    <li><p><i>To add another product <a href="http://localhost:8080/api/addproduct">Click here</a> or
 <a href="http://localhost:8080/user/logout">logout</a></i></p></li>
    
  </ul>
</nav>

<footer> Copyrights Sab </footer>

</div>
</body>
</html>