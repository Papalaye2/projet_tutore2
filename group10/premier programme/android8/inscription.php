<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('emploi', $base) ;  
 
 $prenom=$_GET['prenom'];
 $nom=$_GET['nom'];
 $genre=$_GET['genre'];
 $adresse=$_GET['adresse'];
 $telephone=$_GET['telephone'];
 $login=$_GET['login'];
 $password=$_GET['password'];

 $sql = "INSERT into employeur (NOM_EMPLOYEUR, PRENOM_EMPLOYEUR, sexe_employeur, ADRESSE_EMPLOYEUR, TEL_EMPLOYEUR, login_employeur, password_employeur) VALUES ('$nom','$prenom', '$genre','$adresse', '$telephone',$login,$password)";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 