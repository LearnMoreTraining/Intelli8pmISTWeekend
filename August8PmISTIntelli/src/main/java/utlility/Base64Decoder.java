package utlility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Base64Decoder {

    public static String getDecodeValue(String key){
        File f = new File("src/main/resources/configuration/frameworkconfig.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Base64.Decoder decoder = Base64.getDecoder();
      return new String( decoder.decode(properties.getProperty(key).getBytes()));

    }
}
