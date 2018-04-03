<%-- 
    Document   : header
    Created on : Oct 15, 2017, 3:05:55 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Simple &mdash; Free HTML5 Bootstrap Website Template by FreeHTML5.co</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
        <meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="FreeHTML5.co" />

        <!-- 
              //////////////////////////////////////////////////////
      
              FREE HTML5 TEMPLATE 
              DESIGNED & DEVELOPED by FreeHTML5.co
                      
              Website: 		http://freehtml5.co/
              Email: 			info@freehtml5.co
              Twitter: 		http://twitter.com/fh5co
              Facebook: 		https://www.facebook.com/fh5co
      
              //////////////////////////////////////////////////////
        -->

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico">

        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
        <!-- Animate.css -->
        <link rel="stylesheet" href="/Event/css/animate.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="/Event/css/magnific-popup.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="/Event/css/bootstrap.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="/Event/css/icomoon.css">
        <!-- Theme style  -->
        <link rel="stylesheet" href="/Event/css/style.css">
        <style>
            .intro {
                font-family: 'Playball',cursive;
                font-size: 60px;
                line-height: 1.0;
                font-weight: 900;
                color: #fff;
            }
        </style>

        <!-- Modernizr JS -->
        <script src="/Event/js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <link href="/Event/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="/Event/css/sb-admin-2.css" rel="stylesheet">
    </head>
    <body>

        <div id="fh5co-wrap">
            <header id="fh5co-header">
                <div class="container">
                    <nav class="fh5co-main-nav">
                        <ul>
                            <li class="fh5co-active"><a href="/Event/index.jsp"><span>Home</span></a></li>
                            <li>
                                <a href="/Event/post.jsp"><span>Offer Event</span></a>
                            </li>
                            <li>
                                <s:a action="View"><span>View Event</span></s:a>
                                </li>

                            <s:if test="%{#session.ROLELOGIN != 'admin' && #session.ROLELOGIN != 'user'}" >
                                <li><a href="/Event/login.jsp"><span>Login</span></a></li>
                                <li><a href="/Event/register.jsp"><span>Register</span></a></li>
                                </s:if>

                            <s:if test="%{#session.ROLELOGIN == 'admin' || #session.ROLELOGIN == 'user'}">
                                <ul class="nav navbar-top-links navbar-right">
                                    <li class="nav-item">
                                        <s:if test="%{#session.ROLELOGIN  == 'user'}">
                                            <a href="/Event/user/index.jsp">Login as ${sessionScope.USERLOGIN}</a>
                                        </s:if>
                                        <s:if test="%{#session.ROLELOGIN  == 'admin'}">
                                            <s:a href="SearchEvent.action?searchValue=">Login as ${sessionScope.USERLOGIN}</s:a>
                                        </s:if>
                                        <s:a cssClass="nav-link" action="logout">
                                            <i class="fa fa-fw fa-sign-out"></i>Logout</s:a>
                                        </li>
                                    </ul>
                            </s:if>
                        </ul>
                    </nav>
                </div>
            </header>

            <div class="fh5co-hero" style="background-image: url(/Event/images/hero_1.jpg);" data-stellar-background-ratio="0.5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-center fh5co-table">
                            <div class="fh5co-intro fh5co-table-cell">
                                <br/><br/><br/>
                                <div class="text-center">
                                    <h1 class="intro animated">EVENT EVERYWHERE</h1>
                                </div>

                                <p>Let's join in our special event and have fun with your friends</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- END fh5co-wrap -->

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Stellar -->
        <script src="js/jquery.stellar.min.js"></script>
        <!-- MAIN JS -->
        <script src="js/main.js"></script>
    </body>
</html>