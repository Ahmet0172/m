<?php
header('Content-Type: text/html; charset=utf-8');
extract($_POST); // Sayfaya Gelen post verileri okunuyor
//$dosya = fopen("dosya.txt","w"); // dosya.txt kaydediliyor
//$str = mb_convert_encoding($str, "SJIS");
/*$asc = array("ร","ล","ฤ","ร","ฤฐ","ร–","รผ","ล","ฤ","รง","ฤฑ","รถ");
$krt = array("Ü","Þ","ะ","ว","Ý","ึ","ü","þ","๐","็","ý","๖");
$text = str_replace($asc, $krt, $text);*/
//$text = mb_convert_encoding($text, "windows-1254");
//fwrite($dosya, $text); // Gelen post verisi txt i็erisine kaydediliyor
//fclose($dosya); // Dosya kapandy
exec("java -jar JavaApplication36.jar", $output); // jar dosyasy ็aly?tyryyor sonuc $output dizisine atylyyor
print_r($output); // Ekrana ็yky? dizisi yazylyyor
?>