package com.hz;

import java.awt.geom.NoninvertibleTransformException;
import java.io.IOException;

public class BooleanAdapter {

    private LineReader _reader;

    private String[] _confirmingKeywords;
    private String[] _denyingKeywords;

    public BooleanAdapter(LineReader reader) {
        _reader = reader;

        _confirmingKeywords = this.getConfirmingKeywords();
        _denyingKeywords = new String[] {"no", "don't think so", "say what", "not" };
    }

    private String[] getConfirmingKeywords(){

        return new String[]{
                "yes",
                "thanks",
                "great",
                "sure",
                "love to",
                "Okay",
                "Sounds good",
                "good idea",
                "don't mind",
                "be delighted"};
    }

    private boolean convertTo(String phrase) throws NoninvertibleTransformException {

        if(isDenying(phrase)) return false;

        if(isConfirming(phrase)) return true;

        throw new NoninvertibleTransformException("Cannot convert to boolean" + phrase);
    }

    private boolean isConfirming(String phrase) {

        for(String keyword : _confirmingKeywords){
            if(phrase.toLowerCase().contains(keyword))
                return true;
        }
        return false;
    }

    private boolean isDenying(String phrase) {

        for(String keyword : _denyingKeywords){
            if(phrase.toLowerCase().contains(keyword))
                return true;
        }
        return false;
    }

    /**
     * Wrapper method
     */
    public Boolean readLine()
            throws NoninvertibleTransformException, IOException {
        String ans = _reader.readLine();

        return convertTo(ans);
    }
}
