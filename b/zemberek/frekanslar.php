
<?php

$user = "root"; 
$pwd = "";
$host = "localhost";
$db = "sozcukler"; //veritabanı adı

error_reporting(0);
$conn = mysql_connect($host,$user,$pwd) or die("MySQL sunucusuna baglanilamadi!!!".mysql_error());

    mysql_select_db("zemberek");  
    
    mysql_query("SET CHARACTER SET UTF-8");  
mysql_select_db($db) or die("Veritabani secilemedi!!!".mysql_error());
$sonuc = mysql_query("SELECT kokler.kokisim,COUNT(kokler.kokisim) FROM kokler group by kokler.kokisim ORDER BY (COUNT(kokler.kokisim) ) desc limit 5");

if(mysql_num_rows($sonuc)!=0)
{
    while($oku = mysql_fetch_assoc($sonuc))
    {
        $kelimeler=$kelimeler.$oku["kokisim"];
        $kelimeler=$kelimeler."|";
        //echo $.oku["yazari"]; //bu satir hatalidir cunku sql sorgumuzda yazari alanini secmedik
    }
}else{
    echo "Hic kayit yok!";
}
$kelimeler = substr($kelimeler,0,-1);
echo $kelimeler;

mysql_close($conn);

?>