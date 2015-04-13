package net.javacogito;

import java.io.IOException;

import static net.javacogito.Constants.*;

public class RemarkProcessor implements Processor{

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new RemarkProcessor().process(inPlainText));
        System.out.println();
    }


    public String process(String inText) {
        String preFormattedText = new CommonTextProcessor().process(inText);
        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(TABLE_HEADER_WITH_MARGIN).append(NL);
        sb.append(PIPE).append(NL);
        sb.append(SPAN_START_TAG).append(preFormattedText).append(SPAN_END_TAG).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
