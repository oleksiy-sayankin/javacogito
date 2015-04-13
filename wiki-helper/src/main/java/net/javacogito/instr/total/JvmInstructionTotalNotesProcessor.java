package net.javacogito.instr.total;


import net.javacogito.Processor;
import static net.javacogito.Constants.*;

public class JvmInstructionTotalNotesProcessor implements Processor{
    public String process(String inText) {
        if (inText == null){
            return EMPTY_STRING;
        }

        inText = inText.trim();

        if (EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }

        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}
