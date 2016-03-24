<?php 
	$json_full = file_get_contents("dosya/analiz.json");
	$analiz = json_decode($json_full,true);
	$frekanslar = array_column($analiz["Kelimeler"], 'frekans');
	$kelimeler = array_column($analiz["Kelimeler"], 'kelime');
	arsort($frekanslar);
	print_r($frekanslar);
	$max_fre = array();
	$max_key = array();
	$i = 0;
	foreach ($frekanslar as $key => $value) {
		$max_fre[] = $kelimeler[$key];
		$i++;
		if($i==5)
			break;
	}
	echo "<br>";	
	print_r($max_fre);
?>