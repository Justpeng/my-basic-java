package learn.effective.four;

import java.util.Collection;
import java.util.Set;

/**
 * Description: WrapperClass，可以包装任何Set实现
 * 可以结合任何先前存在的构造器一起工作
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/23/2017-10:44
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int  addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAccount() {
        return addCount;
    }
}
