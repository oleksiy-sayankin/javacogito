package net.javacogito;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.apache.log4j.Logger;

public class FormatHelperTest {
    private static final Logger LOGGER = Logger.getLogger(FormatHelperTest.class.getName());
    static {
        String log4jConfPath = FormatHelperTest.class.getClassLoader().getResource("log4j.properties").getPath();
        PropertyConfigurator.configure(log4jConfPath);
    }

    @Test
    public void addCodeTagForClassFileStructureTestSimple(){
        String source = "Элементы структуры Code_attribute следующие:";
        String expected = "Элементы структуры <code>Code_attribute</code> следующие:";
        String actual = FormatHelper.addCodeTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addCodeTagForClassFileStructureTestComplex(){
        String source = "Значение элемента code_length задает число байт в массиве code для данного метода. Значение code_length должно быть больше нуля; массив code не должен быть пустым.";
        String expected = "Значение элемента <code>code_length</code> задает число байт в массиве <code>code</code> для данного метода. Значение <code>code_length</code> должно быть больше нуля; массив <code>code</code> не должен быть пустым.";
        String actual = FormatHelper.addCodeTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void addCodeTagForClassFileStructureTestBrackets(){
        String source = "Считается ошибкой, если для произвольного индекса i, элемент stack[i] содержит элемент стека, чей индекс больше чем максимальное число элементов в стеке операндов.";
        String expected = "Считается ошибкой, если для произвольного индекса i, элемент <code>stack[i]</code> содержит элемент стека, чей индекс больше чем максимальное число элементов в стеке операндов.";
        String actual = FormatHelper.addCodeTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceCodeTagWithFontTagTest(){
        String source = "имеющих расширение <code>class</code>. Эти файлы содержат инструкции";
        String expected = "имеющих расширение <font face=Courier>class</font>. Эти файлы содержат инструкции";
        String actual = FormatHelper.replaceCodeTagWithFontTag(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }



}
