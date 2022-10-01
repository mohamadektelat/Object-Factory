//----------------------------------------------------------------------------------------------------------------------
package hac;
//----------------------------------------------------------------------------------------------------------------------
import java.net.URL;
//----------------------------------------------------------------------------------------------------------------------
/**
 * This class is a validator for URLs
 */
public class Validator {
    /**
     * This function is responsible for validating the URLs.
     * @param url
     * @return
     */
    public static void isValid(String url) throws Exception {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            throw new Exception("error");
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------