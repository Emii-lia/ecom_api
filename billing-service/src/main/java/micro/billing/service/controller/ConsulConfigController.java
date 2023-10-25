package micro.billing.service.controller;

import lombok.RequiredArgsConstructor;
import micro.billing.service.config.MyConsulConfig;
import micro.billing.service.config.MyVaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
public class ConsulConfigController {

    @Autowired
    private MyConsulConfig myConsulConfig;

    @Autowired
    private MyVaultConfig myVaultConfig;

    @GetMapping("/my_config")
    public Map<String, Object> myConfig() {
        return Map.of("consulConfig", myConsulConfig, "vaultConfig", myVaultConfig);
    }
}
