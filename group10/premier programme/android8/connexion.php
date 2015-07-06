<?php

$base = mysql_connect ('127.0.0.1', 'root', ''); 

mysql_select_db ('emploi', $base) ;  

 $login=$_GET['login'];
 $password =$_GET['password'];

  $chaine='OK|';

       $sql = 'SELECT * FROM employeur WHERE login_employeur = "'.$login.'" AND password_employeur="'.$password.'"';
	   
	  $req = mysql_query($sql);
     
      if ($data = mysql_fetch_array($req)) {
	  
	
	 
	 $chaine=$chaine.$data["ID_EMPLOYEUR"].'   |'.$data["NOM_EMPLOYEUR"].'#' ;

  	}  
	  else 
	  
	 $chaine='KO!';
	
     echo $chaine.'!';  
 
  mysql_free_result ($req);  
  mysql_close ();
?>  
 
 
 
 