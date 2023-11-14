package com.lm.assessment.server.support.gateway.util;

import com.lm.assessment.common.utils.json.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WebFilterUtil {

    private final static Logger logger = LoggerFactory.getLogger(WebFilterUtil.class);

    public static void returnFailedJson(HttpServletResponse response, int code, Object msg) {
        if (response.isCommitted()) {
            return;
        }
        response.setCharacterEncoding("UTF-8");
        response.setStatus(code);
        response.setContentType("application/json; charset=utf-8");
        WebFilterUtil.crossHeader(response);
        try {
            PrintWriter out = response.getWriter();
            Throwable var5 = null;
            try {
                if (msg instanceof String) {
                    out.append((String) msg);
                } else {
                    out.append(JsonUtils.toJson(msg));
                }
                out.flush();
            } catch (Throwable var15) {
                var5 = var15;
                throw var15;
            } finally {
                if (out != null) {
                    if (var5 != null) {
                        try {
                            out.close();
                        } catch (Throwable var14) {
                            var5.addSuppressed(var14);
                        }
                    } else {
                        out.close();
                    }
                }

            }
        } catch (IOException var17) {
            logger.error("写出失败", var17);
        }

    }


    public static void crossHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
    }
}