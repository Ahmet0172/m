<?php
header('Content-Type: text/html; charset=utf-8');
extract($_POST); // Sayfaya Gelen post verileri okunuyor
//$dosya = fopen("dosya.txt","w"); // dosya.txt kaydediliyor
//$str = mb_convert_encoding($str, "SJIS");
/*$asc = array("Ü","ş","ğ","Ç","İ","Ö","ü","ş","ğ","ç","ı","ö");
$krt = array("�","�","�","�","�","�","�","�","�","�","�","�");
$text = str_replace($asc, $krt, $text);*/
//$text = mb_convert_encoding($text, "windows-1254");
//fwrite($dosya, $text); // Gelen post verisi txt i�erisine kaydediliyor
//fclose($dosya); // Dosya kapandy
exec("java -jar JavaApplication36.jar", $output); // jar dosyasy �aly?tyryyor sonuc $output dizisine atylyyor
print_r($output); // Ekrana �yky? dizisi yazylyyor
?>