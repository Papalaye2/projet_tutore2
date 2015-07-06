<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('senefoot', $base) ;  

	  $chaine='';
      $sql = 'SELECT * FROM lescrores';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["Equipe1"].'   '.$row["score1"].'  -  '.$row["score2"].'   '.$row["Equipe2"].'         '.$row["etat"].'#' ;
	  
	  }	
     echo $chaine.'!';
	
  mysql_close ();
?> 
 
 
 