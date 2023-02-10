package mapcache;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MapCacheManager {

    /**
     * 线程工作间隔时间
     */
    private static long ACTION_TIME = 2 * 60 * 1000;

    /**
     * 最大的有效时间
     */
    private static long MAX_VALID_TIME = 5 * 60 * 1000;

    /**
     * 对象容器
     */
    private static HashMap objectMap = new HashMap();

    /**
     * 初始化临时对象清理线程
     */
    static {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new InvalidateTimeOutObjectTask(), 1, ACTION_TIME);
    }

    /**
     * 加入对象
     *
     * @param objId
     * @param obj
     */
    public static void putObject(String objId, Object obj) {
        putObject(objId, obj, MAX_VALID_TIME, 0);
    }


    /**
     * 加入对象
     *
     * @param objId
     * @param obj
     */
    public static void putObject(String objId, Object obj, int calcCount) {
        putObject(objId, obj, MAX_VALID_TIME, calcCount);
    }

    /**
     * 加入对象，并设置有效时间
     *
     * @param objId
     * @param obj
     * @param validTime
     * @param calcCount
     */
    public static void putObject(String objId, Object obj, long validTime, int calcCount) {
        if (validTime > MAX_VALID_TIME) {
            validTime = MAX_VALID_TIME;
        }
        AtomicInteger a = new AtomicInteger(calcCount);
        objectMap.put(objId, new MapCacheObject(obj, getCurrentTime(), validTime, a));
    }

    /**
     * 获取临时对象，同时重置其有效时间
     *
     * @param objId
     * @return
     */
    public static Object getObject(String objId) {
        MapCacheObject tempObjInfo = (MapCacheObject) objectMap.get(objId);
        if (tempObjInfo == null) {
            return null;
        }
        tempObjInfo.inTime = getCurrentTime();
        return tempObjInfo.obj;
    }

    /**
     * 使指定对象无效
     *
     * @param objId
     */
    public static void invalidate(String objId) {
        objectMap.remove(objId);
    }

    /**
     * 获得缓存中所有的非空key
     *
     * @return
     */
    public static List getUnEmptyKeyList() {
        List allKeyList = new ArrayList();
        Iterator it = objectMap.keySet().iterator();
        while (it.hasNext()) {
            String objId = (String) it.next();
            if (objectMap.get(objId) != null) {
                allKeyList.add(objId);
            }
        }
        return allKeyList;
    }

    private static long getCurrentTime() {
        return new Date().getTime();
    }

    /**
     * 定期清理临时过期对象
     */
    private static class InvalidateTimeOutObjectTask extends TimerTask {
        public void run() {
            try {
                //System.out.println("清除过期临时对象..."+getCurrentTime());
                //System.out.println("之前对象数目："+objectMap.size());
                long time = new Date().getTime();
                Iterator it = objectMap.keySet().iterator();
                ArrayList invalidObjKeys = new ArrayList();
                while (it.hasNext()) {
                    String objId = (String) it.next();
                    MapCacheObject tempObjInfo = (MapCacheObject) objectMap.get(objId);
                    if (getCurrentTime() >= tempObjInfo.inTime + tempObjInfo.validTime) {
                        invalidObjKeys.add(objId);
                    }
                }
                for (int i = 0; i < invalidObjKeys.size(); i++) {
                    invalidate((String) invalidObjKeys.get(i));
                }
                //System.out.println("之后对象数目："+objectMap.size());
            } catch (Exception e) {
            }
        }
    }

}
