package src.types;

import src.interfaces.misc.BString;
import src.interfaces.worklists.FixedSizeFIFOWorkList;

public class AlphabeticString extends BString<Character> { 
    public AlphabeticString(String s) {
        super(BString.wrap(s.toCharArray()));
    }

    public AlphabeticString(FixedSizeFIFOWorkList<Character> q) {
        super(q);
    }
    
    public AlphabeticString(Character[] s) {
        super(s);
    }
    
    public static Class<Character> getLetterType() { return Character.class; }
}
