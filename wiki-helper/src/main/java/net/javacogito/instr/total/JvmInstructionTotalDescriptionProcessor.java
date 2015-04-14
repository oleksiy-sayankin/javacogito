package net.javacogito.instr.total;


import net.javacogito.CommonTextProcessor;
import net.javacogito.Dictionary;
import net.javacogito.Processor;
import net.javacogito.Util;

import java.io.IOException;

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
        Dictionary dictionary = findAllItalic(readOperandStack());
        preparedText = formatForceItalic(preparedText, dictionary);
        preparedText = shadePipe(preparedText);

        StringBuilder sb = new StringBuilder();
        sb.append(ONE_EMPTY_LINE).append(NL);
        sb.append(TABLE_HEADER_BORDER_COLLAPSE).append(NL);
        sb.append(PIPE).append(TABLE_FORMAT_WIDTH_150).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(BOLD).append(DESCRIPTION).append(BOLD).append(NL);
        sb.append(PIPE).append(TABLE_FORMAT_VERTICAL_ALIGN_TOP).append(PIPE).append(preparedText).append(NL);
        sb.append(TABLE_FOOTER).append(NL);

        return sb.toString();
    }

    private String readOperandStack(){
        String operandStack = EMPTY_STRING;
        try {
            operandStack = Util.readFile("operand_stack.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operandStack;
    }
}
