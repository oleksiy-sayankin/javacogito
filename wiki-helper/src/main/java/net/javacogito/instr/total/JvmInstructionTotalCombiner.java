package net.javacogito.instr.total;


import net.javacogito.Combiner;
import net.javacogito.Util;


import java.io.IOException;

public class JvmInstructionTotalCombiner implements Combiner {
    public static void main( String[] args ) throws IOException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new JvmInstructionTotalCombiner().combine());
        System.out.println();
    }

    public String combine() throws IOException {
        TotalDescription td = JvmInstructionTotalDistributor.getTotalDescription("in.txt");
        String mnemonic = td.getMnemonic();
        String operation = td.getOperation();
        String format = td.getFormat();
        String forms = td.getForms();
        String operandStack = td.getOperandStack();
        String description = td.getDescription();
        String linkingEx = td.getLinkingEx();
        String runtimeEx = td.getRuntimeEx();
        String notes = td.getNotes();
        StringBuilder sb = new StringBuilder();
        sb.append(new JvmInstructionTotalMnemonicProcessor().process(mnemonic));
        sb.append(new JvmInstructionTotalOperationProcessor().process(operation));
        sb.append(new JvmInstructionTotalFormatProcessor().process(format));
        sb.append(new JvmInstructionTotalFormsProcessor().process(forms));
        sb.append(new JvmInstructionTotalOperandStackProcessor().process(operandStack));
        sb.append(new JvmInstructionTotalDescriptionProcessor().addItalic(operandStack).addItalic(format).process(description));
        sb.append(new JvmInstructionTotalLinkingExProcessor().addItalic(operandStack).addItalic(format).process(linkingEx));
        sb.append(new JvmInstructionTotalRuntimeExProcessor().addItalic(operandStack).addItalic(format).process(runtimeEx));
        sb.append(new JvmInstructionTotalNotesProcessor().addItalic(operandStack).addItalic(format).process(notes));
        return sb.toString();
    }
}
