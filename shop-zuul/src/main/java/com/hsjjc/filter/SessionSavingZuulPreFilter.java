package com.hsjjc.filter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SessionSavingZuulPreFilter extends ZuulFilter {
	
    @Autowired
    private SessionRepository repository;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();

        HttpSession httpSession = context.getRequest().getSession();
        Session session = repository.getSession(httpSession.getId());

        context.addZuulRequestHeader("Cookie", "SESSION=" + httpSession.getId());

        //log.info("ZuulPreFilter session proxy: {}", session.getId());

        return null;
    }

	@Override
	public boolean shouldFilter() {
		return true;
	}

}
