package net.javacogito.instr.rules;


import net.javacogito.Processor;

import static net.javacogito.Constants.*;
import static net.javacogito.Constants.NL;
import static net.javacogito.Constants.ONE_EMPTY_LINE;
import static net.javacogito.FormatHelper.*;

public class JvmInstructionRulesPrologProcessor implements Processor {
    public String process(String inText) {
        StringBuilder sb = new StringBuilder();
        sb.append(TABLE_HEADER_WITH_MARGIN).append(NL);
        sb.append(PIPE).append(NL);
        sb.append(formatPrologCode(inText)).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
