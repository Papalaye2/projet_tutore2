
<?php
require('fpdf.php');
$base = mysql_connect ('127.0.0.1', 'root', '');  
 mysql_select_db ('institut2', $base) ; 
$pdf = new FPDF();
$pdf->AddPage();





$pdf->SetFont('Arial', 'B', 17);
$pdf->Cell(70, 8, '', 0);
$pdf->Cell(100, 8, 'CURRICULUM VITAE', 0);


$pdf->Ln(13);

$candidat = mysql_query("SELECT * FROM candidat where ID_CANDIDAT=1");
$item = 0;
$totaluni = 0;
$totaldis = 0;
while($candidat2 = mysql_fetch_array($candidat)){
    $pdf->SetFont('Arial', 'B', 12);
	$pdf->Cell(15, 8,$candidat2['NOM_CANDIDAT'], 0);
	$pdf->Cell(45, 8, $candidat2['PRENOM_CANDIDAT'], 0);
        $pdf->SetFont('Arial', '', 8);
        $pdf->Ln(5);
	$pdf->Cell(15, 10,$candidat2['ADRESSE_CANDIDAT'], 0);
        $pdf->Ln(4);
	$pdf->Cell(15, 12,$candidat2['TELEPHONE_CANDIDAT'], 0);
        $pdf->Ln(4);
        $pdf->Cell(15, 14,$candidat2['Email_candidat'], 0);
	
	$pdf->Ln(12);
}


$pdf->SetFont('Arial', 'B', 12);
$pdf->Cell(180, 8, 'PROFIL DU CV', 1);
$pdf->Ln(8);
$pdf->SetFont('Arial', '', 8);
$detaipro = mysql_query("SELECT * FROM detail_pro where id_candit=1");
while($detaipro2 = mysql_fetch_array($detaipro)){
	
	$pdf->Cell(15, 8,$detaipro2['desc_dp'], 0);
        $pdf->Ln(12);
}




$pdf->SetFont('Arial', 'B', 12);
$pdf->Cell(180, 8, 'FORMATION', 1);
$pdf->Ln(8);
$pdf->SetFont('Arial', '', 8);
$educatiobn = mysql_query("SELECT * FROM educatiobn where ID_CANDIDAT=1");
while($educatiobn2 = mysql_fetch_array($educatiobn)){
	$pdf->Cell(15, 8,$educatiobn2['ANNE_EDU'], 0);
	$pdf->Cell(45, 8, $educatiobn2['INTITULECEDU'], 0);
        $pdf->Ln(4);
        $pdf->Cell(15, 8, '', 0);
	$pdf->Cell(45, 10,$educatiobn2['ETABLISEMENT_EDU'], 0);
       
	
	$pdf->Ln(12);
}


$pdf->SetFont('Arial', 'B', 12);
$pdf->Cell(180, 8, 'EXPERIANCE PRIFESIONNELLE', 1);
$pdf->Ln(8);
$pdf->SetFont('Arial', '', 8);
$work_expe = mysql_query("SELECT * FROM work_expe where ID_CANDIDAT=1");
while($work_expe2 = mysql_fetch_array($work_expe)){
	$pdf->Cell(45, 8,$work_expe2['ANNE_WORK'], 0);
	$pdf->Cell(45, 8, $work_expe2['DECRIPTION_WORK'], 0);
        $pdf->Ln(4);
        $pdf->Cell(45, 8, '', 0);
	$pdf->Cell(45, 10,$work_expe2['LIEU_WORK'], 0);
       
	
	$pdf->Ln(12);
}



$pdf->SetFont('Arial', 'B', 12);
$pdf->Cell(180, 8, 'LANGUES', 1);
$pdf->Ln(8);
$pdf->SetFont('Arial', '', 8);
$langue = mysql_query("SELECT * FROM langue where ID_CANDIDAT=1");
while($langue2 = mysql_fetch_array($langue)){
	
	$pdf->Cell(12, 8,$langue2['NOM_LANGUE'], 0);
        $pdf->Cell(15, 8,$langue2['NIVEAU_LANGUE'], 0);
        $pdf->Ln(6);
}


$pdf->SetFont('Arial', 'B', 12);
$pdf->Cell(180, 8, 'PASSION/HOBBIES', 1);
$pdf->Ln(8);
$pdf->SetFont('Arial', '', 8);
$hobbies = mysql_query("SELECT * FROM hobbies where ID_CANDIDAT=1");
while($hobbies2 = mysql_fetch_array($hobbies)){
	
	$pdf->Cell(12, 8,$hobbies2['NOM_HOBIE'], 0);
       
        $pdf->Ln(6);
}


 $pdf->Ln(40);

$pdf->Cell(160, 8, '', 0);
$pdf->Cell(18, 8, ' copyrigth PMD-RK-AN', 0);







$pdf->Output();
?>
