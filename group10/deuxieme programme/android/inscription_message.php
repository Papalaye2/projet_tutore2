<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 
 
 
 
 
 
 

 
 
 
 
 $idcandi=$_GET['id_candi'];
 $idemployeur=$_GET['id_employeur'];
 $message=$_GET['message'];
 
 
 
 
 //$idcandi=$_SESSION['indentiant_candi'];

 echo $motviat;

 $sql = "INSERT into message (id_candi,id_employ,txt_message) VALUES ('$idcandi','$idemployeur','$message')";
 
 if ((mysql_query($sql))==true)
 echo  'Enregistrement avec succes !' ; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 