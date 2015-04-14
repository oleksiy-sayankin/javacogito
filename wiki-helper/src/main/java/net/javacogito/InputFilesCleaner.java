package net.javacogito;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

public class InputFilesCleaner {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
    String[] fileNames = {"description.txt", "format.txt", "forms.txt", "in.txt", "instruction.txt", "linking_ex.txt", "mnemonic.txt",
        "notes.txt", "operand_stack.txt", "operation.txt",  "runtime_ex.txt"};

        for(String fileName : fileNames){
            File file = Util.getFile(fileName);
            cleanFile(file);
        }
    }

    private static void cleanFile(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
}
