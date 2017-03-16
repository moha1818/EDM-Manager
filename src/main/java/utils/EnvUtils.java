package utils;

import org.springframework.core.io.support.PropertiesLoaderSupport;

import java.io.IOException;
import java.util.Properties;

public class EnvUtils extends PropertiesLoaderSupport {
    private static Properties properties;

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public void init() throws IOException {
        try {
            if(properties == null){//第一次
                properties = super.mergeProperties();
            } else {//多次合并
                properties.putAll(super.mergeProperties());
            }
        } catch (IOException e) {
            throw new IOException("load properties error");
        }
    }
}
