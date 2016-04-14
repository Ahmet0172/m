
<?php
extract($_POST); // Sayfaya Gelen post verileri okunuyor
$dosya = fopen("dosya.txt","w"); // dosya.txt kaydediliyor
fwrite($dosya, $text); // Gelen post verisi txt içerisine kaydediliyor
fclose($dosya); // Dosya kapandý
exec("java -jar JavaApplication36.jar", $output); // jar dosyasý çalýþtýrýyor sonuc $output dizisine atýlýyor
print_r($output); // Ekrana çýkýþ dizisi yazýlýyor
?>