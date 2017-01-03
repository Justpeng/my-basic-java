package learn.chapter.concurrent.chapter4;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 委托到CurrentHashMap
 *
 * @author:Just
 * @create:2017-01-03 22:07
 */
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<String,Point>(points);
        //1 这返回的是复制值，可能会和真实值不统一，因为可调用setLocation修改Point
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String,Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name:" + id);
        }
    }
}
