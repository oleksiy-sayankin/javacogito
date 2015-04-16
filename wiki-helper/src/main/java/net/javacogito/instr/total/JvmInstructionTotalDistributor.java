package net.javacogito.instr.total;

import net.javacogito.Util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.javacogito.Constants.*;

public class JvmInstructionTotalDistributor {
    public static void main(String[] args) throws IOException {
        String inText = Util.readFile("in.txt");
        System.out.println(findMnemonic(inText));
        System.out.println(findOperation(inText));
        System.out.println(findFormat(inText));
        System.out.println(findForms(inText));
        System.out.println(findOperandStack(inText));
        System.out.println(findDescription(inText));
        System.out.println(findLinkingEx(inText));
        System.out.println(findRuntimeEx(inText));
        System.out.println(findNotes(inText));
    }

    public static TotalDescription getTotalDescription(String filename) throws IOException {
        String inText = Util.readFile(filename);
        String mnemonic = findMnemonic(inText);
        String operation = findOperation(inText);
        String format = findFormat(inText);
        String forms = findForms(inText);
        String operandStack = findOperandStack(inText);
        String description = findDescription(inText);
        String linkingEx = findLinkingEx(inText);
        String runtimeEx = findRuntimeEx(inText);
        String notes = findNotes(inText);

        return new TotalDescription(mnemonic, operation, format, forms, operandStack, description, linkingEx, runtimeEx, notes);

    }


    private static String findMnemonic(String inText){
        Pattern pattern = Pattern.compile("^.*");
        Matcher matcher = pattern.matcher(inText);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return EMPTY_STRING;
    }

    private static String findOperation(String inText){
        String outText = findStringBetween(inText, OPERATION, FORMAT);
        return outText.trim();

    }

    private static String findFormat(String inText){
        String outText = findStringBetween(inText, FORMAT, FORMS);
        return outText.trim();
    }


    private static String findForms(String inText){
        String outText = findStringBetween(inText, FORMS, OPERAND_STACK);
        return outText.trim();
    }


    private static String findOperandStack(String inText){
        String outText = findStringBetween(inText, OPERAND_STACK, DESCRIPTION);
        return outText.trim();
    }


    private static String findDescription(String inText){
        String outText = findStringBetween(inText, DESCRIPTION, LINKING_EXCEPTIONS);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, DESCRIPTION, RUNTIME_EXCEPTIONS);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, DESCRIPTION, NOTES);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, DESCRIPTION, EMPTY_STRING);
        return outText.trim();
    }


    private static String findLinkingEx(String inText){
        String outText = findStringBetween(inText, LINKING_EXCEPTIONS, RUNTIME_EXCEPTIONS);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, LINKING_EXCEPTIONS, NOTES);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, LINKING_EXCEPTIONS, EMPTY_STRING);
        return outText.trim();
    }


    private static String findRuntimeEx(String inText){
        String outText = findStringBetween(inText, RUNTIME_EXCEPTIONS, NOTES);
        if(!EMPTY_STRING.equals(outText)){
            return outText.trim();
        }
        outText = findStringBetween(inText, RUNTIME_EXCEPTIONS, EMPTY_STRING);
        return outText.trim();
    }


    private static String findNotes(String inText){
        String outText = findStringBetween(inText, NOTES, EMPTY_STRING);
        return outText.trim();
    }


    private static String findStringBetween(String inText, String start, String end){
        if (inText == null || EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }
        if (start == null){
            return EMPTY_STRING;
        }
        if (end == null){
            return EMPTY_STRING;
        }
        int startIndex = inText.indexOf(start);
        if (startIndex < 0 ){
            return EMPTY_STRING;
        }
        int endIndex = inText.indexOf(end);
        if (endIndex < 0 ){
            return EMPTY_STRING;
        }
        if(EMPTY_STRING.equals(end)){
            return inText.substring(startIndex + start.length());
        }
        return inText.substring(startIndex + start.length(), endIndex);

    }

}
