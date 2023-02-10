package mapcache;

import java.util.concurrent.atomic.AtomicInteger;

public class MapCacheObject {

    /**
     * 缓存对象
     */
    Object obj;

    /**
     * 置入缓存时间
     */
    long inTime;

    /**
     * 失效时间
     */
    long validTime;
    /**
     * 计数器，支持原子化数据的计算
     */
    AtomicInteger calcCount;

    MapCacheObject(Object obj, long inTime, long validTime, AtomicInteger calcCount) {
        this.obj = obj;
        this.inTime = inTime;
        this.validTime = validTime;
        this.calcCount = calcCount;
    }

}
