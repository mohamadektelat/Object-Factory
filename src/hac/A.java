//----------------------------------------------------------------------------------------------------------------------
package hac;
//----------------------------------------------------------------------------------------------------------------------
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
//----------------------------------------------------------------------------------------------------------------------

/**
 * This class is responsible for the "a" input.
 */
public class A implements Object{
    /**
     * This function responsible to write the links from the html page to the Out File.
     * @param doc
     * @param outFile
     */
    @Override
    public void getData(Document doc , FileOutputStream outFile) throws Exception {
        try {
            Elements elements = doc.select("a");
            byte[] b = null;
            for(Element element : elements){
                b= (element.attr("abs:href")+"\n").getBytes() ;       //converts string into bytes
                outFile.write(b);
            }
            b=("\n").getBytes();
            outFile.write(b);
        } catch (IOException e) {
            throw new Exception("error");
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------