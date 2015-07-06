<?php

//$base = mysql_connect ('127.0.0.1', 'root', ''); 
$base=new PDO ('mysql:host=localhost;dbname=emploi','root','');
//mysql_select_db ('emploi', $base) ;  


 $choix =$_GET['choix'];
 
 $chaine='';

 $resnd=$base->query("SELECT * FROM annonce");
 while($donnee=$resnd->fetch()){
    
    $chaine=$chaine.$donnee["entreprise"].' |';
    
 }

/*$sql = 'SELECT * FROM annonce';
 $req = mysql_query($sql);
 
     
     
    
 while ($data = mysql_fetch_array($req)) {
	 
	    
		
	 $chaine=$chaine.$data["entreprise"].' |' ;
	
	 
	

  	}  */


	
    
       
 echo $chaine.'!';
  //mysql_free_result ($req);  
 // mysql_close ();
?>  
 
 
 