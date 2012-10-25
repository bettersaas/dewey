package common.core.webcontext;

import org.springframework.context.ApplicationContext;

/**
 * ContextUtil工具类，里面有一个静态变量context，用来存放web环境下ApplicationContext的引用
 * @author Administrator
 *
 */
public class ContextRef{
    private static ApplicationContext context;
    public static ApplicationContext getContext() {
        return context;
    }
    public static void setContext(ApplicationContext aContext) {
        context = aContext;
    }
}