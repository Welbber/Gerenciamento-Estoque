package utiuls;

import lombok.Cleanup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesProperties {

    private static QueriesProperties instance;

    private final Properties properties;

    public QueriesProperties() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("resources/Queries.xml").getFile());

            @Cleanup
            FileInputStream fileInput = new FileInputStream(file);

            properties = new Properties();
            properties.loadFromXML(fileInput);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar capturar a arquivo de propriedade.");
        }
    }

    private static QueriesProperties getInstance() {
        if (instance == null)
            instance = new QueriesProperties();

        return instance;
    }

    public static String getString(String key) {
        return getInstance().properties.getProperty(key);
    }
}