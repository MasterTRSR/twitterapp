package org.lithium.twitter.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertyHelper {


    public static String getPropertyValue(String property, String filename){
        Properties prop = new Properties();
        InputStream input = null;
        String propertyValue = "";


        try {

            input = propertyHelper.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                return propertyValue;
            }

            prop.load(input);
            propertyValue = prop.getProperty(property);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }
}
