package com.jwt.JWT.Exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    ErrorResponse errorResponse;

    private final ObjectMapper mapper=new ObjectMapper();
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        errorResponse.setError("FORBIDDEN");
        errorResponse.setMessage("You Do not have permission to access this resource");

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        mapper.writeValue(response.getOutputStream(),errorResponse);
    }
}
