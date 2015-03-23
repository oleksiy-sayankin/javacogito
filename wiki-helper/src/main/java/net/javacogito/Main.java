package net.javacogito;

import java.io.IOException;

public class Main {

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println( makeDoubleEnter(makeCodeTagForJAddKeywords(makeCodeTagForJavaKeywords(makeItalicJvmCommands(inPlainText)))));
    }

    private static String makeItalicJvmCommands(String inText){
        String outText = inText;
        for (String jvmCommand : Constants.JVM_COMMANDS){
            String search = "\\b" + jvmCommand + "\\b";
            String quotedJvmCommand = Constants.TWO_QUOTES + jvmCommand + Constants.TWO_QUOTES;
            outText = outText.replaceAll(search, quotedJvmCommand);
        }
        return outText;
    }

    private static String makeCodeTagForJavaKeywords(String inText){
        String outText = inText;
        for (String javaKeyWord : Constants.JAVA_KEY_WORDS){
            String search = "\\b" + javaKeyWord + "\\b";
            String taggedJavaKeyWord = Constants.START_CODE_TAG + javaKeyWord + Constants.END_CODE_TAG;
            outText = outText.replaceAll(search, taggedJavaKeyWord);
        }
        return outText;
    }

    private static String makeCodeTagForJAddKeywords(String inText){
        String outText = inText;
        for (String addKeyWord : Constants.ADDITIONAL_KEY_WORDS){
            String search = "\\b" + addKeyWord + "\\b";
            String taggedAddKeyWord = Constants.START_CODE_TAG + addKeyWord + Constants.END_CODE_TAG;
            outText = outText.replaceAll(search, taggedAddKeyWord);
        }
        return outText;
    }

    private static String makeDoubleEnter(String inText){
        String outText = inText;
        String search = "\n";
        String dest = "\n\n";
        outText = outText.replaceAll(search, dest);
        return outText;
    }

}
