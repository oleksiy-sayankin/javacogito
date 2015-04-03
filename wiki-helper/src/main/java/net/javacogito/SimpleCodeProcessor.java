package net.javacogito;

import java.io.IOException;

import static net.javacogito.FormatHelper.*;


public class SimpleCodeProcessor {
    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(replaceTabWith4Spaces(makeSpaceAtLineStart(makeItalicJvmCommands(inPlainText))));
        System.out.println();
    }

}
