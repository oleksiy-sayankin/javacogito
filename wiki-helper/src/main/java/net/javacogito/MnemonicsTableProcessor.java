package net.javacogito;


import java.io.IOException;

import static net.javacogito.FormatHelper.*;

public class MnemonicsTableProcessor implements Processor{
    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new MnemonicsTableProcessor().process(inPlainText));
        System.out.println();
    }
    public String process(String inText) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatHex(formatDec(inText)));
        return sb.toString();
    }
}
