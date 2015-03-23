package net.javacogito;

public class Main {
    private static String inPlainText = "Выполнение инструкций передачи управления (условных или безусловных) приводит к тому, что виртуальная машина Java продолжает выполнение операции отличной от той, которая следует непосредственно после инструкции передачи управления. Доступны следующие операции:\n" +
            "Условный переход: ifeq,  ifne,  iflt,  ifle,  ifgt,  ifge,  ifnull,  ifnonnull,  if_icmpeq, if_icmpne, if_icmplt, if_icmple, if_icmpgt, if_icmpge, if_acmpeq, if_acmpne. \n" +
            "Составные операторы условного перехода: tableswitch, lookupswitch.\n" +
            "Операторы безусловного перехода: goto, goto_w, jsr, jsr_w, ret.\n" +
            "\n" +
            "Виртуальная машина Java имеет различные наборы инструкций условного перехода для работы с типами данных int и reference. Также виртуальная машина наборы инструкций условного перехода для проверки нулевых ссылок, поэтому нет требований, чтобы null значение было строго определённым: его можно выбрать произвольно.\n" +
            "Инструкции условного перехода, использующие для сравнения данные с типами boolean,  byte, char и  short, выполняются с помощью инструкций, работающих с типом int (см. §2.11.1). Вместо инструкций условного перехода сравнивающих значения с типами данных long, float, или double выполняется следующее: используется команда сравнения двух чисел с типами данных long, float или double; результат сравнения в виде значения с типом int помещается в стек операндов.  Затем переход для перехода используется инструкция, работающая с типом int. Из-за активного использования сравнений с типом данных int виртуальная машина Java имеет расширенной набор инструкций условного перехода, использующих для сравнения данные с типом int.\n" +
            "Все инструкций условного перехода, использующих для сравнения данные с типом int, выполняют знаковое сравнение.";

    public static void main( String[] args )
    {
        System.out.println( makeCodeTagForJavaKeywords(makeItalicJvmCommands(inPlainText)));
    }

    private static String makeItalicJvmCommands(String inText){
        String outText = inText;
        for (String jvmCommand : Constants.JVM_COMMANDS){
            String quotedJvmCommand = Constants.TWO_QUOTES + jvmCommand + Constants.TWO_QUOTES;
            outText = outText.replaceAll(jvmCommand, quotedJvmCommand);
        }
        return outText;
    }

    private static String makeCodeTagForJavaKeywords(String inText){
        String outText = inText;
        for (String javaKeyWord : Constants.JAVA_KEY_WORDS){
            String search = "[ ,.!:()]" + javaKeyWord + "[ ,.!:()]";
            String taggedJavaKeyWord = Constants.START_CODE_TAG + javaKeyWord + Constants.END_CODE_TAG;
            outText = outText.replaceAll(search, taggedJavaKeyWord);
        }
        return outText;
    }
}
