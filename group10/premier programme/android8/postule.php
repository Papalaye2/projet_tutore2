<?php

//$base = mysql_connect ('127.0.0.1', 'root', ''); 
$base=new PDO ('mysql:host=localhost;dbname=emploi','root','');
//mysql_select_db ('emploi', $base) ;  


 $candidat =$_GET['candidat'];
 
 $chaine='';
 $chaine2='';

 $resnd=$base->query("SELECT * FROM postule where ID_EMPLOYEUR='".$candidat."'");
 while($donnee=$resnd->fetch()){
    
    $chaine=$donnee["ID_CANDIDAT"];
    
 }
 
 $resnd2=$base->query("SELECT * FROM candidat where ID_CANDIDAT='".$chaine."'");
 while($donnee=$resnd2->fetch()){
    
    $chaine2=$chaine2.$donnee["NOM_CANDIDAT"].$donnee["PRENOM_CANDIDAT"].' |';
    
    
 }

/*$sql = 'SELECT * FROM annonce';
 $req = mysql_query($sql);
 
     
     
    
 while ($data = mysql_fetch_array($req)) {
	 
	    
		
	 $chaine=$chaine.$data["entreprise"].' |' ;
	
	 
	

  	}  */


	
    
       
 echo $chaine2.'!';
  //mysql_free_result ($req);  
 // mysql_close ();
?>  
 
 
 