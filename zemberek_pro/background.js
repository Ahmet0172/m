function ayikla(txt){
	$(document).ready(function(){ // jquery document başlatılıyor
		$.post("http://localhost/chorme/chorme/m/zemberek_pro/islem.php",{text:txt},function(sonuc,sc){ // belirtilen yola post olarak fonksiyon parametresi gönderiliyor sonuc degiskeninde sayfadan gelen sonucu alıyoruz
			alert(sonuc); // ekrana sonuc yazdırılıy
		});	
	});
}
var itemCopy = chrome.contextMenus.create({  // aktif sayfada yazı seçiliyken sağ tıklandığında menüye seçenek ekleme yapılıyor
  "title"     : "Ayıkla", // eklenen menü seçeneğinin adı
  "contexts"  : ["selection"], // ekleme yapılacağı zaman seçildiğinda
  "onclick"   : function veri(data) { // eğer bu seçenek seçilirse gerçekleşecek olay
  		ayikla(data.selectionText); // ayikla fonksiyonuna seçili veri gönderiliyor
  }
});
