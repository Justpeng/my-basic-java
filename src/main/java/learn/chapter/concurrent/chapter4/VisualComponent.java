package learn.chapter.concurrent.chapter4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 委托线程安全到多个底层的状态变量
 *
 * @author:Just
 * @create:2017-01-03 22:34
 */
public class VisualComponent {

    /**
     * 使用CopyOnWrite存储每个监听器清单，特别适合管理监听器清单
     * 每个List都是线程安全的，而且两个不变约束之间没有耦合
     */
    private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener keyListener) {
        keyListeners.add(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener) {
        mouseListeners.add(mouseListener);
    }
    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }
    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }

}
