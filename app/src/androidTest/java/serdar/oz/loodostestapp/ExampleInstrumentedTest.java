package serdar.oz.loodostestapp;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private final String data = "abbcccaaeeeeb bfffffca ccab";
    private List<Integer> repeatWeights = new ArrayList<>();

    @Test
    public void useAppContext() {
        createWeightList();
        assertEquals(replaceChars(2), "a***********b b*****ca **ab");
        assertEquals(replaceChars(3), "abb***aa****b b*****ca ccab");
        assertEquals(replaceChars(4), "abbcccaa****b b*****ca ccab");
        assertEquals(replaceChars(5), "abbcccaaeeeeb b*****ca ccab");
        assertEquals(replaceChars(9), "abbcccaaeeeeb bfffffca ccab");
    }


    private String replaceChars(int n) {
        /*Hangi indexte olduğumuzu bilmek için böyle bir değer tuttuk çünkü bu indexten şu indexe kadar * koy diyebilelim*/
        int currentIndex = 0;
        /*result değişkenine data değişkenini atıyoruz.Üzerinde oynadıktan sonra sıfırlanması gerektiği için*/
        String result = data;
        for (int i = 0; i < repeatWeights.size(); i++) {
            /*Kaydettiğimiz array içinde  dönüyoruz ve eğer methodda alınan n değeri arraydaki değere küçük eşitse bunu * ' la replace ediyoruz*/
            if (n <= repeatWeights.get(i)) {
                /*Burada bulunuduğumuz indexi , arrayin elemanları toplayarak bulduk.Daha sonra bulunduğumuz indexten
                başlayarak şu anki array elemanının size'ı kadar * sayısı yaptık.*/
                result = result.replace(data.substring(currentIndex, currentIndex + repeatWeights.get(i)), createStar(repeatWeights.get(i)));
            }
            /*Burada bulunduğumuz indexi güncelledik*/
            currentIndex = currentIndex + repeatWeights.get(i);
        }
        Log.e("replace", "replaceChars: " + result);
        return result;
    }


    private void createWeightList() {
        /*Öncelikle bir ağırlık arrayi oluşturup tüm tekrarların yan yana kaç kere tekrar ettiğini bir integer arrayda tutuyoruz.
        Aynı zamanda burda tek stringimiz olduğu için bu işlemi bir kere yapıp listeyi oluşturuyoruz*/

        /*Yan yana tekrar edenlerin sayısını bu değişkende tutacağız*/
        int weightValue = 0;
        for (int i = 0; i < data.length(); i++) {
            /*index out of hatası almamak için string lengthin değerinden büyük olmaması gerekir*/
            if (i != data.length() - 1) {
                if (data.charAt(i) == data.charAt(i + 1)) {
                    /*Eğer yanyana 2 değer aynı geliyosa  bu rakamı arttırıyoruz ama listeye eklemeden sonraki elemana geçiyoruz*/
                    weightValue++;
                } else {
                    weightValue++;
                    /*Eğer yanyana 2 değer aynı gelmiyosa  bu rakamı arttırıyoruz ve listeye ekleyip bir sonraki elemena geçiyoruz*/
                    repeatWeights.add(weightValue);
                    /*Ekledikten sonra yan yana olma değerini sıfırlıyoruz*/
                    weightValue = 0;
                }
            } else {
                /*Eğer burdaysak son elemandayızdır bunu da arraya ekliyoruz*/
                weightValue++;
                repeatWeights.add(weightValue);
            }
        }
        Log.e("Array", "createWeightList: " + repeatWeights.toString());
    }

    public static String createStar(int count) {
        /*Tekrar eden sayısı kadar * oluşturma işlemini burada yaptık*/
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < count; i++) {
            star.append("*");
        }
        return star.toString();
    }
}
