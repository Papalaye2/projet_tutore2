<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('esmt', $base) ;  

	  $matricule=$_GET['matricule'];
	  $chaine='';
      $sql = 'SELECT * FROM note WHERE etudiant="'.$matricule.'"';   
	    
	  $req = mysql_query($sql);
     
	  while ($row = mysql_fetch_array($req)) {
	  $chaine=$chaine.$row["matiere"].': '.$row["note"].'#' ;
	  }	
     echo $chaine.'!'; 
  mysql_close ();
?> 
 
 
 