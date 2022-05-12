package com.andersenlab.depositservice.controller;


import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("deposits")
public class DepositsController {

    @GetMapping("active-products")
    public ResponseEntity <Collection<ResponseCompletedDepositsDto>> getDeposits (@RequestParam String clientId) {

    return ResponseEntity.ok(null);

}

}
