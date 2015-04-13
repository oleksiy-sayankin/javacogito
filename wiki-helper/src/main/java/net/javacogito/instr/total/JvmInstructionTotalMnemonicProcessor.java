package net.javacogito.instr.total;


import net.javacogito.Processor;
import static net.javacogito.Constants.*;

public class JvmInstructionTotalMnemonicProcessor implements Processor{
    public String process(String inText) {
        if (inText == null){
            return EMPTY_STRING;
        }

        inText = inText.trim();

        if (EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(FOUR_EMPTY_LINES).append(NL);
        sb.append(TABLE_HEADER_SIMPLE).append(NL);
        sb.append(TABLE_LEFT_CELL).append(BOLD_ITALIC).append(inText).append(BOLD_ITALIC).append(NL);
        sb.append(TABLE_RIGHT_CELL).append(BOLD_ITALIC).append(inText).append(BOLD_ITALIC).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        return sb.toString();
    }
}
