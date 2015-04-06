package net.javacogito;

import java.io.IOException;

import static net.javacogito.FormatHelper.*;


public class SimpleCodeProcessor implements Processor{
    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new SimpleCodeProcessor().process(inPlainText));
        System.out.println();
    }

    public String process(String inText) {
        return replaceTabWith4Spaces(makeSpaceAtLineStart(makeItalicJvmCommands(inText)));
    }
}
