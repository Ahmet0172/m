/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zemberek_pro;
import net.zemberek.erisim.Zemberek;
import net.zemberek.*;
import net.zemberek.islemler.cozumleme.CozumlemeSeviyesi;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import java.io.FileReader;
import java.io.IOException;
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
        Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
        Object obj = parser.parse(new FileReader("mucx.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String name = (String) jsonObject.get("name");
        String author = (String) jsonObject.get("author");
        JSONArray companyList = (JSONArray) jsonObject.get("Company List");
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("\nCompany List:");
        Iterator<String> iterator = companyList.iterator();
        while (iterator.hasNext()) {
          System.out.println(iterator.next());
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
