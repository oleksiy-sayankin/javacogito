package net.javacogito;

import java.io.IOException;
import static net.javacogito.FormatHelper.*;
public class CommonTextProcessor {

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(makeItalicGenericJvmCommands(makeItalicJvmCommands(addFontCourierTagForUnicode(addFontCourierTagForSpecialWords(addFontCourierTagForClassFileStructure(inPlainText))))));
        System.out.println();
    }
}
