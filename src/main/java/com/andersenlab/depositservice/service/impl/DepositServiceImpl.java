package com.andersenlab.depositservice.service.impl;

import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Agreement;
import com.andersenlab.depositservice.domain.exeption.InternalServerException;
import com.andersenlab.depositservice.domain.mapper.DepositMapper;
import com.andersenlab.depositservice.repository.AccountRepository;
import com.andersenlab.depositservice.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private final AccountRepository accountRepository;

    private final DepositMapper depositMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<ResponseCompletedDepositsDto> getCompleted(String clientId) {

        Optional<Account> account = accountRepository.findByClientId(UUID.fromString(clientId));
        if (account.isPresent()) {
            Account account1 = account.get();
            return depositMapper.accountToResponseCompletedDepositsDto(account1);
        }

        throw new InternalServerException("Internal Server Error");
    }

    @Override
    public Collection<ResponseAvailableDepositsDto> getAvailable(String clientId) {

        Optional<Account> account = accountRepository.findByClientId(UUID.fromString(clientId));
        if (account.isPresent()) {

            return depositMapper.accountToResponseAvailableDepositsDto(account.get());
        }
        throw new InternalServerException("Internal Server Error");
    }

    @Override
    public Boolean postPlacing(String clientId, RequestPlacingNewDepositDto requestPlacingNewDepositDto) {
        Optional<Account> account = accountRepository.findByClientId(UUID.fromString(clientId));
        if (account.isPresent()) {

            Agreement agreement = depositMapper.requestPlacingNewDepositDtoToAgreement(requestPlacingNewDepositDto);
            Account account1 = account.get();
            List<Agreement> agreements = account1.getAgreements();
            agreements.add(agreement);
            account1.setAgreements(agreements);
            accountRepository.save(account1);
            return true;
        }
        throw new InternalServerException("Internal Server Error");
    }

    @Override
    public String updateEarlyReturnDepositsDto(String clientId) {


        return null;
    }


}
