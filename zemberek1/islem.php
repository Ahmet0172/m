<?php
require_once "db.php";

extract($_POST);

$dosya = fopen($path."txt.txt","w+");
fwrite($dosya, $text);
fclose($dosya);

echo "Yaz Beni Ekrana";
?>