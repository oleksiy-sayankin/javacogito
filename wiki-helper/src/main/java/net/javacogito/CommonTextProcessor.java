package net.javacogito;

import java.io.IOException;
import static net.javacogito.FormatHelper.*;
public class CommonTextProcessor implements Processor{

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new CommonTextProcessor().process(inPlainText));
        System.out.println();
    }

    public String process(String inText) {
        return makeItalicAlwaysItalicWords(makeItalicGenericJvmCommands(makeItalicJvmCommands(addFontCourierTagForUnicode(addFontCourierTagForSpecialWords(addFontCourierTagForClassFileStructure(inText))))));
    }
}
