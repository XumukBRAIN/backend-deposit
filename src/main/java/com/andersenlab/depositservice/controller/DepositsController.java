package com.andersenlab.depositservice.controller;


import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.service.DepositsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("deposits")
public class DepositsController {

    private final DepositsService depositsService;

    @GetMapping("active-products")
    public ResponseEntity<Collection<ResponseCompletedDepositsDto>> getCompleted(@RequestParam String clientId) {

        return ResponseEntity.ok(depositsService.getCompleted(clientId));

    }

    @GetMapping("products")
    public ResponseEntity<Collection<ResponseAvailableDepositsDto>> getAvailable(@RequestParam String clientId) {

        return ResponseEntity.ok(depositsService.getAvailable(clientId));

    }

    @PostMapping
    public ResponseEntity<Boolean> placingNewDeposit(@RequestParam String clientId,
                                                     @RequestBody RequestPlacingNewDepositDto requestPlacingNewDepositDto) {

        return ResponseEntity.ok(depositsService.postPlacing(clientId, requestPlacingNewDepositDto));

    }

}
