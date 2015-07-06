<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('emploi', $base) ;  
 

 $nom=$_GET['nom'];
 $prenom=$_GET['prenom'];
 $adresse=$_GET['adresse'];
 $tel=$_GET['tel'];
 $login=$_GET['login'];
 $pwd=$_GET['pwd'];
$genre=$_GET['genre'];


 

 $sql = "INSERT into employeur (NOM_EMPLOYEUR,PRENOM_EMPLOYEUR,sexe_employeur ,ADRESSE_EMPLOYEUR,TEL_EMPLOYEUR,login_employeur,password_employeur,nb_annonce) VALUES
 ('$nom','$prenom', ' $genre','$adresse',$tel, ' $login',$pwd,0)";
 
 if ((mysql_query($sql))==true)


 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 
 



 mysql_close();
 
?> 
 
 
 