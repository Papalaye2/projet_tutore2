<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('bdetudiant', $base) ;  

	  $chaine='';
      $sql = 'SELECT * FROM tbetudiant';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["nom"].' '.$row["prenom"].'#' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 