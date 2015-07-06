<?php

$base = mysql_connect ('localhost', 'root', '');  
 mysql_select_db ('projet_tutore_sms', $base) ;  
 
 $frome=$_GET['frome'];
 $body=$_GET['bodye'];
 
 
 

 $sql = "INSERT into massage (frome,bodye) VALUES ('$frome','$body')";
 
 if ((mysql_query($sql))==true)
 echo 'Enregistrement avec succes !'; 
 else 
 echo 'Echec Enregistrement !'; 

 mysql_close();
 
?> 
 
