package net.javacogito.instr.total;


import net.javacogito.Dictionary;
import net.javacogito.Processor;

import static net.javacogito.Constants.EMPTY_STRING;
import static net.javacogito.FormatHelper.findAllItalic;

public abstract class JvmInstructionTotalCommonProcessor implements Processor{
    protected Dictionary dictionary = new Dictionary();

    public JvmInstructionTotalCommonProcessor addItalic(String italicSource){
        dictionary.putAll(findAllItalic(italicSource));
        return this;
    }

    public  String process(String inText) {
        if (inText == null){
            return EMPTY_STRING;
        }

        inText = inText.trim();

        if (EMPTY_STRING.equals(inText)){
            return EMPTY_STRING;
        }

        return processText(inText);
    }

    protected abstract String processText(String inText);
}
