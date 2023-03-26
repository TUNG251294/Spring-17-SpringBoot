package com.codegym.cms.model.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
