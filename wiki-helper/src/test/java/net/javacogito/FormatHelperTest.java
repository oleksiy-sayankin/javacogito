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


    @Test
    public void addFontCourierTagForClassFileStructureTest(){
        String source = "Значение элемента code_length задает число байт в массиве code для данного метода. Значение code_length должно быть больше нуля; массив code не должен быть пустым.";
        String expected = "Значение элемента <font face=Courier>code_length</font> задает число байт в массиве <font face=Courier>code</font> для данного метода. Значение <font face=Courier>code_length</font> должно быть больше нуля; массив <font face=Courier>code</font> не должен быть пустым.";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addFontCourierTagForClassFileStructureJvmCommandsTest(){
        String source = "Если версия class-файла 51.0 или выше, то коды инструкций jsr и jsr_w не должны присутствовать в массиве code.";
        String expected = "Если версия <font face=Courier>class</font>-файла 51.0 или выше, то коды инструкций jsr и jsr_w не должны присутствовать в массиве <font face=Courier>code</font>.";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeItalicJvmCommandsTest(){
        String source = "Если версия <font face=Courier>class</font>-файла 51.0 или выше, то коды инструкций jsr и jsr_w не должны присутствовать в массиве <font face=Courier>code</font>.";
        String expected = "Если версия <font face=Courier>class</font>-файла 51.0 или выше, то коды инструкций ''jsr'' и ''jsr_w'' не должны присутствовать в массиве <font face=Courier>code</font>.";
        String actual = FormatHelper.makeItalicJvmCommands(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFontCourierTagForSpecialWordsTest(){
        String source = "В частности, инициализирующий метод класса или интерфейса, имеющий имя <clinit> никогда не вызывается явно из инструкций виртуальной машины Java, а вызывается неявно только самой виртуальной машиной Java.";
        String expected = "В частности, инициализирующий метод класса или интерфейса, имеющий имя <font face=Courier><clinit></font> никогда не вызывается явно из инструкций виртуальной машины Java, а вызывается неявно только самой виртуальной машиной Java.";
        String actual = FormatHelper.addFontCourierTagForSpecialWords(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addFontCourierTagForUnicodeTest(){
        String source = "Никакой другой метод, начинающийся с символа «<» («\\u003c») не может быть вызван инструкцией вызова метода непосредственно.";
        String expected = "Никакой другой метод, начинающийся с символа «<» («<font face=Courier>\\u003c</font>») не может быть вызван инструкцией вызова метода непосредственно.";
        String actual = FormatHelper.addFontCourierTagForUnicode(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFontCourierTagForClassFileStructureAllKeyWordsTest(){
        String source = "Операнды инструкций instanceof,  checkcast, new и  anewarray и операнды indexbyte каждой инструкции multianewarray должны представлять собой действительный индекс в таблице constant_pool. Элемент константного пула по этому индексу должен иметь тип CONSTANT_Class.";
        String expected = "Операнды инструкций instanceof,  checkcast, new и  anewarray и операнды <font face=Courier>indexbyte</font> каждой инструкции multianewarray должны представлять собой действительный индекс в таблице <font face=Courier>constant_pool</font>. Элемент константного пула по этому индексу должен иметь тип <font face=Courier>CONSTANT_Class</font>.";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFontCourierTagForClassFileLowDashTest(){
        String source = "Операнд atype каждой инструкции newarray должен принимать одно из значений T_BOOLEAN(4),  T_CHAR(5),  T_FLOAT(6),  T_DOUBLE(7),  T_BYTE(8),  T_SHORT(9), T_INT(10) либо T_LONG(11).";
        String expected = "Операнд <font face=Courier>atype</font> каждой инструкции newarray должен принимать одно из значений <font face=Courier>T_BOOLEAN</font>(4),  <font face=Courier>T_CHAR</font>(5),  <font face=Courier>T_FLOAT</font>(6),  <font face=Courier>T_DOUBLE</font>(7),  <font face=Courier>T_BYTE</font>(8),  <font face=Courier>T_SHORT</font>(9), <font face=Courier>T_INT</font>(10) либо <font face=Courier>T_LONG</font>(11).";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void makeItalicGenericJvmCommandsTest(){
        String source = "Неявный индекс каждой из инструкций iload_<n>,  fload_<n>,  aload_<n>,  istore_<n>, fstore_<n> и  astore_<n> должен быть числом не превосходящим max_locals - 1.";
        String expected = "Неявный индекс каждой из инструкций ''iload_<n>'',  ''fload_<n>'',  ''aload_<n>'',  ''istore_<n>'', ''fstore_<n>'' и  ''astore_<n>'' должен быть числом не превосходящим max_locals - 1.";
        String actual = FormatHelper.makeItalicGenericJvmCommands(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addFontCourierTagForClassGenericJvmCommandsTest(){
        String source = "Неявный индекс каждой из инструкций iload_<n>,  fload_<n>,  aload_<n>,  istore_<n>, fstore_<n> и  astore_<n> должен быть числом не превосходящим max_locals - 1.";
        String expected = "Неявный индекс каждой из инструкций iload_<n>,  fload_<n>,  aload_<n>,  istore_<n>, fstore_<n> и  astore_<n> должен быть числом не превосходящим <font face=Courier>max_locals</font> - 1.";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFontCourierTagForSpecialWordsInitTest(){
        String source = "унаследованных от типа this и аргументов, а также соответствующего флага, зависящего от того является ли данны метод <init> методом или нет.";
        String expected = "унаследованных от типа <font face=Courier>this</font> и аргументов, а также соответствующего флага, зависящего от того является ли данны метод <init> методом или нет.";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeItalicAlwaysItalicWordsTest(){
        String source = "инициализирующий загрузчик класса или интерфейса (от англ. initiating loader – прим. перев.).";
        String expected = "инициализирующий загрузчик класса или интерфейса (от англ. initiating loader – ''прим. перев.'').";
        String actual = FormatHelper.makeItalicAlwaysItalicWords(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void formatClassLoaderNamesTest(){
        String source = "говорят, что L инициирует загрузку C или, что эквивалентно, L – это инициирующий загрузчик C";
        String expected = "говорят, что <font face=Courier>''L''</font> инициирует загрузку <font face=Courier>''C''</font> или, что эквивалентно, <font face=Courier>''L''</font> – это инициирующий загрузчик <font face=Courier>''C''</font>";
        String actual = FormatHelper.formatForceCourierItalic(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void addFontCourierTagForClassFileStructureComplexBracketsTest(){
        String source = "Иногда мы будем обозначать класс или интерфейс с помощью нотации <N, Ld >, где N – это имя класса или интерфейса, а Ld – определяющий загрузчик";
        String expected = "Иногда мы будем обозначать класс или интерфейс с помощью нотации <N, <font face=Courier>Ld</font> >, где N – это имя класса или интерфейса, а <font face=Courier>Ld</font> – определяющий загрузчик";
        String actual = FormatHelper.addFontCourierTagForClassFileStructure(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void formatSubSupIndexesTest(){
        String source = "В противном случае пусть <E,  L1> - это класс или интерфейс,  содержащий метод m, на который ссылается D и пусть L2 будет определяющим загрузчиком для D.";
        String expected = "В противном случае пусть <E,  <font face=Courier>''L<sub>1</sub>''</font>> - это класс или интерфейс,  содержащий метод m, на который ссылается D и пусть <font face=Courier>''L<sub>2</sub>''</font> будет определяющим загрузчиком для D.";
        String actual = FormatHelper.formatSubSupIndexes(source);
        LOGGER.info("actual = " + actual);
        Assert.assertEquals(expected, actual);
    }


}
