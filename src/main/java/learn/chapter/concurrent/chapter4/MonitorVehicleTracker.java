package learn.chapter.concurrent.chapter4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 机动车追踪器
 * 每个机车都有一个String唯一标识id 和位置（x,y）
 * 线程安全
 * @author:Just
 * @create:2017-01-03 19:17
 */
public class MonitorVehicleTracker {
    //私有不可变类型，当然，Map本身是可变的
    private final Map<String, MutablePoint> locations;

    //构造器初始化locations，保证locations被安全的构建、发布
    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = locations;
    }

    /**
     * 获取机车信息
     * 调用该方法，返回值是从MutablePoint执行拷贝的构造函数
     * deepCopy方法拷贝而来，deepCopy会创建一个新的Map，它的值
     * 从旧的Map的Key和Value拷贝而来的
     * @return
     */
    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = getLocation(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such id:" + id);
        }
        loc.x=x;
        loc.y=y;
    }

    private static Map<String,MutablePoint> deepCopy(Map<String,MutablePoint> m){
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            // new 新对象，则复制了Point本身
            result.put(id, new MutablePoint(m.get(id)));
//            //只复制了引用
//            result.put(id, m.get(id));

        }
        //unmodifiableMap包装Map，这样做保护了容器不被修改，但不能保证修改存储的可变对象
        return Collections.unmodifiableMap(result);

    }


}
