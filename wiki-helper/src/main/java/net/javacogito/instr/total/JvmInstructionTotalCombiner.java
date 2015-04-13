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
        String mnemonic = Util.readFile("mnemonic.txt");
        String operation = Util.readFile("operation.txt");
        String format = Util.readFile("format.txt");
        String forms = Util.readFile("forms.txt");
        String operandStack = Util.readFile("operand_stack.txt");
        String description = Util.readFile("description.txt");
        String linkingEx = Util.readFile("linking_ex.txt");
        String runtimeEx = Util.readFile("runtime_ex.txt");
        String notes = Util.readFile("notes.txt");
        StringBuilder sb = new StringBuilder();
        sb.append(new JvmInstructionTotalMnemonicProcessor().process(mnemonic));
        sb.append(new JvmInstructionTotalOperationProcessor().process(operation));
        sb.append(new JvmInstructionTotalFormatProcessor().process(format));
        sb.append(new JvmInstructionTotalFormsProcessor().process(forms));
        sb.append(new JvmInstructionTotalOperandStackProcessor().process(operandStack));
        sb.append(new JvmInstructionTotalDescriptionProcessor().process(description));
        sb.append(new JvmInstructionTotalLinkingExProcessor().process(linkingEx));
        sb.append(new JvmInstructionTotalRuntimeExProcessor().process(runtimeEx));
        sb.append(new JvmInstructionTotalNotesProcessor().process(notes));
        return sb.toString();
    }
}
