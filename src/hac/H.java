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
 * This class is responsible for the "h" input.
 */
public class H implements Object{
    /**
     * This function responsible to write the text from the headers to the Out File.
     * @param doc
     * @param outFile
     */
    @Override
    public void getData(Document doc , FileOutputStream outFile) throws Exception {
        try {
            Elements elements = doc.select("h1");
            byte[] b = null;
            for(Element element : elements){
                b= (element.text()+"\n").getBytes() ;       //converts string into bytes
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