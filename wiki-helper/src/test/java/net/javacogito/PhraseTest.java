package net.javacogito;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class PhraseTest {
    private static final Logger LOGGER = Logger.getLogger(PhraseTest.class.getName());
    static {
        String log4jConfPath = FormatHelperTest.class.getClassLoader().getResource("log4j.properties").getPath();
        PropertyConfigurator.configure(log4jConfPath);
    }

    @Test
    public void isInTextTest(){
        Phrase phrase = new Phrase("ссылка на массив").addForm("ссылки на массив").addForm("Ссылка на массив");
        String inText = "…, ссылка на массив →\n" + "\n" + "…, длина массива\n";
        boolean result = phrase.isInText(inText);
        LOGGER.info("result = " + result);

    }
}
