<?php
session_start();

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;  
 
 $anne=$_GET['anne'];
 $etablissement=$_GET['etablissement'];
 $formation=$_GET['formation'];
 
 
 
  $idcandi=$_GET['id_candi'];
 
 

 echo $anne;
 echo  $etablissement;
 echo $formation;
 

 $sql = "INSERT into educatiobn (ID_CANDIDAT,ANNE_EDU,ETABLISEMENT_EDU,INTITULECEDU) VALUES ('$idcandi','$anne', '$etablissement','$formation')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 