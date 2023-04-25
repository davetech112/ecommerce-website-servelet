<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cart Page</title>
  <%@include file ="includes/head.jsp" %>
</head>
<body>
<div class="container">
  <div class="card w-50 mx-auto my-5">
    <div class="card-header text-center">Admin Login</div>
    <div class="card-body">
      <form action="admin-login" method="post">
        <div class="form-group">
          <label>Email address</label>
          <input type="email" name="login-email" class="form-control" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label>Password</label>
          <input type="password" name="login-password" class="form-control" placeholder="Password">
        </div>
        <div class="text-center">
          <button type="submit" class="btn btn-primary">Login</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
<%@include file ="includes/footer.jsp" %>
</html>