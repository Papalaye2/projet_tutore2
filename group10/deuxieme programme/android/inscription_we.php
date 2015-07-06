<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 $date=$_GET['date'];
 $lieu=$_GET['lieu'];
 $desc=$_GET['desc'];
 
 
 
 
 $idcandi=$_GET['id_candi'];
 
 

 echo $date;
 echo  $lieu;
 echo $desc;
 

 $sql = "INSERT into work_expe (ID_CANDIDAT,ANNE_WORK,LIEU_WORK,DECRIPTION_WORK) VALUES ('$idcandi','$date', '$lieu','$desc')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 