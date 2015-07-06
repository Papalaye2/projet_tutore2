<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('senefoot', $base) ;  

	  $chaine='';
      $sql = 'SELECT * FROM organisation';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["1er_equipe"].' '.$row["vs"].' '.$row["2eme_equipe"].'#' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 