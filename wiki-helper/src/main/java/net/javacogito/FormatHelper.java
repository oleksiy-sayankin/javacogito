package net.javacogito;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.javacogito.Constants.*;

public final class FormatHelper {
    private FormatHelper(){}

    public static String replaceCodeTagWithFontTag(String inText){
        String outText = inText;
        String search = "<code>";
        String dest = "<font face=Courier>";
        outText = outText.replaceAll(search, dest);
        search = "</code>";
        dest = "</font>";
        outText = outText.replaceAll(search, dest);
        return outText;
    }




    public static String addCodeTagForClassFileStructure(String inText){
        String outText = inText;
        List<String> processedEnglishWords = new ArrayList<String>();
        while (hasUnTaggedEnglishWord(outText, processedEnglishWords)){
            String unTaggedEnglishWord = findUnTaggedEnglishWord(outText, processedEnglishWords);
            String search = "\\b" + unTaggedEnglishWord + "\\b" + "(?!" + END_CODE_TAG + "|" + RIGHT_BRACKET + ")";
            String dest = START_CODE_TAG + unTaggedEnglishWord + END_CODE_TAG;
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
        return  EMPTY_STRING;
    }

    private static String findEnglishWord(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("[a-zA-Z]{2}[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return EMPTY_STRING;
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
        Pattern pattern = Pattern.compile(START_CODE_TAG + englishWord + END_CODE_TAG);
        Matcher matcher = pattern.matcher(cutInText);
        return matcher.find();
    }

    private static String removeExceptions(String inText){
        String outText = inText;
        for(String exception : EXCEPTIONS){
            String dest = EMPTY_STRING;
            outText = outText.replaceAll(exception, dest);
        }
        return outText;
    }

    private static String removeProcessedEnglishWord(String inText, List<String> processedEnglishWords){
        String outText = inText;
        for(String processedEnglishWord : processedEnglishWords){
            String source = START_CODE_TAG + processedEnglishWord + END_CODE_TAG;
            String dest = Constants.EMPTY_STRING;
            outText = outText.replaceAll(source, dest);
        }
        return outText;
    }

    public static String makeItalicJvmCommands(String inText){
        String outText = inText;
        for (String jvmCommand : JVM_COMMANDS){
            String search = "\\b" + jvmCommand + "\\b";
            String quotedJvmCommand = TWO_QUOTES + jvmCommand + TWO_QUOTES;
            outText = outText.replaceAll(search, quotedJvmCommand);
        }
        return outText;
    }

    public static String makeCodeTagForJavaKeywords(String inText){
        String outText = inText;
        for (String javaKeyWord : Constants.JAVA_KEY_WORDS){
            String search = "\\b" + javaKeyWord + "\\b";
            String taggedJavaKeyWord = START_CODE_TAG + javaKeyWord + END_CODE_TAG;
            outText = outText.replaceAll(search, taggedJavaKeyWord);
        }
        return outText;
    }

    public static String makeCodeTagForJAddKeywords(String inText){
        String outText = inText;
        for (String addKeyWord : ADDITIONAL_KEY_WORDS){
            String search = "\\b" + addKeyWord + "\\b";
            String taggedAddKeyWord = START_CODE_TAG + addKeyWord + END_CODE_TAG;
            outText = outText.replaceAll(search, taggedAddKeyWord);
        }
        return outText;
    }

    public static String makeDoubleEnter(String inText){
        String outText = inText;
        String search = "\n";
        String dest = "\n\n";
        outText = outText.replaceAll(search, dest);
        return outText;
    }

    public static String makeSpaceAtLineStart(String inText){
        String outText = inText;
        String search = "^";
        String dest = " ";
        outText = outText.replaceAll(search, dest);
        search = "\n";
        dest = "\n ";
        outText = outText.replaceAll(search, dest);
        return outText;
    }

    public static String replaceTabWith4Spaces(String inText){
        String outText = inText;
        String search = "\t";
        String dest = "    ";
        outText = outText.replaceAll(search, dest);
        return outText;
    }
}
