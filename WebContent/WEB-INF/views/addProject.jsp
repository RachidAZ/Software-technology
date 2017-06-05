<html>


<head>

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
</style>
</head>


<body style=' background-color:"gray"'> 




<div class="container">
    <div class="row">
		<form role="form" class="col-md-9 go-right">
			<h2>Add New Project</h2>
            <p>Please fill all the fields below. </p>
			<div class="form-group">
			<input id="projectName" name="projectName" type="text" class="form-control" required>
			<label for="name">Project Name</label>
		</div>
		<div class="form-group">
			<input id="Description" name="Description" type="text" class="form-control" required>
			<label for="phone">Description</label>
		</div>
		<div class="form-group">
			<input id="Max_members" name="Max_members" type="text" class="form-control" required>
			<label for="phone">Max Members</label>
		</div>
		
		<div class="form-group">
			<input id="Deadline" name="Deadline" type="text" class="form-control" required>
			<label for="phone">Deadline</label>
		</div>
	
		
		
		  <div class="form-group">
                        <!-- Button -->
                      
                            <button type="submit" href="#" class="btn btn-primary pull-right"></i> Save</button>                          
                       
                    </div>
				

				  <!-- Message , to display after add -->
		<div class="alert alert-success" role="alert">  <strong> Well done!  </strong> You successfully added you data ,
		<a href="projects" class="alert-link"> Display Projects.</a>
		</div>
				
		</form>
		


        
		 
                     
					
		
	</div>
</div>
</body> 

</html>

