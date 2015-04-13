package net.javacogito.instr.total;


import net.javacogito.JvmCodeSimpleFormatProcessor;
import net.javacogito.Processor;
import static net.javacogito.Constants.*;
import static net.javacogito.FormatHelper.*;

public class JvmInstructionTotalFormatProcessor implements Processor{
    public String process(String inText) {
        if (inText == null){
            return EMPTY_STRING;
        }

        inText = inText.trim();

        if (EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }

        String preparedText = new JvmCodeSimpleFormatProcessor().process(inText);
        preparedText = formatForceItalic(preparedText);

        String[] lines = preparedText.split("\n");

        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(TABLE_HEADER_BORDER_COLLAPSE).append(NL);
        sb.append(PIPE).append(TABLE_FORMAT_WIDTH_150).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(BOLD).append(FORMAT).append(BOLD).append(NL);
        sb.append(PIPE).append(NL);
        boolean first = true;
        for (String line : lines){
            if (first){
                sb.append(TABLE_HEADER_BORDER_BORDER_1).append(NL);
                sb.append(PIPE).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(line).append(NL);
                first = false;
                continue;
            }
            sb.append(TABLE_NEW_ROW).append(NL);
            sb.append(PIPE).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(line).append(NL);
        }

        sb.append(TABLE_FOOTER).append(NL);
        sb.append(TABLE_FOOTER).append(NL);
        return sb.toString();
    }
}
