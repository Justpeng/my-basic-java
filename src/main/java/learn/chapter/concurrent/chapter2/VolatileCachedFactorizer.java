package learn.chapter.concurrent.chapter2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 使用到不可变容器对象的volatile类型，缓存最新的结果
 *
 * @author:Just
 * @create:2016-12-28 20:26
 */
public class VolatileCachedFactorizer implements Servlet {
    //使用OneValueCache缓存数字以及因数
    //OneValueCache不可变，保证只有一个线程访问
    //并使用volatile确保其可见性
    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = (BigInteger) servletRequest.getAttribute("i");
        BigInteger [] factor = (BigInteger[]) servletRequest.getAttribute("factor");
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors =factor;
            cache = new OneValueCache(i, factors);
        }

    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
