//----------------------------------------------------------------------------------------------------------------------
package hac;
//----------------------------------------------------------------------------------------------------------------------
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import static hac.Validator.isValid;
//----------------------------------------------------------------------------------------------------------------------

/**
 * The controller class in our program.
 */
public class Main {
    /**
     * This is the main function of the program.
     * @param args
     */
    public static void main(String[] args) {
        try {
            if (args.length != 3)
                throw new Exception("invalid command");
            isValid(args[1]);
            Document doc = Jsoup.connect(args[1]).get();
            ObjectFactory objectFactory = new ObjectFactory();

            objectFactory.register(ObjectType.A, A::new);
            objectFactory.register(ObjectType.H, H::new);
            objectFactory.register(ObjectType.I, I::new);

            char[] types = args[0].toCharArray();

            FileOutputStream outFile = new FileOutputStream(args[2], true);
            for (char type : types) {
                Object object = null;
                if (type == 'a')
                    object = objectFactory.getObject(ObjectType.A);

                else if (type == 'i')
                    object = objectFactory.getObject(ObjectType.I);

                else if (type == 'h')
                    object = objectFactory.getObject(ObjectType.H);
                else if (type == '-')
                    continue;
                else
                    throw new Exception("invalid command");
                object.getData(doc, outFile);
            }
            outFile.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------