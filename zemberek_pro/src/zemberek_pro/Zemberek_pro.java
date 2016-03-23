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
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
        JSONParser parser = new JSONParser();
        JSONObject kelimelerFull = new JSONObject(); // Frekans ve bilgiler burada olacak
        JSONObject koklerFull = new JSONObject(); // Frekans ve bilgiler burada olacak
        Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
        Object obj = parser.parse(new FileReader("dosya/mucx.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray wordList = (JSONArray) jsonObject.get("wordList"); 
        String[] stopWords= {"acaba","altmış","altı","ama","bana","bazı","belki","ben","benden","beni","benim","beş","bin","bir","biri","birkaç","birkez","birşey","birşeyi","biz","bizden","bizi","bizim","bu","buna","bunda","bundan","bunu","bunun","da","daha","dahi","de","defa","diye","doksan","dokuz","dört","elli","en","gibi","hem","hep","hepsi","her","hiç","iki","ile","ise","için","katrilyon","kez","ki","kim","kimden","kime","kimi","kırk","milyar","milyon","mu","mü","mı","nasıl","ne","neden","nerde","nerede","nereye","niye","niçin","on","ona","ondan","onlar","onlardan","onlari","onların","onu","otuz","sanki","sekiz","seksen","sen","senden","seni","senin","siz","sizden","sizi","sizin","trilyon","tüm","ve","veya","ya","yani","yedi","yetmiş","yirmi","yüz","çok","çünkü","üç","şey","şeyden","şeyi","şeyler","şu","şuna","şunda","şundan","şunu"};
        String[] kokler = null;
        String[] kelimeFrekans = null;
        Iterator<String> iterator = wordList.iterator();
        String kok,tip;
        int i = 0;
        while (iterator.hasNext()) {
              byte[] utf8Bytes = iterator.next().getBytes("UTF-8");
              String kelime = new String(utf8Bytes, "UTF-8");
            if(zemberek.kelimeDenetle(kelime)){ // Hatalı Kelimeler Ayrıştırılıyor
             if(!Arrays.asList(stopWords).contains(kelime.toLowerCase())){ // Stop Word İse Kelime Gözardı Ediliyor
                    Kelime[] cozumler = zemberek.kelimeCozumle(kelime);
                    if(cozumler[0].kok().tip().toString()=="ISIM"){ // Kelime Eger isim tipindeyse
                        System.out.print(kelime+"=>");
                        int freq = Collections.frequency(wordList, kelime);
                        //kelimeFrekans[i] = {"frekans"=>freq,"kelime"=kelime};
                        //System.out.println("Frekans : "+freq);
                        //System.out.print(cozumler[0].kok().tip()); // Kök Tip
                        //System.out.print(cozumler[0].kok().icerik()); // Kök İçerik
                        kokler[i] = cozumler[0].kok().icerik();
                        i++;
                    }
                 /*
                  System.out.println(cozumler[0].kok().icerik());
                  for (Kelime kelime : cozumler)
                    System.out.println(kelime);
                 */
             }  
            }  
              //StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"})  = "wcte"
          /*Kelime[] cozumler = zemberek.kelimeCozumle(kelime);
            System.out.print(kelime+"=>");
        for (Kelime kelime : cozumler)
            System.out.println(kelime);*/
        }
            
            
       /*  Kelime[] cozumler = zemberek.kelimeCozumle("Kal");
        System.out.println("cozumlemeler:");
        for (Kelime kelime : cozumler)
            System.out.println(kelime);

      
          List<String[]> ayrisimlar = zemberek.kelimeAyristir("Geliyorum");
        for (String[] strings : ayrisimlar)
            System.out.println(Arrays.toString(strings));
        */
        /*if(!zemberek.kelimeDenetle("merhavas")){
            System.out.println("hatalı" );
            System.exit(1);
            }else{
             System.out.println("zemberek_pro.Zemberek_pro.main()");
         }*/
    
    }
}
