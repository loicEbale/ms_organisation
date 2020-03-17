package com.sprintpay.organisation.proxy;

import com.sprintpay.organisation.beans.RecetteBean;
import com.sprintpay.organisation.client.AuthorizedFeignClient;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AuthorizedFeignClient(name = "msRecette")
public interface RestClientRecette {

	@GetMapping("/api/recettesorg/{id}")
    public List<RecetteBean> getRecetteByIdOrg(@PathVariable ("id") Long id);
}
