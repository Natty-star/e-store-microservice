package edu.miu.cs590.cloudgateway.security;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouterValidator {
    public static final List<String> openApiEndpoints = List.of(
            "/users/register",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints.
                    stream().
                    noneMatch(uri -> request.getURI().getPath().contains(uri));
}
