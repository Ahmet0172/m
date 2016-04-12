ara(document.body);
reklendir();
function reklendir(){
		$(document).ready(function(){
			$.post("http://localhost/chorme/chorme/m/zemberek_pro/sonuc.php", function(json) {
				var jjs = $.parseJSON(json);
				for (var i = 0; i < jjs.length; i++){
					v = v.replace(/\bjjs[i]\b/g,'rep#'+jjs[i]+'#rep');
				}
			});
		});
}
function ara(node)  
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
				ara(child);
				child = next;
			}
			break;
		case 3: 
			degistir(node);
		break;
	}
}
//document.body.innerHTML = document.body.innerHTML.replace(/\bmadde\b/g, '<span class="f">aaaaaaaaa</span>');
function degistir(textNode) 
{
	var v = textNode.nodeValue;

	//v = v.replace(/\bmadde\b/g,'rep#NOB#rep');
			$(document).ready(function(){
			$.post("http://localhost/chorme/chorme/m/zemberek_pro/sonuc.php", function(json) {
				var jjs = $.parseJSON(json);
				for (var i = 0; i < jjs.length; i++){
					v = v.replace(/\bjjs[i]\b/g,'rep#'+jjs[i]+'#rep');
				}
			});
		});
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
		$.post("http://localhost/chorme/chorme/m/zemberek_pro/islem.php",{text:txt},function(sonuc,sc){
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

