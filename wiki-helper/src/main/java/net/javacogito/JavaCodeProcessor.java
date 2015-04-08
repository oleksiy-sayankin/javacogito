package net.javacogito;

import java.io.IOException;

import static net.javacogito.Constants.*;

public class JavaCodeProcessor implements Processor{
    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new JavaCodeProcessor().process(inPlainText));
        System.out.println();
    }




    public String process(String inText) {
        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(SYNTAX_HIGHLIGHT_JAVA_START_TAG).append(NL);
        sb.append(inText).append(NL);
        sb.append(SYNTAX_HIGHLIGHT_END_TAG).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
