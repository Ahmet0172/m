<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title></title>
	<script type="text/javascript" src="jquery-1.12.1.min.js"></script>
	<script type="text/javascript">
	var str = "Mr Blue birlikte a blue house and a blue car";
var res;= //str.replace(/birlikte/g, "red"); 
		$(document).ready(function(){
			$.getJSON("http://localhost/chorme/chorme/m/zemberek_pro/sonuc.php", function(json) {
				for (var i = 0; i < json.length; i++){
					res = str.replace(json[i],'rep#'+json[i]+'#rep');
				}
			});
		});
	</script>
</head>
<body>
<div class="bck"></div>
</body>
</html>
