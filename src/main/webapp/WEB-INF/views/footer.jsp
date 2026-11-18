<!doctype html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>

        </style>
    <body>

  <aside class="control-sidebar control-sidebar-dark">
<!--     Control sidebar content goes here -->
  </aside>
  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Copyright <i class="fa fa-copyright"></i> 2012-<span id="currentYear"></span> <a href="http://www.velox.co.in" target="_blank">Velox Solutions Pvt. Ltd.</a>
      <br><font class="float-right">All rights reserved.</font>
    </div>
    <!-- Default to the left -->
    <div class="row">
    <div class="col-md-8">
    <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" alt="" style="height:38px">

<%--     <img src="<%=request.getContextPath()%>/static/resources/img/3i-logo-Crop.png" alt="" style="height: 60px; float: right; margin-top: -8px; margin-bottom: -15px; padding-bottom: 5px; width: 70px;"> --%>

    </div>
    </div>
  </footer>
    </body>
    <script>
    
    const currentYear = new Date().getFullYear();
    $("#currentYear").text(currentYear);
    
    
//     window.onload = function() {
//////////////ADJUST FOOTER HEIGHT //////////
// var el = document.getElementsByClassName("content-wrapper");
// var height = el.offsetHeight;
// alert(height)
// var newHeight = height + 200;
// el.style.height = newHeight + 'px';
// }
    </script>
</html>
