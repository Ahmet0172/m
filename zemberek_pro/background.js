yuklen();
function yuklen(){
	$(document).ready(function(){
			$.post("http://localhost/m/zemberek_pro/sonuc.php",{},function(json,sc) {
				if(sc=="success"){
					ara(document.body,json);
					reklendir(json);
				}
			});
		});

}


function reklendir(json){
				
			var njs = json.split("|");
			for(var i = 0;i<njs.length;i++){
				var d = njs[i];
				document.body.innerHTML = document.body.innerHTML.replace(RegExp("rep#"+d+"#rep","gi"),'<font style="background:#c6ff00; color:#000;"><b>'+d+'</b></font>');

			//	v = v.replace(d,function myFunction(x){return x = "rep#"+x+"#rep";});
			}	
}
function ara(node,json)  
{
	var child, next;
	switch (node.nodeType)  
	{
		case 1: 
		case 9:  
		case 11: 
			child = node.firstChild;
			while (child) 
			{
				next = child.nextSibling; 
				ara(child,json);
				child = next;
			}
			break;
		case 3: 
			degistir(node,json);
		break;
	}
}
function degistir(textNode,json) 
{
	var v = textNode.nodeValue;
//	v = v.replace(/\bmadde\b/g,'<span>madde</span>');
		
		/**/
			//json = "/müzik/gi"; 
				//console.log(json);
			/*var njs = json.split("|");
			var i = 0;
			for(i = 0;i<njs.length;i++){
				var d =njs[i];*/
				v = v.replace(RegExp(json,"gi"),function myFunction(x){return x = "rep#"+x+"#rep";});
			//}		
		//console.log(pps);
		
 	// v.replaceWith(v.replace(/\bmadde\b/g,'<a href="http://google.com">Google</a>'));

	/*
	*/
	/*
matchText(document.getElementsByTagName("article")[0], new RegExp("\\b" + searchTerm + "\\b", "g"), function(node, match, offset) {
    var span = document.createElement("span");
    span.className = "search-term";
    span.textContent = match;
    node.parentNode.insertBefore(span, node.nextSibling); 
});
	*/
	//v = v.innerTEXT.replace(/\bmadde\b/g,'<span class="f">aaaaaaaaa</span>');
	/*if(v.indexOf("madde") != -1){
		v.innerHTML = '<span class="f">aaaa</span>';
	}*/
	//v = v.replace(/\bmadde\b/g, '<span class="f">aaaa</span>');
	//v.innerHTML = v.innerHTML.replace(/\bmadde\b/g,'<span class="f">aaaa</span>');
	//v.innerHTML = v.innerHTML.replace(/\bmadde\b/g, '#');
	/*
element.innerHTML = element.innerHTML.replace(
  /btestw*b/gi,
  '<span class="f">$0</span>'
);

	*/
//	v.innerHTML = v.innerHTML.replace(/\bmadde\b/g, 'ahnet');
	textNode.nodeValue = v;
}

function ayikla(txt){
	$(document).ready(function(){
		$.post("http://localhost/m/zemberek_pro/islem.php",{text:txt},function(sonuc,sc){
			if(sc=="success"){
				chrome.tabs.getSelected(null, function(tab) {
				  var code = 'window.location.reload();';
				  chrome.tabs.executeScript(tab.id, {code: code});
				});
			}
		});	
	});
}


chrome.contextMenus.create({
  "title"     : "Ayıkla",
  "contexts"  : ["selection"],
  "onclick"   : function veri(data) { 
  		ayikla(data.selectionText); 
  		//upd(data);
  }
});

