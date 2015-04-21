package net.javacogito;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static net.javacogito.Constants.*;

public class LinksProcessor implements Processor{
    private static Map<String, String> contents = new HashMap<String,String>();
    static {
        try {
            buildContents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) throws IOException {
        String inPlainText = Util.readFile("in.txt");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(new LinksProcessor().process(inPlainText));
        System.out.println();
    }

    public String process(String inText) {
        String outText = inText;
        outText = removeJls(outText);

        for (Map.Entry<String, String> entry : contents.entrySet()){
            String search = entry.getKey() + "(?![.][0-9])\\b";
            String dest = LINK_START_TAG + JVM_SPEC + HASH + entry.getValue() + PIPE + entry.getKey() + LINK_END_TAG;
            outText = outText.replaceAll(search, dest);
        }

        outText = restoreJls(outText);
        return outText;
    }


    private String removeJls(String inText){
        String outText = inText;
        String search = "JLS " + PARAGRAPH + "(?=[0-9])";
        String dest = "JLS ";
        outText = outText.replaceAll(search, dest);
        return outText;
    }

    private String restoreJls(String inText){
        String outText = inText;
        String search = "JLS (?=[0-9])";
        String dest = "JLS " + PARAGRAPH;
        outText = outText.replaceAll(search, dest);
        return outText;
    }

    private static void buildContents() throws IOException {
        String inPlainText = Util.readFile("contents.txt");
        String[] lines = inPlainText.split("\n");
        for (String line : lines){
            String chapterNumber = buildChapterNumber(line);
            String chapterName = buildChapterName(line);
            contents.put(chapterNumber, chapterName);
        }
    }


    private static String buildChapterNumber(String line){
        String[] parts = line.split(" ");
        return PARAGRAPH + parts[0];
    }

    private static String buildChapterName(String line){
        String[] parts = line.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(String part : parts){
            if(isFirst){
                isFirst = false;
                continue;
            }
            sb.append(part);
            sb.append(SPACE);
        }
        return sb.toString().trim();
    }



}
