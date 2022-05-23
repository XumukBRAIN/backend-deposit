package com.andersenlab.depositservice.controller;


import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("deposits")
public class DepositsController {

    private final DepositService depositService;

    @GetMapping("active-products")
    public ResponseEntity<Collection<ResponseCompletedDepositsDto>> getCompleted(@RequestParam String clientId) {

        return ResponseEntity.ok(depositService.getCompleted(clientId));

    }

    @GetMapping("products")
    public ResponseEntity<Collection<ResponseAvailableDepositsDto>> getAvailable(@RequestParam String clientId) {

        return ResponseEntity.ok(depositService.getAvailable(clientId));

    }

    @PostMapping
    public ResponseEntity<Boolean> placingNewDeposit(@RequestParam String clientId,
                                                     @RequestBody RequestPlacingNewDepositDto requestPlacingNewDepositDto) {

        return ResponseEntity.ok(depositService.postPlacing(clientId, requestPlacingNewDepositDto));

    }

    @PostMapping("revoke")
    public ResponseEntity<String> updateEarlyReturnDepositsDto(@RequestParam String clientId) {

        return ResponseEntity.ok(depositService.updateEarlyReturnDepositsDto(clientId));
    }

}
