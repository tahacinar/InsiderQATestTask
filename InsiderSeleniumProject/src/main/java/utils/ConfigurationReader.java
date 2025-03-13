package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    // Yüklenecek yapılandırma dosyasının özelliklerini içeren Properties nesnesi oluşturulur
    private static Properties properties;

    // Statik blok: Sınıf yüklendiğinde yapılacak işlemler burada gerçekleştirilir
    static {
        try {
            // Yapılandırma dosyasının yolu belirlenir
            String path = "configuration.properties";
            // FileInputStream ile yapılandırma dosyası okunur
            FileInputStream input = new FileInputStream(path);
            // Properties nesnesi oluşturulur ve yapılandırma dosyasındaki bilgiler yüklenir
            properties = new Properties();
            properties.load(input);
            // Dosya okuma işlemi sonlandırılır
            input.close();
        } catch (Exception e) {
            // Dosya okuma sırasında bir hata oluşursa ekrana hata mesajı yazdırılır
            e.printStackTrace();
        }
    }

    // Verilen anahtara karşılık gelen değeri döndüren metot
    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
