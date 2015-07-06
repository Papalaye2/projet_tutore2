<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 $hobbie=$_GET['hobbie'];
 $idcandi=$_GET['id_candi'];
 
 
 
 
 
 //$idcandi=$_SESSION['indentiant_candi'];

 echo $hobbie;
 
 
 
 

 $sql = "INSERT into hobbies (ID_CANDIDAT,NOM_HOBIE) VALUES ('$idcandi','$hobbie')";
 
 if ((mysql_query($sql))==true)
 echo  'Enregistrement avec succes !' ; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 