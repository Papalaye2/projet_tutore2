<!DOCTYPE html>
<html>
 
 
 <head>
   <meta charset ="uft-8"/> 
  <link rel="stylesheet" href="cvcss.css"/>
    
 </head>
   
<body>

<h1>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CURRICULUM VITAE </h1>

<?php
 $idcandi=$_GET['id_candi'];


$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('institut2', $base) ;

$candidat = mysql_query("SELECT * FROM candidat where ID_CANDIDAT='$idcandi'");
while($candidat2 = mysql_fetch_array($candidat)){
?>   


 <?php    echo $candidat2['NOM_CANDIDAT'] ?> &nbsp;&nbsp;
 <?php    echo $candidat2['PRENOM_CANDIDAT'] ?>  <br>
 <?php    echo $candidat2['ADRESSE_CANDIDAT'] ?>  <br>
 <?php    echo $candidat2['TELEPHONE_CANDIDAT'] ?>  <br> 
 <?php    echo $candidat2['Email_candidat'] ?>  <br>

<?php  
}
?>
 
<h2> PROFIL DU CV </h2>


<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('institut2', $base) ;

$detaipro = mysql_query("SELECT * FROM detail_pro where id_candit='$idcandi'");
while($detaipro2 = mysql_fetch_array($detaipro)){
?>     
 <p> <?php echo $detaipro2['desc_dp']?>  </p> 
 
<?php  
}
?>


<h2> FORMATION </h2>


<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('institut2', $base) ;

$educatiobn = mysql_query("SELECT * FROM educatiobn where ID_CANDIDAT='$idcandi'");
while($educatiobn2 = mysql_fetch_array($educatiobn)){
?>     

 <p> <?php    echo $educatiobn2['ANNE_EDU'] ?>   : 
 <?php    echo $educatiobn2['INTITULECEDU'] ?>   <br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <?php    echo  $educatiobn2['ETABLISEMENT_EDU']  ?>  </p> 
 
<?php  
}
?>



 
<h2> EXPERIANCE PRIFESIONNELLE </h2>



<?php

$base = mysql_connect ('127.0.0.1', 'root', '');  
mysql_select_db ('institut2', $base) ;

$work_expe = mysql_query("SELECT * FROM work_expe where ID_CANDIDAT='$idcandi'");
while($work_expe2 = mysql_fetch_array($work_expe)){
?>

<p>
 <?php    echo $work_expe2['ANNE_WORK']  ?>  :
 <?php    echo $work_expe2['DECRIPTION_WORK'] ?> <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <?php    echo $work_expe2['LIEU_WORK'] ?>  

 </p>
 
<?php  
}
?>





<h2> LANGUES </h2>


<?php

$langue = mysql_query("SELECT * FROM langue where ID_CANDIDAT='$idcandi'");
while($langue2 = mysql_fetch_array($langue)){
?>
<p>
 <?php    echo $langue2['NOM_LANGUE']  ?>  
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<?php    echo  $langue2['NIVEAU_LANGUE'] ?>  
 </p>
 
<?php  
}
?>



<h2> PASSION/HOBBIES </h2>


<?php

$hobbies = mysql_query("SELECT * FROM hobbies where ID_CANDIDAT='$idcandi'");
while($hobbies2 = mysql_fetch_array($hobbies)){
?>     
 
 <p>
<?php    echo $hobbies2['NOM_HOBIE'] ?> 
  </p>
<?php  
}
?>







<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;copyrigth PMD-RK-AN</p>

</body>
</html>