package net.javacogito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
//        System.out.println(makeDoubleEnter(makeCodeTagForJAddKeywords(makeCodeTagForJavaKeywords(makeItalicJvmCommands(inPlainText)))));
        System.out.println();
//        System.out.println(replaceTabWith4Spaces(makeSpaceAtLineStart(makeItalicJvmCommands(inPlainText))));
        System.out.println();
        System.out.println(addCodeTagForClassFileStructure(inPlainText));
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

    private static String makeSpaceAtLineStart(String inText){
        String outText = inText;
        String search = "^";
        String dest = " ";
        outText = outText.replaceAll(search, dest);
        search = "\n";
        dest = "\n ";
        outText = outText.replaceAll(search, dest);
        return outText;
    }

    private static String replaceTabWith4Spaces(String inText){
        String outText = inText;
        String search = "\t";
        String dest = "    ";
        outText = outText.replaceAll(search, dest);
        return outText;
    }



    private static String addCodeTagForClassFileStructure(String inText){
        String outText = inText;
        List<String> processedEnglishWords = new ArrayList<String>();
        while (hasUnTaggedEnglishWord(outText, processedEnglishWords)){
            String unTaggedEnglishWord = findUnTaggedEnglishWord(outText, processedEnglishWords);
            String search = "\\b" + unTaggedEnglishWord + "\\b";
            String dest = Constants.START_CODE_TAG + unTaggedEnglishWord + Constants.END_CODE_TAG;
            outText = outText.replaceAll(search, dest);
            processedEnglishWords.add(unTaggedEnglishWord);
        }
        return outText;
    }

    private static boolean hasUnTaggedEnglishWord(String inText, List<String> processedEnglishWords){
        inText = removeProcessedEnglishWord(inText, processedEnglishWords);
        inText = removeExceptions(inText);
        boolean result = false;
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String englishWord = findEnglishWord(inText, index);
            int englishWordIndex = findEnglishWordIndex(inText, index);
            if (englishWordIndex == -1){
                return false;
            }
            if (isTaggedEnglishWord(inText, englishWord, index)){
                index = englishWordIndex + englishWord.length();
            } else {
                return true;
            }
        }
        return result;
    }

    private static String findUnTaggedEnglishWord(String inText, List<String> processedEnglishWords){
        inText = removeProcessedEnglishWord(inText, processedEnglishWords);
        inText = removeExceptions(inText);
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String englishWord = findEnglishWord(inText, index);
            int englishWordIndex = findEnglishWordIndex(inText, index);
            if (isTaggedEnglishWord(inText, englishWord, index)){
                index = englishWordIndex + englishWord.length();
            } else {
                return englishWord;
            }
        }
        return  Constants.EMPTY_STRING;
    }

    private static String findEnglishWord(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("[a-zA-Z]{2}[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return Constants.EMPTY_STRING;
    }

    private static int findEnglishWordIndex(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("[a-zA-Z]{2}[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.start();
        }
        return  -1;
    }

    private static boolean isTaggedEnglishWord(String inText, String englishWord, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile(Constants.START_CODE_TAG + englishWord + Constants.END_CODE_TAG);
        Matcher matcher = pattern.matcher(cutInText);
        return matcher.find();
    }


    private static String removeExceptions(String inText){
        String outText = inText;
        for(String exception : Constants.EXCEPTIONS){
            String dest = Constants.EMPTY_STRING;
            outText = outText.replaceAll(exception, dest);
        }
        return outText;
    }

    private static String removeProcessedEnglishWord(String inText, List<String> processedEnglishWords){
        String outText = inText;
        for(String processedEnglishWord : processedEnglishWords){
            String source = Constants.START_CODE_TAG + processedEnglishWord + Constants.END_CODE_TAG;
            String dest = Constants.EMPTY_STRING;
            outText = outText.replaceAll(source, dest);
        }
        return outText;
    }
}
