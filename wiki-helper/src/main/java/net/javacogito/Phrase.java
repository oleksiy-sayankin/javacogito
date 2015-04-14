package net.javacogito;


import java.util.HashSet;
import java.util.Set;

import static net.javacogito.Constants.*;

public class Phrase {
    private final Set<String> forms = new HashSet<String>();
    private final String mainForm;

    Phrase(String mainForm){
        forms.add( mainForm);
        this.mainForm = mainForm;
    }
    public Phrase addForm(String form){
        forms.add(form);
        return this;
    }

    public boolean isInText(String inText){
        if (inText == null){
            return false;
        }
        if (EMPTY_STRING.equals(inText)){
            return false;
        }
        String preparedString = inText.trim();
        for (String form : forms){
            if (preparedString.contains(form)){
                return true;
            }
        }
        return false;
    }

    public Set<String> getForms(){
        return forms;
    }

    public String getMainForm(){
        return mainForm;
    }

    @Override
    public String toString(){
        return mainForm;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int hashCode = 1;
        for (String form : forms) {
            hashCode = prime * hashCode + form.hashCode() >>> 32;
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        Phrase other = (Phrase)o;
        if(!this.mainForm.equals(other.getMainForm())){
            return false;
        }
        return this.forms.equals(other.getForms());
    }
}
