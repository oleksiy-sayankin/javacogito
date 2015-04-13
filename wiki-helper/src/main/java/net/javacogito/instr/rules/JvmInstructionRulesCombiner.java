package net.javacogito.instr.rules;


import net.javacogito.Combiner;
import net.javacogito.Util;

import java.io.IOException;

public class JvmInstructionRulesCombiner implements Combiner {
    public static void main( String[] args ) throws IOException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new JvmInstructionRulesCombiner().combine());
        System.out.println();
    }



    public String combine() throws IOException {
        String instruction = Util.readFile("instruction.txt");
        String description = Util.readFile("description.txt");
        String prolog = Util.readFile("prolog.txt");
        StringBuilder sb = new StringBuilder();
        sb.append(new JvmInstructionRulesHeaderProcessor().process(instruction));
        sb.append(new JvmInstructionRulesDescProcessor().process(description));
        sb.append(new JvmInstructionRulesPrologProcessor().process(prolog));
        return sb.toString();
    }
}
