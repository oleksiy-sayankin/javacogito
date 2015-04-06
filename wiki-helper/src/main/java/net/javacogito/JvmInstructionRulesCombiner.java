package net.javacogito;


import java.io.IOException;

public class JvmInstructionRulesCombiner {
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
        sb.append(new JvmInstructionHeaderProcessor().process(instruction));
        sb.append(new JvmInstructionDescProcessor().process(description));
        sb.append(new JvmInstructionPrologProcessor().process(prolog));
        return sb.toString();
    }
}
