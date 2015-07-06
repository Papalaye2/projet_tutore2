<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('senefoot', $base) ;  

	  $chaine='';
      $sql = 'SELECT * FROM equipe';   
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["Nom_equipe"].'   |'.$row["Effectifs"].'   |'.$row["President"].'   |'.$row["Coach"].'   |'.$row["Localite"].'#' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 