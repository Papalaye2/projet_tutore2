<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ;
 
 
 
 
 
 
 
 
 $prenom=$_GET['prenom'];
 $nom=$_GET['nom'];
 $genre=$_GET['sexe'];
 $adresse=$_GET['adresse'];
 $age=$_GET['age'];
 $login=$_GET['login'];
 $password =$_GET['mdp'];
 $tel=$_GET['tel'];
 
 
 
 echo $prenom;
 echo $nom;
 echo $genre;
 echo $adresse;
 echo $password;
 echo $tel;
 
 $id=17;

 $sql = "INSERT into candidat (ID_CANDIDAT,NOM_CANDIDAT,PRENOM_CANDIDAT,ADRESSE_CANDIDAT,TELEPHONE_CANDIDAT,LOGIN_CANDI,MDP_CANDI,Email_candidat) VALUES ('$id','$nom','$prenom', '$adresse','$tel', '$login','$password','$genre')";
 
 if ((mysql_query($sql))==true)
 {
 echo 'Enregistrement avec succes !';
 }
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 