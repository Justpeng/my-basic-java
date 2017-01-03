package learn.chapter.concurrent.chapter4;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用限制确保线程安全
 *
 * @author:Just
 * @create:2017-01-03 18:53
 */
public class PersonSet {
    private final Set<Person> mySet = new HashSet<Person>();
    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }
    public synchronized boolean containsPerson(Person person) {
        return mySet.contains(person);
    }
}
