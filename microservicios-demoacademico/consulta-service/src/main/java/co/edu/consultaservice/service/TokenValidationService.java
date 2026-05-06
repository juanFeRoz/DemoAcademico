package co.edu.consultaservice.service;

import org.springframework.stereotype.Service;

import co.edu.consultaservice.client.AuthFeignClient;
import co.edu.consultaservice.dto.TokenValidationResponse;
import co.edu.consultaservice.security.TokenUtils;

@Service
public class TokenValidationService {

    private final AuthFeignClient authFeignClient;

    public TokenValidationService(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    public boolean isValid(String rawToken) {
        try {
            String token = TokenUtils.normalize(rawToken);

            if (token == null) {
                return false;
            }

            TokenValidationResponse response = authFeignClient.validate(token);
            return response != null && Boolean.TRUE.equals(response.getValid());
        } catch (Exception e) {
            return false;
        }
    }
}
