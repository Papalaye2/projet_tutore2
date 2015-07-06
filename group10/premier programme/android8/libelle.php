<?php

//$base = mysql_connect ('127.0.0.1', 'root', ''); 
$base=new PDO ('mysql:host=localhost;dbname=emploi','root','');
//mysql_select_db ('emploi', $base) ;  


 $entreprise =$_GET['entreprise'];
 
 $chaine='';

 $resnd=$base->query("SELECT * FROM annonce where entreprise='".$entreprise."'");
 while($donnee=$resnd->fetch()){
    
    $chaine=$chaine.$donnee["profil"].' |';
    
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
 
 
 