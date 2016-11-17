package com.zy.blogs.blogssample;

import android.app.Activity;

import java.util.Stack;

/**
 * <p>
 * 作者：zhouyuan on  2016/7/7 15:19
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 * 管理所有Activity的活动
 */
public class ActivityCollector {

    public static Stack<Activity> activityStack;
    private static ActivityCollector instance;

    public static ActivityCollector getInstance() {
        if (instance == null) {
            instance = new ActivityCollector();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        if (!isContaintActivity(activity.getClass())) {
            activityStack.add(activity);
        } else {
            activityStack.remove(activity.getClass());
            activityStack.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        activityStack.remove(activity);
    }

    public static boolean isContaintActivity(Class<?> cls) {
        for (int i = 0, j = activityStack.size(); i < j; i++) {
            if (activityStack.get(i).getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public static void finishAll() {
        for (Activity activity : activityStack) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
