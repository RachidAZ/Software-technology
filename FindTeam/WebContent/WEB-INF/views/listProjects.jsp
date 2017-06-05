<!DOCTYPE html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>List of Projects / join a Team</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

  
   
  </head>

  <body style="font-family: -apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif; font-size: 1rem; font-weight: 400; line-height: 1.5; color: #292b2c; ">


   
    <section class="jumbotron text-center" style="padding-top: 6rem; padding-bottom: 6rem; margin-bottom: 0; background-color: #fff;text-align: center!important;border-radius: .3rem;-webkit-margin-before: 1em; -webkit-margin-after: 1em; -webkit-margin-start: 0px; -webkit-margin-end: 0px;">
      <div class="container" style="max-width: 60rem;font-size: 1rem; font-weight: 400; line-height: 1.5;">
        <h2 class="jumbotron-heading" style="font-weight: 300;">List of Projects / join a Team </h2>
        
<%--        <h1>  ${titre}  </h1> --%>
        
        <p class="lead text-muted" style="font-family: -apple-system,system-ui,BlinkMacSystemFont,''Segoe UI'',Roboto,'Helvetica Neue',Arial,sans-serif; font-size: 1.5rem; font-weight: 400; line-height: 1.5;">Choose a project below which would you like to have a team or to join . after clicking on a project you will have to like the members whom you would like to work with!</p>
       
      </div>
    </section>

    <div class="album text-muted">
      <div class="container">

 
        <div class="row">
        
 
        
        <c:forEach items="${listP}" var="u">

        
 <div class="card" style="float: left; width: 33.333%; padding: .75rem; margin-bottom: 1rem; height: 200px; border: 1px solid rgba(0,0,0,.125); border-radius: .25rem; ">
			<h2 style="height: 100px; width: 100%; display: block;"> <c:out value="${u.getDescription()}"/> </h2>
            <p class="card-text" >Information about the project : Deadline : <c:out value="${u.getDeadline()}"/> , Max number of members : <c:out value="${u.getMax_Inteam()}"/> - <a href="./getProject/${u.getProject_id()}" >Enter</a> </p>
          </div>




</c:forEach>


        
        
        
		  
         
        </div>

      </div>
    </div>

    <footer class="text-muted"  style="padding-top: 1rem; padding-bottom: 1rem;" >
      <div class="container">
        <p class="float-right" style="margin-bottom: 0rem;">
          <a href="#">Back to top</a>
        </p>
        <p style="margin-bottom: 0rem;">Find Your TEAM - Easy , simple and efficient!</p>

      </div>
    </footer>
    
    
    