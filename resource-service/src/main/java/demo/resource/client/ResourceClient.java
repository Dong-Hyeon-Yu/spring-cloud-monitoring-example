package demo.resource.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "resource-service")
public interface ResourceClient {

    @GetMapping("/member")
    String getMember();
}
