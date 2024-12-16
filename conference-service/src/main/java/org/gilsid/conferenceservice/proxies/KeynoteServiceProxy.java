package org.gilsid.conferenceservice.proxies;

import org.gilsid.conferenceservice.services.dtos.KeynoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface KeynoteServiceProxy {
    @GetMapping("/keynotes/{id}")
    KeynoteDTO getKeynoteById(@PathVariable Long id);
}