package net.javacogito.instr.rules;

import net.javacogito.CommonTextProcessor;
import net.javacogito.Processor;

import static net.javacogito.Constants.*;

public class JvmInstructionRulesDescProcessor implements Processor {

    public String process(String inText) {
        String preFormattedText = new CommonTextProcessor().process(inText);
        StringBuilder sb = new StringBuilder();
        sb.append(TABLE_HEADER_WITH_MARGIN).append(NL);
        sb.append(PIPE).append(NL);
        sb.append(preFormattedText).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
