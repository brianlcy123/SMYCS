<%-- 
    Document   : index
    Created on : Jul 12, 2017, 5:21:07 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Show me your cheat sheet!</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/3-col-portfolio.css" rel="stylesheet">
    <link href="resources/css/drop-zone.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-tagsinput.css" rel="stylesheet"/>
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/template.js"></script>
    <script src="resources/js/common.js"></script>
    <script src="resources/js/blueimp-gallery.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a id="home" class="navbar-brand" href="#">Show Me Your Cheat Sheet</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a id="upload" href="#">Upload</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
<!--                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>-->                    
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                <li><a href=""></a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">More<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="/logout">Log out</a></li>
                  </ul>
                </li>
              </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div id="body" class="container">
    </div>

</body>

</html>
