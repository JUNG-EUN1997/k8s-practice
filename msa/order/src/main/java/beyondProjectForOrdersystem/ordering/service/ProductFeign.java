package beyondProjectForOrdersystem.ordering.service;

import beyondProjectForOrdersystem.common.configs.FeignConfig;
import beyondProjectForOrdersystem.common.dto.CommonResDto;
import beyondProjectForOrdersystem.ordering.dto.ProductUpdateStockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// 여기에 url name을 보낼 수 있음
// url 설정을  추가하여 service 자원을 검색하도록 설정
// url="http://product-service" 이 내부통신할 때 service 명 : k8s내부에서 통신할 수 있음
@FeignClient(name = "product-service", url="http://product-service", configuration = FeignConfig.class)
public interface ProductFeign {
    @GetMapping(value = "/product/{id}")
    CommonResDto getProductById(@PathVariable("id") Long id);

    @PutMapping(value = "/product/updatestock")
    void updateProductStock(@RequestBody ProductUpdateStockDto dto);
}
