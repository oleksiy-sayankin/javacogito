package net.javacogito;


public final class Constants {
    private Constants(){}
    public static final String TABLE_HEADER = "{| width=\"90%\" border=\"0\" style=\"border-collapse:collapse; margin-left: 46px;\" |";
    public static final String ONE_EMPTY_LINE = "<br>";
    public static final String PIPE = "|";
    public static final String TABLE_FOOTER = "|}";
    public static final String NL = "\n";
    public static final String SYNTAX_HIGHLIGHT_START_PROLOG_TAG = "<syntaxhighlight lang=\"prolog\">";
    public static final String SYNTAX_HIGHLIGHT_END_TAG = "</syntaxhighlight>";
    public static final String EMPTY_STRING = "";
    public static final String RIGHT_BRACKET = ">";
    public static final String TWO_QUOTES = "''";
    public static final String EXCEPTIONS[] = {"Java", "JLS", "ASCII", "Unicode", "UTF", "NaN", "SE", "JDK",  "release", "ME", "CLDC" ,"Card"};
    public static final String START_CODE_TAG = "<code>";
    public static final String END_CODE_TAG = "</code>";
    public static final String START_FONT_COURIER_TAG = "<font face=Courier>";
    public static final String END_FONT_COURIER_TAG = "</font>";
    public static final String[] ADDITIONAL_KEY_WORDS = {
            "null",
            "reference"
    };

    public static final String[] SPECIAL_WORDS = {
            "<clinit>",
            "<init>"
    };

    public static final String[] JAVA_KEY_WORDS = {
            "abstract",
            "continue",
            "for",
            //"new",
            "switch",
            "assert",
            "default",
            "goto",
            "package",
            "synchronized",
            "boolean",
            "do",
            "if",
            "private",
            "this",
            "break",
            "double",
            "implements",
            "protected",
            "throw",
            "byte",
            "else",
            "import",
            "public",
            "throws",
            "case",
            "enum",
            //"instanceof",
            "return",
            "transient",
            "catch",
            "extends",
            "int",
            "short",
            "try",
            "char",
            "final",
            "interface",
            "static",
            "void",
            "class",
            "finally",
            "long",
            "strictfp",
            "volatile",
            "const",
            "float",
            "native",
            "super",
            "while"
    };

    public static final String[] GENERIC_JVM_COMMANDS = {
            "aload_<n>",
            "astore_<n>",
            "dcmp<op>",
            "dconst_<d>",
            "dload_<n>",
            "dstore_<n>",
            "fcmp<op>",
            "fconst_<f>",
            "fload_<n>",
            "fstore_<n>",
            "iconst_<i>",
            "if_acmp<cond>",
            "if_icmp<cond>",
            "if<cond>",
            "iload_<n>",
            "istore_<n>",
            "lconst_<l>",
            "lload_<n>",
            "lstore_<n>",
    };

    public static final String[] JVM_COMMANDS = {
            "nop",
            "aconst_null",
            "iconst_m1",
            "iconst_0",
            "iconst_1",
            "iconst_2",
            "iconst_3",
            "iconst_4",
            "iconst_5",
            "lconst_0",
            "lconst_1",
            "fconst_0",
            "fconst_1",
            "fconst_2",
            "dconst_0",
            "dconst_1",
            "bipush",
            "sipush",
            "ldc",
            "ldc_w",
            "ldc2_w",
            "iload",
            "lload",
            "fload",
            "dload",
            "aload",
            "iload_0",
            "iload_1",
            "iload_2",
            "iload_3",
            "lload_0",
            "lload_1",
            "lload_2",
            "lload_3",
            "fload_0",
            "fload_1",
            "fload_2",
            "fload_3",
            "dload_0",
            "dload_1",
            "dload_2",
            "dload_3",
            "aload_0",
            "aload_1",
            "aload_2",
            "aload_3",
            "iaload",
            "laload",
            "faload",
            "daload",
            "aaload",
            "baload",
            "caload",
            "saload",
            "istore",
            "lstore",
            "fstore",
            "dstore",
            "astore",
            "istore_0",
            "istore_1",
            "istore_2",
            "istore_3",
            "lstore_0",
            "lstore_1",
            "lstore_2",
            "lstore_3",
            "fstore_0",
            "fstore_1",
            "fstore_2",
            "fstore_3",
            "dstore_0",
            "dstore_1",
            "dstore_2",
            "dstore_3",
            "astore_0",
            "astore_1",
            "astore_2",
            "astore_3",
            "iastore",
            "lastore",
            "fastore",
            "dastore",
            "aastore",
            "bastore",
            "castore",
            "sastore",
            "pop",
            "pop2",
            "dup",
            "dup_x1",
            "dup_x2",
            "dup2",
            "dup2_x1",
            "dup2_x2",
            "swap",
            "iadd",
            "ladd",
            "fadd",
            "dadd",
            "isub",
            "lsub",
            "fsub",
            "dsub",
            "imul",
            "lmul",
            "fmul",
            "dmul",
            "idiv",
            "ldiv",
            "fdiv",
            "ddiv",
            "irem",
            "lrem",
            "frem",
            "drem",
            "ineg",
            "lneg",
            "fneg",
            "dneg",
            "ishl",
            "lshl",
            "ishr",
            "lshr",
            "iushr",
            "lushr",
            "iand",
            "land",
            "ior",
            "lor",
            "ixor",
            "lxor",
            "iinc",
            "i2l",
            "i2f",
            "i2d",
            "l2i",
            "l2f",
            "l2d",
            "f2i",
            "f2l",
            "f2d",
            "d2i",
            "d2l",
            "d2f",
            "i2b",
            "i2c",
            "i2s",
            "lcmp",
            "fcmpl",
            "fcmpg",
            "dcmpl",
            "dcmpg",
            "ifeq",
            "ifne",
            "iflt",
            "ifge",
            "ifgt",
            "ifle",
            "if_icmpeq",
            "if_icmpne",
            "if_icmplt",
            "if_icmpge",
            "if_icmpgt",
            "if_icmple",
            "if_acmpeq",
            "if_acmpne",
            "goto",
            "jsr",
            "ret",
            "tableswitch",
            "lookupswitch",
            "ireturn",
            "lreturn",
            "freturn",
            "dreturn",
            "areturn",
            "return",
            "getstatic",
            "putstatic",
            "getfield",
            "putfield",
            "invokevirtual",
            "invokespecial",
            "invokestatic",
            "invokeinterface",
            "invokedynamic",
            "new",
            "newarray",
            "anewarray",
            "arraylength",
            "athrow",
            "checkcast",
            "instanceof",
            "monitorenter",
            "monitorexit",
            "wide",
            "multianewarray",
            "ifnull",
            "ifnonnull",
            "goto_w",
            "jsr_w",
            "breakpoint",
            "impdep1",
            "impdep2"
    };

}
