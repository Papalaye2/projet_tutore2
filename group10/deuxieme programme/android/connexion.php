<?php
session_start();

$base = mysql_connect ('127.0.0.1', 'root', ''); 

mysql_select_db ('institut2', $base) ;  

 $login=$_GET['login_use'];
 $password =$_GET['mdp_use'];

 
 $chaine='OK|';

       $sql = 'SELECT * FROM candidat WHERE LOGIN_CANDI= "'.$login.'" AND MDP_CANDI="'.$password.'"';
	   
	  $req = mysql_query($sql);
     
      if ($data = mysql_fetch_array($req)) {
	  
	
	 
	 $chaine=$chaine.$data["ID_CANDIDAT"].'   |'.$data["NOM_CANDIDAT"].'#' ;

  	}  
	  else 
	  
	 $chaine='KO!';
	
     echo $chaine.'!';  
 
 
 
 
 
 
 /*
  
  $chaine='';

$sql = 'SELECT * FROM candidat WHERE LOGIN_CANDI= "'.$login.'" AND MDP_CANDI="'.$password.'"';
	   
	  $req = mysql_query($sql);
    
      if ($data = mysql_fetch_array($req)) 
	  {
	  $chaine='OK|';
          
            $candidat = mysql_query("SELECT * FROM candidat where LOGIN_CANDI = '$password' and MDP_CANDI=  '$login'");
            
            while($candidat2 = mysql_fetch_array($candidat)){
           
            
             $chaine=$chaine.$candidat2['ID_CANDIDAT'].'   |'.$candidat2['NOM_CANDIDAT'].'#' ;
            
           
            }
	  
	  }
	  else 
	  
	 $chaine='KO!';
	
     echo $chaine.'!';
     
     
     */
 
  mysql_free_result ($req);  
  mysql_close ();
?>  
 
 

  
 
 