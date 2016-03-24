function ayikla(txt){
	$(document).ready(function(){ // jquery document başlatılıyor
		$.post("http://localhost/chorme/chorme/m/zemberek_pro/islem.php",{text:txt},function(sonuc,sc){ // belirtilen yola post olarak fonksiyon parametresi gönderiliyor sonuc degiskeninde sayfadan gelen sonucu alıyoruz
			if(sc=="success"){
				/*$.getJSON( "dosya/analiz.json", function( data ) {
				  var items = [];
				  $.each( data, function( key, val ) {
				    items.push( "<li id='" + key + "'>" + val + "</li>" );
				  });
				 
				  $( "<ul/>", {
				    "class": "my-new-list",
				    html: items.join( "" )
				  }).appendTo( "body" );
				});*/
				//var itemUpdate = chrome.contextMenus.update({selectionText="ahmet"});
				alert(sonuc);
			}
		});	
	});
}

function upd(){
	//var itemUpdate = chrome.contextMenus.update({selectionText="ahmet"});
}



chrome.contextMenus.create({
  "title"     : "Ayıkla",
  "contexts"  : ["selection"],
  "onclick"   : function veri(data) { 
  		ayikla(data.selectionText); 
  }
});

