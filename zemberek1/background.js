function ayikla(txt){
	$(document).ready(function(){
		$.post("http://localhost/chorme/chorme/zemberek/islem.php",{text:txt},function(sonuc,sc){
			alert(sonuc);
		});	
	});
}
var itemCopy = chrome.contextMenus.create({
  "title"     : "Ayıkla",
  "contexts"  : ["selection"],
  "onclick"   : function veri(data) {
  		ayikla(data.selectionText);
  }
});
