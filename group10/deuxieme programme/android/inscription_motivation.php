<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 $id_annonce=$_GET['id_annonoe'];
 $idcandi=$_GET['id_candi'];
 $motviat=$_GET['motiv'];
 
 
 
 
 //$idcandi=$_SESSION['indentiant_candi'];

 echo $motviat;

 $sql = "INSERT into motivation (id_candidat,id_annonce,motiv) VALUES ('$idcandi','$id_annonce','$motviat')";
 
 if ((mysql_query($sql))==true)
 echo  'Enregistrement avec succes !' ; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 