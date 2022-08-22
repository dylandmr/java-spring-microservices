package br.com.bookService.proxy;

import br.com.bookService.response.CambioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {

    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    CambioResponse getCambio(
            @PathVariable("amount") Double amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to);
}
