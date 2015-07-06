<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('emploi', $base) ;  
 

 $idemployeur=$_GET['id'];
 $libelle=$_GET['libelle'];
 $entreprise=$_GET['entreprise'];
 $profil=$_GET['profil'];
 $date=$_GET['date'];
 $mail=$_GET['contact'];
$domaine=$_GET['domaine'];






 $sql = "INSERT into annonce (ID_EMPLOYEUR,LIBELLE,DATE_PUBLI, entreprise, profil,mail,domaine) VALUES ('$idemployeur','$libelle','$date','$entreprise', '$profil','$mail','$domaine')";
 
 if ((mysql_query($sql))==true)


 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 
 



 mysql_close();
 
?> 
 
 
 