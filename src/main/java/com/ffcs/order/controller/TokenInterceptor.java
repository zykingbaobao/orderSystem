package com.ffcs.order.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ffcs.order.tools.JWTtool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JWTtool jwTtool;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        /** 地址过滤 */
        String uri = request.getRequestURI();
        System.out.println("uri="+uri);
        if (uri.contains("/login")) {
            return true;
        }
        if (uri.contains("/register")) {
            return true;
        }
        if (uri.contains("/swagger-ui")) {
            return true;
        }
        if (uri.contains("/springfox")) {
            return true;
        }
        if (uri.contains("/swagger-resources")) {
            return true;
        }
        /** Token 验证 */
        String token = request.getHeader(jwTtool.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwTtool.getHeader());
        }
        if (StringUtils.isEmpty(token)) {
            throw new SignatureException(jwTtool.getHeader() + "不能为空");
        }

        Claims claims = null;
        try {
            claims = jwTtool.getClaimByToken(token);
            if (claims == null || jwTtool.isTokenExpired(claims.getExpiration())) {
                throw new SignatureException(jwTtool.getHeader() + "失效，请重新登录。");
            }
        } catch (Exception e) {
            throw new SignatureException(jwTtool.getHeader() + "失效，请重新登录。");
        }

        /** 设置 identityId 用户身份ID */
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }

}
