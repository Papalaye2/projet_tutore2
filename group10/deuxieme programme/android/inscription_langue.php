<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 $langue=$_GET['langue'];
 $niveau=$_GET['niveau'];
 $idcandi=$_GET['id_candi'];
 
 

 echo $langue;
 echo  $niveau;
 
 

 $sql = "INSERT into langue (ID_CANDIDAT,NOM_LANGUE,NIVEAU_LANGUE) VALUES ('$idcandi','$langue', '$niveau')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 