//package com.pfonseca.erp.interceptor;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.sleuth.Span;
//import org.springframework.cloud.sleuth.Tracer;
//import org.springframework.stereotype.Service;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//
//@Service
//public class ZuulTraceIdFilter extends ZuulFilter {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulTraceIdFilter.class);
//	
//	@Autowired
//	private Tracer tracer;
//
//	@Override
//	public String filterType() {
//		return "pre";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() {
//
//		try{
//			
//			RequestContext ctx = RequestContext.getCurrentContext();
//			HttpServletResponse response = ctx.getResponse();
//	
//			String traceId = Span.idToHex(tracer.getCurrentSpan().getTraceId());
//			
//			LOGGER.info("Trace-id: " + traceId );
//			
//			if(StringUtils.isNotEmpty(traceId)){
//				response.addHeader("trace-id", traceId );
//				response.addHeader("span-id", Span.idToHex(tracer.getCurrentSpan().getSpanId()) );
//			}
//		
//		}catch(Exception e){
//			LOGGER.error("Error to get TraceID", e);
//		}
//
//		return null;
//	}
//
//}
