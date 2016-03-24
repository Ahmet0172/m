/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zemberek_pro;
import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Piston
 */
public class Zemberek_pro {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser oku_list       = new JSONParser();
        JSONObject WordFullList = new JSONObject(); // Frekans ve bilgiler burada olacak
        Zemberek zemberek       = new Zemberek(new TurkiyeTurkcesi());
        Object obj              = oku_list.parse(new FileReader("dosya/kelimelist.json"));
        JSONObject jsonObject   = (JSONObject) obj;
        JSONArray wordList      = (JSONArray) jsonObject.get("wordList"); 
        String[] stopWords      = {"acaba","altmış","altı","ama","bana","bazı","belki","ben","benden","beni","benim","beş","bin","bir","biri","birkaç","birkez","birşey","birşeyi","biz","bizden","bizi","bizim","bu","buna","bunda","bundan","bunu","bunun","da","daha","dahi","de","defa","diye","doksan","dokuz","dört","elli","en","gibi","hem","hep","hepsi","her","hiç","iki","ile","ise","için","katrilyon","kez","ki","kim","kimden","kime","kimi","kırk","milyar","milyon","mu","mü","mı","nasıl","ne","neden","nerde","nerede","nereye","niye","niçin","on","ona","ondan","onlar","onlardan","onlari","onların","onu","otuz","sanki","sekiz","seksen","sen","senden","seni","senin","siz","sizden","sizi","sizin","trilyon","tüm","ve","veya","ya","yani","yedi","yetmiş","yirmi","yüz","çok","çünkü","üç","şey","şeyden","şeyi","şeyler","şu","şuna","şunda","şundan","şunu"};
        List koklerArray        = new ArrayList();
        List kelimelerArray     = new ArrayList();

        Iterator<String> iterator = wordList.iterator();
        String kok,tip;
        int i = 0,j=0;
        while (iterator.hasNext()) {
              byte[] utf8Bytes = iterator.next().getBytes("UTF-8");
              String kelime = new String(utf8Bytes, "UTF-8");
            if(zemberek.kelimeDenetle(kelime)){ // Hatalı Kelimeler Ayrıştırılıyor
             if(!Arrays.asList(stopWords).contains(kelime.toLowerCase())){ // Stop Word İse Kelime Gözardı Ediliyor
                    Kelime[] cozumler = zemberek.kelimeCozumle(kelime);
                    if(cozumler[0].kok().tip().toString()=="ISIM"){ // Kelime Eger isim tipindeyse
                        koklerArray.add(cozumler[0].kok().icerik());
                        kelimelerArray.add(kelime);
                       }
             }  
            }  
        }
      JSONArray kelimelerJson = new JSONArray();
      JSONArray koklerJson = new JSONArray();
      List exKelimeler     = new ArrayList();
      List exKok     = new ArrayList();
      for(Object object : kelimelerArray) {
           if(Collections.frequency(exKelimeler,object.toString())==0){
              JSONObject detayKelime = new JSONObject();
               detayKelime.put("kelime",kelimelerArray.get(i).toString());
               detayKelime.put("frekans",Collections.frequency(kelimelerArray, kelimelerArray.get(i).toString()));
               kelimelerJson.add(detayKelime);
               exKelimeler.add(kelimelerArray.get(i).toString());   
           }      
           if(Collections.frequency(exKok,koklerArray.get(i).toString())==0){
               JSONObject detayKok = new JSONObject();
               detayKok.put("kok",koklerArray.get(i).toString());
               detayKok.put("frekans",Collections.frequency(koklerArray, koklerArray.get(i).toString()));
               koklerJson.add(detayKok);
              exKok.add(koklerArray.get(i).toString());
         }
           i++; 
      }
      WordFullList.put("Kelimeler",kelimelerJson);
      WordFullList.put("Kokler",koklerJson);
      FileWriter file = new FileWriter("dosya/analiz.json");
      file.write(WordFullList.toJSONString());
      file.flush();
      file.close();
    }
}
