<%-- 
    Document   : verProyecto
    Created on : 08-nov-2019, 18:36:57
    Author     : hp
--%>

<%@page import="java.util.Collection"%>
<%@page import="modelo.Proyectos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="recursos/css/mapa.css" rel="stylesheet" type="text/css"/>
           <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/bootstrap/jquery.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/sweetalert2.all.min.js" type="text/javascript"></script>
        
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link href="recursos/css/sweetalert.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="css/material.min.css">
	<link rel="stylesheet" href="css/material-design-iconic-font.min.css">
	<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css">
	<link rel="stylesheet" href="css/main.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.2.min.js"><\/script>')</script>
	<script src="js/material.min.js" ></script>
	<script src="js/sweetalert2.min.js" ></script>
	<script src="js/jquery.mCustomScrollbar.concat.min.js" ></script>
	<script src="js/main.js" ></script>
        
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>

        <script>
            $(document).ready(function(){
                $('#del').click(function(){
                Swal.fire({
                    type:"info",
                    tittle:"Eliminar registro",
                    text:"No se podrá recuperar despues de eliminar",
                    showCancelButton:true,
                    cancelButtonColor:"red"
                    
                }).then(result=>{
                    if(result.value){
                        $('#d1').append("<input type='hidden' name='eliminar'>");
                        $('#f1').submit();
                    }
                });
                });
            });
        </script>
        <script>
            $(document).ready(function() {
            $('#example').DataTable( {
                columnDefs: [
                    {
                        targets: [ 0, 1, 2 ],
                        className: 'mdl-data-table__cell--non-numeric'
                    }
                ]
            } );
        } );
        </script>
        <title>JSP Page</title>
<style type="text/css">
    label{
    font-weight: bold;
  }
  thead{
      font-weight: bold;
      color: white;
      background-color: lightseagreen;
    }
  h1{
     font-weight: bold; 
  }
  body{
    background-color:  #F1F0F0;
        height: 100%;
        margin: 0;
        padding: 0;
  }
        </style>
    </head>
    <body>
        <%
            if(request.getAttribute("proyecto")==null)
                    response.sendRedirect("ControlProyecto?mostrar=1");               
        %>
    <br><br><center>
        
        <h1>Vista Proyecto<i class="fa fa-pencil"></i></h1></center>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;&nbsp; 
   
   <image  src="icono.png" >
   <a href="vistaProyecto.jsp" class="btn btn-info"> Nuevo</a>
    <center>
        <table id="example" class="mdl-data-table"  width="50%"  border="1" cellpadding="0" cellspacing="0">
                        <thead><tr>
                        <th> ID PROYECTO </th>
                        <th> DIRECCION  </th>
                        <th> LATITUD </th>
                        <th> LONGITUD  </th>
                        <th> FOTO </th>
                        <th> ACCION </th>
                    </tr></thead>
                    <%
                        if(request.getAttribute("proyecto")!=null){
                            
                            ArrayList<Proyectos> pro = new ArrayList<Proyectos>();
                            pro.addAll((Collection)request.getAttribute("proyecto"));
                            
                            for(Proyectos p:pro){
                                out.println("<tr><td>"+p.getId()+""
                                        + "</td><td>"+p.getDireccion()+""
                                        + "</td><td>"+p.getLatitud()+""
                                        + "</td><td>"+p.getLongitud()+""
                                        + "</td><td>"+p.getFoto()+""
                                        + "</td>"
                                        + "<td colspan='2'><input type='button' "
                                        + "value='editar' class='btn btn-danger' onclick=$('#idProyecto')."
                                        + "val('"+p.getId()+"');$('#direccion')."
                                        + "val('"+p.getDireccion().replace(" ", "&nbsp;")+"');$('#latitud')."
                                        + "val('"+p.getLatitud().replace(" ", "&nbsp;")+"');$('#longitud')."
                                        + "val('"+p.getLongitud().replace(" ", "&nbsp;")+"');$('#foto')."
                                        + "val('"+p.getFoto()+"');"
                                        + "</td></tr>");
                            }
                        }
                    %>
                </table><br><br> 
                <center>
                    
                    <%
                    if(request.getAttribute("r")!=null)
                        out.println("<script>Swal.fire('Resultado', '"+request.getAttribute("r")+"', 'info')</script>");
                    if(request.getAttribute("error")!=null)
                        out.println("<script>Swal.fire('Resultado', '"+request.getAttribute("error")+"', 'info')</script>");
                %>
    </body>
</html>
