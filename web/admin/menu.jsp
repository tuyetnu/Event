<%-- 
    Document   : menu
    Created on : Oct 15, 2017, 2:40:45 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <!-- Bootstrap Core CSS -->
        <link href="/Event/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="/Event/css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="/Event/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="/Event/css/sb-admin-2.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="/Event/css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="/Event/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <s:if test="%{#session.ROLELOGIN != 'admin'}">
            <jsp:forward page="../login.jsp"/>
        </s:if>
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
                <li class="nav-item">
                    <s:a cssClass="nav-link" action="logout">
                        <i class="fa fa-fw fa-sign-out"></i>Logout</s:a>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">       
                            <li>
                            <s:a href="SearchEvent.action?searchValue="><i class="fa fa-dashboard fa-fw"></i> Dashboard</s:a>
                            </li>
                            <li>
                            <s:a href="SearchUser.action?searchValue="><i class="fa fa-table fa-fw"></i> User Manager</s:a>
                            </li>
                            <li>
                            <s:a href="/Event/post.jsp"><i class="fa fa-newspaper-o fa-fw"></i> New Event</s:a>
                            </li>
                            <li>
                            <s:a href="GetProfile.action"><i class="fa fa-edit fa-fw"></i> Edit Profile</s:a>
                        </li>
                        <li>
                            <a href="/Event/"><i class="fa fa-arrow-circle-right"></i> Back to Website</a>
                        </li>

                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
    </body>
</html>
