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


    public static String addFontCourierTagForSpecialWords(String inText){
        String outText = inText;
        for(String specialWord : SPECIAL_WORDS){
            String dest = FONT_COURIER_START_TAG + specialWord + FONT_COURIER_END_TAG;
            outText = outText.replaceAll(specialWord, dest);
        }
        return outText;
    }

    public static String addFontCourierTagForUnicode(String inText){
        String outText = inText;
        List<String> processedUnicode = new ArrayList<String>();

        while (hasUnTaggedUnicode(outText, processedUnicode, FONT_COURIER_START_TAG, FONT_COURIER_END_TAG)) {
            String unTaggedUnicode = findUnTaggedUnicode(outText, processedUnicode, FONT_COURIER_START_TAG, FONT_COURIER_END_TAG);
            String search = "\\" + unTaggedUnicode;
            String dest = FONT_COURIER_START_TAG + "\\" + unTaggedUnicode + FONT_COURIER_END_TAG;
            outText = outText.replaceAll(search, dest);
            processedUnicode.add("\\" + unTaggedUnicode);
        }
        return outText;
    }


    private static String findUnTaggedUnicode(String inText, List<String> processedEnglishWords, String startTag, String endTag){
        inText = removeProcessedWords(inText, processedEnglishWords, startTag, endTag);
        inText = removeExceptions(inText);
        inText = removeJvmCommands(inText);
        inText = removeSpecialWords(inText);
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String unicode = findUnicode(inText, index);
            int unicodeIndex = findUnicodeIndex(inText, index);
            if (isTaggedWord(inText, unicode, index, startTag, endTag)){
                index = unicodeIndex + unicode.length();
            } else {
                return unicode;
            }
        }
        return  EMPTY_STRING;
    }



    private static boolean hasUnTaggedUnicode(String inText, List<String> processedUnicode, String startTag, String endTag){
        inText = removeProcessedWords(inText, processedUnicode, startTag, endTag);
        inText = removeExceptions(inText);
        inText = removeJvmCommands(inText);
        inText = removeSpecialWords(inText);
        boolean result = false;
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String unicode = findUnicode(inText, index);
            int unicodeIndex = findUnicodeIndex(inText, index);
            if (unicodeIndex == -1){
                return false;
            }
            if (isTaggedWord(inText, unicode, index, startTag, endTag)){
                index = unicodeIndex + unicode.length();
            } else {
                return true;
            }
        }
        return result;
    }


    private static String findUnicode(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return EMPTY_STRING;
    }

    private static int findUnicodeIndex(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.start();
        }
        return  -1;
    }





    public static String addFontCourierTagForClassFileStructure(String inText){
        String outText = inText;
        List<String> processedEnglishWords = new ArrayList<String>();
        while (hasUnTaggedEnglishWord(outText, processedEnglishWords, FONT_COURIER_START_TAG, FONT_COURIER_END_TAG)){
            String unTaggedEnglishWord = findUnTaggedEnglishWord(outText, processedEnglishWords, FONT_COURIER_START_TAG, FONT_COURIER_END_TAG);
            String search = "\\b" + unTaggedEnglishWord + "\\b" + "(?!" + FONT_COURIER_END_TAG + "|" + RIGHT_BRACKET + ")";
            String dest = FONT_COURIER_START_TAG + unTaggedEnglishWord + FONT_COURIER_END_TAG;
            outText = outText.replaceAll(search, dest);
            processedEnglishWords.add(unTaggedEnglishWord);
        }
        return outText;
    }



    public static String addCodeTagForClassFileStructure(String inText){
        String outText = inText;
        List<String> processedEnglishWords = new ArrayList<String>();
        while (hasUnTaggedEnglishWord(outText, processedEnglishWords, CODE_START_TAG, CODE_END_TAG)){
            String unTaggedEnglishWord = findUnTaggedEnglishWord(outText, processedEnglishWords, CODE_START_TAG, CODE_END_TAG);
            String search = "\\b" + unTaggedEnglishWord + "\\b" + "(?!" + CODE_END_TAG + "|" + RIGHT_BRACKET + ")";
            String dest = CODE_START_TAG + unTaggedEnglishWord + CODE_END_TAG;
            outText = outText.replaceAll(search, dest);
            processedEnglishWords.add(unTaggedEnglishWord);
        }
        return outText;
    }

    private static boolean hasUnTaggedEnglishWord(String inText, List<String> processedEnglishWords, String startTag, String endTag){
        inText = removeProcessedWords(inText, processedEnglishWords, startTag, endTag);
        inText = removeExceptions(inText);
        inText = removeJvmCommands(inText);
        inText = removeSpecialWords(inText);
        inText = removeGenericJvmCommands(inText);
        boolean result = false;
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String englishWord = findEnglishWord(inText, index);
            int englishWordIndex = findEnglishWordIndex(inText, index);
            if (englishWordIndex == -1){
                return false;
            }
            if (isTaggedWord(inText, englishWord, index, startTag, endTag)){
                index = englishWordIndex + englishWord.length();
            } else {
                return true;
            }
        }
        return result;
    }

    private static String findUnTaggedEnglishWord(String inText, List<String> processedEnglishWords, String startTag, String endTag){
        inText = removeProcessedWords(inText, processedEnglishWords, startTag, endTag);
        inText = removeExceptions(inText);
        inText = removeJvmCommands(inText);
        inText = removeSpecialWords(inText);
        inText = removeGenericJvmCommands(inText);
        int index = 0;
        int inTextLength = inText.length();
        while(index <= inTextLength){
            String englishWord = findEnglishWord(inText, index);
            int englishWordIndex = findEnglishWordIndex(inText, index);
            if (isTaggedWord(inText, englishWord, index, startTag, endTag)){
                index = englishWordIndex + englishWord.length();
            } else {
                return englishWord;
            }
        }
        return  EMPTY_STRING;
    }

    private static String findEnglishWord(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("[a-zA-Z_]{2}[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return EMPTY_STRING;
    }

    private static int findEnglishWordIndex(String inText, int index){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile("[a-zA-Z_]{2}[a-zA-Z_0-9]*");
        Matcher matcher = pattern.matcher(cutInText);
        if (matcher.find()) {
            return matcher.start();
        }
        return  -1;
    }

    private static boolean isTaggedWord(String inText, String englishWord, int index, String startTag, String endTag){
        String cutInText = inText.substring(index);
        Pattern pattern = Pattern.compile(startTag + englishWord + endTag);
        Matcher matcher = pattern.matcher(cutInText);
        return matcher.find();
    }

    private static String removeExceptions(String inText){
        String outText = inText;
        for(String exception : EXCEPTIONS){
            String search = "\\b" + exception + "\\b";
            String dest = EMPTY_STRING;
            outText = outText.replaceAll(search, dest);
        }
        return outText;
    }

    private static String removeJvmCommands(String inText){
        String outText = inText;
        for(String jvmCommand : JVM_COMMANDS){
            String search = "\\b" + jvmCommand + "\\b";
            String dest = EMPTY_STRING;
            outText = outText.replaceAll(search, dest);
        }
        return outText;
    }

    private static String removeGenericJvmCommands(String inText){
        String outText = inText;
        for(String genericJvmCommand : GENERIC_JVM_COMMANDS){
            String search = genericJvmCommand;
            String dest = EMPTY_STRING;
            outText = outText.replaceAll(search, dest);
        }
        return outText;
    }


    private static String removeSpecialWords(String inText){
        String outText = inText;
        for(String specialWord : SPECIAL_WORDS){
            String search = "";
            if (specialWord.startsWith("<")){
                search = specialWord;
            } else {
                search = "\\b" + specialWord;
            }
            if (!specialWord.endsWith(">")){
                search = search + "\\b";
            }
            String dest = EMPTY_STRING;
            outText = outText.replaceAll(search, dest);
        }
        return outText;
    }


    private static String removeProcessedWords(String inText, List<String> processedWords, String startTag, String endTag){
        String outText = inText;
        for(String processedEnglishWord : processedWords){
            String source = startTag + processedEnglishWord + endTag;
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

    public static String makeItalicGenericJvmCommands(String inText){
        String outText = inText;
        for (String genericJvmCommand : GENERIC_JVM_COMMANDS){
            String search = genericJvmCommand;
            String quotedJvmCommand = TWO_QUOTES + genericJvmCommand + TWO_QUOTES;
            outText = outText.replaceAll(search, quotedJvmCommand);
        }
        return outText;
    }




    public static String makeCodeTagForJavaKeywords(String inText){
        String outText = inText;
        for (String javaKeyWord : Constants.JAVA_KEY_WORDS){
            String search = "\\b" + javaKeyWord + "\\b";
            String taggedJavaKeyWord = CODE_START_TAG + javaKeyWord + CODE_END_TAG;
            outText = outText.replaceAll(search, taggedJavaKeyWord);
        }
        return outText;
    }

    public static String makeCodeTagForAddKeywords(String inText){
        String outText = inText;
        for (String addKeyWord : ADDITIONAL_KEY_WORDS){
            String search = "\\b" + addKeyWord + "\\b";
            String taggedAddKeyWord = CODE_START_TAG + addKeyWord + CODE_END_TAG;
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

    public static String formatPrologCode(String inText){
        StringBuilder sb = new StringBuilder();
        sb.append(SYNTAX_HIGHLIGHT_PROLOG_START_TAG).append(NL);
        sb.append(inText).append(NL);
        sb.append(SYNTAX_HIGHLIGHT_END_TAG);
        return sb.toString();
    }

    public static String makeItalicAlwaysItalicWords(String inText){
        String outText = inText;
        for (String alwaysItalicWord : ALWAYS_ITALIC_WORDS){
            String search = alwaysItalicWord;
            String quotedJvmCommand = TWO_QUOTES + alwaysItalicWord + TWO_QUOTES;
            outText = outText.replaceAll(search, quotedJvmCommand);
        }
        return outText;

    }
}
