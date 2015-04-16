package net.javacogito.instr.total;


public final class TotalDescription {
    private final String mnemonic;
    private final String operation;
    private final String format;
    private final String forms;
    private final String operandStack;
    private final String description;
    private final String linkingEx;
    private final String runtimeEx;
    private final String notes;

    TotalDescription(String mnemonic, String operation, String format, String forms, String operandStack, String description, String linkingEx, String runtimeEx, String notes){
        this.mnemonic = mnemonic;
        this.operation = operation;
        this.format = format;
        this.forms = forms;
        this.operandStack = operandStack;
        this.description = description;
        this.linkingEx = linkingEx;
        this.runtimeEx = runtimeEx;
        this.notes = notes;
    }


    public String getMnemonic() {
        return mnemonic;
    }

    public String getOperation() {
        return operation;
    }

    public String getFormat() {
        return format;
    }

    public String getForms() {
        return forms;
    }

    public String getOperandStack() {
        return operandStack;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkingEx() {
        return linkingEx;
    }

    public String getRuntimeEx() {
        return runtimeEx;
    }

    public String getNotes() {
        return notes;
    }



}
