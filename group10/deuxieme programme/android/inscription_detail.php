<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 $detail=$_GET['detail'];
 $idcandi=$_GET['id_candi'];
 
 
 
 
 
 
 
 
 
//$idcandi=$_session['indentiant_candi'];
 //$idcandi=1;

 echo $hobbie;
 
 
 

 $sql = "INSERT into detail_pro (id_candit,desc_dp) VALUES ('$idcandi','$detail')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 