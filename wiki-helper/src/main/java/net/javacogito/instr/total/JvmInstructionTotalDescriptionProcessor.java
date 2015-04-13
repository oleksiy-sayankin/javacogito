package net.javacogito.instr.total;


import net.javacogito.CommonTextProcessor;
import net.javacogito.Processor;
import static net.javacogito.Constants.*;
import static net.javacogito.FormatHelper.*;

public class JvmInstructionTotalDescriptionProcessor implements Processor{
    public String process(String inText) {
        if (inText == null){
            return EMPTY_STRING;
        }

        inText = inText.trim();

        if (EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }

        String preparedText = new CommonTextProcessor().process(inText);
        preparedText = formatForceItalic(preparedText);

        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(TABLE_HEADER_BORDER_COLLAPSE).append(NL);
        sb.append(TABLE_FORMAT_WIDTH_150).append(BOLD).append(OPERATION).append(BOLD).append(NL);
        sb.append(PIPE).append(preparedText).append(NL);
        sb.append(TABLE_FOOTER).append(NL);

        return sb.toString();
    }
}
