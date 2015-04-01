package net.javacogito;

import java.io.IOException;
import static net.javacogito.FormatHelper.*;
public class Main {

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println(makeDoubleEnter(makeCodeTagForAddKeywords(makeCodeTagForJavaKeywords(makeItalicJvmCommands(inPlainText)))));
        System.out.println();
        System.out.println(replaceTabWith4Spaces(makeSpaceAtLineStart(makeItalicJvmCommands(inPlainText))));
        System.out.println();
        System.out.println(addFontCourierTagForClassFileStructure(inPlainText));
    }
}
