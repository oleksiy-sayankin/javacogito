package net.javacogito;
import static net.javacogito.Constants.*;


public class JvmInstructionHeaderProcessor implements Processor{
    private static String FOUR_EMPTY_LINES = "<br><br><br><br>";
    private static String TABLE_HEADER = "{| width=\"100%\"";
    private static String TABLE_LEFT_CELL = "| style=\"text-align:left;\"  | ";
    private static String TABLE_RIGHT_CELL = "| style=\"text-align:right;\"  | ";
    private static String BOLD_ITALIC = "'''''";

    public String process(String jvmInstruction) {
        StringBuilder sb = new StringBuilder();
        sb.append(FOUR_EMPTY_LINES).append(NL);
        sb.append(TABLE_HEADER).append(NL);
        sb.append(TABLE_LEFT_CELL).append(BOLD_ITALIC).append(jvmInstruction).append(BOLD_ITALIC).append(NL);
        sb.append(TABLE_RIGHT_CELL).append(BOLD_ITALIC).append(jvmInstruction).append(BOLD_ITALIC).append(NL);
        sb.append(Constants.TABLE_FOOTER).append(NL);
        sb.append(ONE_EMPTY_LINE).append(NL);
        return sb.toString();
    }
}
