package cloud.nzc.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.exception.ZuulException;

public class LoginFilter extends ZuulFilter {
    public LoginFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }

    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
