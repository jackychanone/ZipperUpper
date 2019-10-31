package src.interfaces.trie;

import src.interfaces.misc.BString;
import src.interfaces.misc.Set;

public abstract class TrieSet<A extends Comparable<A>, E extends BString<A>> extends Set<E> {
    protected TrieSet(TrieMap<A, E, Boolean> backingMap) {
        super(backingMap);
    }

    @SuppressWarnings("unchecked")
    public final boolean findPrefix(E e) {
        return ((TrieMap<A, E, Boolean>) this.map).findPrefix(e);
    }
}
