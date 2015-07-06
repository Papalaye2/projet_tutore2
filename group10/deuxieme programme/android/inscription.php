<?php

 $base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('androidesmt', $base) ;  
 
 $prenom=$_GET['prenom'];
 $nom=$_GET['nom'];
 $genre=$_GET['genre'];
 $diplome=$_GET['diplome'];
 $formation=$_GET['formation'];

 $sql = "INSERT into etudiant (nom_etu,prenom_etu,genre_etu,diplome_etu,formation_etu) VALUES ('$prenom','$nom', '$genre','$diplome', '$formation')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
 
 