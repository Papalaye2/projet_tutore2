<?php

$base = mysql_connect ('127.0.0.1', 'root', ''); 

mysql_select_db ('emploi', $base) ;  

 $login=$_GET['login'];
 $password =$_GET['password'];

  $result='';
  $id_user='0';

$sql = 'SELECT * FROM employeur WHERE login_employeur = "'.$login.'" AND password_employeur="'.$password.'"';
	   
	  $req = mysql_query($sql);
     
      if ($data = mysql_fetch_array($req)) 
	  {
	  $result='OK!';
	  
	  $sql2 = 'SELECT ID_EMPLOYEUR FROM employeur WHERE login_employeur = "'.$login.'" AND password_employeur="'.$password.'"';
	   
	  $req2 = mysql_query($sql2);
	 
	  while ($row = mysql_fetch_row($req2)){
		  $id_user=$row[0];
	  }
	  
	  }
	  else  
	  {
		  $result='KO!';
		 
	  }
	 
	
	//tableau de retour
	echo "<table>
            
            
			<tr>
                        $result$id_user!
			</tr>
        </table>	
			";
	
	
	
    // echo $result;
	//echo $id_user.'#';
	
	
	
 
  mysql_free_result ($req); 

  
  mysql_close ();
?>  
 
 
 