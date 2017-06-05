<!DOCTYPE html>



<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Admin Control Panel</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		
		
		
		
<!-- All the files that are required -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<style>
@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,600);

.form-control{
    background: transparent;
}
form {
	width: 320px;
	margin: 20px;
}
form > div {
	position: relative;
	overflow: hidden;
}
form input, form textarea {
	width: 100%;
	border: 2px solid gray;
	background: none;
	position: relative;
	top: 0;
	left: 0;
	z-index: 1;
	padding: 8px 12px;
	outline: 0;
}
form input:valid, form textarea:valid {
	background: white;
}
form input:focus, form textarea:focus {
	border-color: #357EBD;
}
form input:focus + label, form textarea:focus + label {
	background: #357EBD;
	color: white;
	font-size: 70%;
	padding: 1px 6px;
	z-index: 2;
	text-transform: uppercase;
}
form label {
	-webkit-transition: background 0.2s, color 0.2s, top 0.2s, bottom 0.2s, right 0.2s, left 0.2s;
	transition: background 0.2s, color 0.2s, top 0.2s, bottom 0.2s, right 0.2s, left 0.2s;
	position: absolute;
	color: #999;
	padding: 7px 6px;
	font-weight: normal;
}
form textarea {
	display: block;
	resize: vertical;
}
form.go-bottom input, form.go-bottom textarea {
	padding: 12px 12px 12px 12px;
}
form.go-bottom label {
	top: 0;
	bottom: 0;
	left: 0;
	width: 100%;
}
form.go-bottom input:focus, form.go-bottom textarea:focus {
	padding: 4px 6px 20px 6px;
}
form.go-bottom input:focus + label, form.go-bottom textarea:focus + label {
	top: 100%;
	margin-top: -16px;
}
form.go-right label {
	border-radius: 0 5px 5px 0;
	height: 100%;
	top: 0;
	right: 100%;
	width: 100%;
	margin-right: -100%;
}
form.go-right input:focus + label, form.go-right textarea:focus + label {
	right: 0;
	margin-right: 0;
	width: 40%;
	padding-top: 5px;
}


.form-group { width:400px  }
.alert-success { width:400px  }

</style>
		
		
		
		
		
		
		
	</head>
	<body>
<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-toggle"></span>
      </button>
      <a class="navbar-brand" href="#">Home</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        
        
      </ul>
    </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">
  
  <!-- upper section -->
  <div class="row">
	<div class="col-sm-3">
      <!-- left -->
  
      
  	</div><!-- /span-3 -->
    <div class="col-sm-9">
      	
      <!-- column 2 -->	
       <h3><i class="glyphicon glyphicon-dashboard"></i> Member page</h3>  
            
       <hr>
      
	   <div class="row">
            <!-- center left-->	
         	<div class="col-md-7">
			
              
            
              
              <div class="panel panel-default">
                  <div class="panel-heading"><h4>Add your data</h4></div>
                  <div class="panel-body">
                    
					


<div class="container">
    <div class="row">
		<form role="form" class="col-md-9 go-right" method="post" action="UpdateMember">
			<h2>Complete your profile</h2>
            <p>Please fill all the fields below. </p>
			<div class="form-group" >
			<input id="Name" name="Name" type="text" class="form-control" required>
			<label for="name">Name</label>
		</div>
		<div class="form-group">
			<input id="Last_Name" name="Last_name" type="text" class="form-control" required>
			<label for="LastName">Last Name</label>
		</div>
		<div class="form-group">
			<input id="Age" name="Age" type="text" class="form-control" required>
			<label for="Age">Age</label>
		</div>
		
		<div class="form-group">
			<input id="LANGUAGES" name="Languages" type="text" class="form-control" required>
			<label for="Languages">LANGUAGES</label>
		</div>
	
		<div class="form-group">
			<input id="SKILLS" name="Skills" type="text" class="form-control" required>
			<label for="Skills">Skills</label>
		</div>
	
	<div class="form-group">
			<input id="PASSWORD" name="Password" type="password" class="form-control" required>
			<label for="Password">PASSWORD</label>
		</div>	
		
		<div class="form-group">
			<input id="Conf_PASSWORD" name="Conf_PASSWORD" type="password" class="form-control" required>
			<label for="Password">Confirm PASSWORD</label>
		</div>	
		
		  <div class="form-group">
                        <!-- Button -->
                      
                            <button type="submit" href="addproject" class="btn btn-primary pull-right"></i> Save</button>                          
                       
                    </div>
				

		
				
		</form>
		


        
		 
                     
					
		
	</div>
</div>


                  </div><!--/panel-body-->
              </div><!--/panel-->                     
              
          	</div><!--/col-->
         
            <!--center-right-->
        	
     
       </div><!--/row-->
  	</div><!--/col-span-9-->
    
  </div><!--/row-->
  <!-- /upper section -->
  
  <!-- lower section -->
  <div class="row">
    
   
      
    
    </div>
    
    
  </div><!--/row-->
  
</div><!--/container-->
<!-- /Main -->




  
	</body>
</html>