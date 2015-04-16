package net.javacogito.instr.total;


import net.javacogito.JvmCodeSimpleFormatProcessor;
import net.javacogito.Processor;
import static net.javacogito.Constants.*;

public class JvmInstructionTotalFormsProcessor extends JvmInstructionTotalCommonProcessor{

    @Override
    protected String processText(String inText) {
        String preparedText = new JvmCodeSimpleFormatProcessor().process(inText);

        String[] lines = preparedText.split("\n");

        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(TABLE_HEADER_BORDER_COLLAPSE).append(NL);

        boolean first = true;
        for (String line : lines){
            if(first){
                sb.append(PIPE).append(TABLE_FORMAT_WIDTH_150).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(BOLD).append(FORMS).append(BOLD).append(NL);
                sb.append(PIPE).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(line).append(NL);
                first = false;
                continue;
            }
            sb.append(NL).append(line).append(NL);

        }

        sb.append(TABLE_FOOTER).append(NL);
        return sb.toString();
    }
}
