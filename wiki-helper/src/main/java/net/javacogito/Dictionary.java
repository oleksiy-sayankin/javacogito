package net.javacogito;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Dictionary implements Iterable<Phrase>{
    private final Map<String, Phrase> dictionary = new HashMap<String, Phrase>();
    public  void put(Phrase phrase){
        dictionary.put(phrase.getMainForm(), phrase);
    }

    public Phrase get(String mainForm){
        return dictionary.get(mainForm);
    }

    public Iterator<Phrase> iterator() {
        return dictionary.values().iterator();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (String mainForm : dictionary.keySet()){
            if(first){
                sb.append(mainForm);
                first = false;
                continue;
            }
            sb.append(",");
            sb.append(mainForm);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        Dictionary other = (Dictionary)o;
        if (other.dictionary == null){
            return  false;
        }
        return this.dictionary.equals(other.dictionary);
    }

    @Override
    public int hashCode(){
        return dictionary.hashCode();
    }
}
