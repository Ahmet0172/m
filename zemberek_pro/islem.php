<?php
header('Content-Type: text/html; charset=utf-8');
extract($_POST); // Sayfaya Gelen post verileri okunuyor


$dosya = fopen("dosya/kelimelist.json","w+"); // dosya.txt kaydediliyor
//$str = mb_convert_encoding($str, "SJIS");
/*$asc = array("Ü","ş","ğ","Ç","İ","Ö","ü","ş","ğ","ç","ı","ö");
$krt = array("�","�","�","�","�","�","�","�","�","�","�","�");
$text = str_replace($asc, $krt, $text);*/
//$text = mb_convert_encoding($text, "UTF-8");

$text = trim($text);
$pattern ='/[^\s\p{Ll}\p{Lm}\p{Lo}\p{Lt}\p{Lu}\p{Nd}]/mu';
$text=preg_replace($pattern,"",$text);
$txt = explode(" ", $text);

$son_txt = array("wordList"=>$txt);
$text = json_encode($son_txt);
//$duzeltilmis = unicode_decode($turkceKarekterli);  
//$text = unicode_decode($text);
fwrite($dosya, $text); // Gelen post verisi txt i�erisine kaydediliyor
fclose($dosya); // Dosya kapandy
exec("java -jar zemberek_pro.jar", $output); // jar dosyasy �aly?tyryyor sonuc $output dizisine atylyyor
echo "MucX";
//print_r($output); // Ekrana �yky? dizisi yazylyyor
?>