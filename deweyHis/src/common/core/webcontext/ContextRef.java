package common.core.webcontext;

import org.springframework.context.ApplicationContext;

/**
 * ContextUtil�����࣬������һ����̬����context���������web������ApplicationContext������
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