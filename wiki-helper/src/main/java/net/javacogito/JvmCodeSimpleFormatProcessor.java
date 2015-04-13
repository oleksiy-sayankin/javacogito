package net.javacogito;

import java.io.IOException;

import static net.javacogito.Constants.NL;
import static net.javacogito.Constants.ONE_EMPTY_LINE;
import static net.javacogito.FormatHelper.*;


public class JvmCodeSimpleFormatProcessor implements Processor{

    public String process(String inText) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeItalicGenericJvmCommands(makeItalicJvmCommands(inText)));
        return sb.toString();
    }
}
