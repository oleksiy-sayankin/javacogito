package net.javacogito.instr.rules;
import net.javacogito.Processor;

import static net.javacogito.Constants.*;


public class JvmInstructionRulesHeaderProcessor implements Processor {

    public String process(String jvmInstruction) {
        StringBuilder sb = new StringBuilder();
        sb.append(FOUR_EMPTY_LINES).append(NL);
        sb.append(TABLE_HEADER_SIMPLE).append(NL);
        sb.append(TABLE_LEFT_CELL).append(BOLD_ITALIC).append(jvmInstruction).append(BOLD_ITALIC).append(NL);
        sb.append(TABLE_RIGHT_CELL).append(BOLD_ITALIC).append(jvmInstruction).append(BOLD_ITALIC).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
