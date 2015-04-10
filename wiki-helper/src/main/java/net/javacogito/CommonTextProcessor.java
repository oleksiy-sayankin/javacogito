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
        String outText = addFontCourierTagForClassFileStructure(inText);
        outText = addFontCourierTagForSpecialWords(outText);
        outText = addFontCourierTagForUnicode(outText);
        outText = makeItalicJvmCommands(outText);
        outText = makeItalicGenericJvmCommands(outText);
        outText = makeItalicAlwaysItalicWords(outText);
        outText = formatClassLoaderNames(outText);
        //outText = makeDoubleEnter(outText);
        outText = formatSubSupIndexes(outText);
        return outText;
    }
}
