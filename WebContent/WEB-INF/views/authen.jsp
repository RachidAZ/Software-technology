<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<head>

<!-- All the files that are required -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />




<style>


.panel-default {
opacity: 0.9;
margin-top:30px;
}
.form-group.last { margin-bottom:0px; }


.content:before {
  content: "";
  position: fixed;
  left: 0;
  right: 0;
  z-index: -1;
  
  display: block;
  background: url(http://static.panoramio.com/photos/large/52729956.jpg)   ;
  width: 100%;
  height: 100%;
  
  -webkit-filter: blur(10px);
  -moz-filter: blur(10px);
  -o-filter: blur(10px);
  -ms-filter: blur(10px);
  filter: blur(10px);
  
}

.content {
  position: fixed;
  left: 0;
  right: 0;
  z-index: 0;
  
}
</style>
</head>


<body class="content" > 



<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-lock"></span> Login</div>
                <div class="panel-body">
                    <form class="form-horizontal"  method="post" action="authenLogin">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-3 control-label">
                            Email</label>
                        <div class="col-sm-9">
                            <input type="email" name= "Email"  class="form-control" id="inputEmail3" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-3 control-label">
                            Password</label>
                        <div class="col-sm-9">
                            <input type="password" name= "Password"  class="form-control" id="inputPassword3" placeholder="Password" required>
                        </div>
                    </div>
                    
                    
                      <div class="form-group" style="color: red; display: <c:out value='${show}'/>"   >
                        <div class="col-sm-offset-2 col-sm-9">
                            <div class="checkbox">
                                <label>
                                   
                                 Email or Password is incorrect !    
                                </label>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"/>
                                    Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group last">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-success btn-sm">
                                Sign in</button>
                                 <button type="reset" class="btn btn-default btn-sm">
                                Reset</button>
                        </div>
                    </div>
                    </form>
                </div>
                <div class="panel-footer">
                    Not Registred? <a href="#">Contact the Admin</a></div>
            </div>
        </div>
    </div>
</div>



</body> 

</html>