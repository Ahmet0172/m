﻿<?php 
	$json_full = file_get_contents("dosya/analiz.json");
	$analiz = json_decode($json_full,true);
	$frekanslar = array_column($analiz["Kelimeler"], 'frekans');
	$kelimeler = array_column($analiz["Kelimeler"], 'kelime');
	arsort($frekanslar);
	//print_r($frekanslar);
	$max_fre = array();
	$max_key = array();
	$i = 0;
	
	foreach ($frekanslar as $key => $value) {
		//$max_fre[] = $kelimeler[$key];
		$snc.=$kelimeler[$key]."|";
		$i++;
		
		if($i==5)
			break;
	}
	$snc = substr($snc,0,-1);
	//$js = json_encode($max_fre);
	//echo $js;
	echo $snc;
?>