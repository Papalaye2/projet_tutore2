<!DOCTYPE html>
<html>
 
 
 <head>
   <meta charset ="uft-8"/> 
  <link rel="stylesheet" href="motiv.css"/>
    
 </head>
   
<body>


 
<h1> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Motivation </h1>




<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('institut2', $base) ;



$idcandi=$_GET['id_candi'];
$id_annonoe=$_GET['id_annonoe'];

//$idcandi=1;
//$id_annonoe=1;


$langue = mysql_query("SELECT * FROM motivation where id_candidat='$idcandi' and id_annonce='$id_annonoe'");
while($langue2 = mysql_fetch_array($langue)){
?>
<p>
 <?php    echo $langue2['motiv']  ?>  
 
 </p>
 
<?php  
}
?>



</body>
</html>