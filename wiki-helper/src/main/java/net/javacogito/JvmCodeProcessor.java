package net.javacogito;

import java.io.IOException;

import static net.javacogito.Constants.NL;
import static net.javacogito.Constants.ONE_EMPTY_LINE;
import static net.javacogito.FormatHelper.*;


public class JvmCodeProcessor implements Processor{
    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new JvmCodeProcessor().process(inPlainText));
        System.out.println();
    }

    public String process(String inText) {
        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(replaceTabWith4Spaces(makeSpaceAtLineStart(makeItalicJvmCommands(inText)))).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
