package com.andersenlab.depositservice.service.impl;

import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Agreement;
import com.andersenlab.depositservice.domain.exeption.InternalServerException;
import com.andersenlab.depositservice.domain.mapper.DepositMapper;
import com.andersenlab.depositservice.repository.AccountRepository;
import com.andersenlab.depositservice.service.DepositsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepositsServiceImpl implements DepositsService {

    private final AccountRepository accountRepository;

    private final DepositMapper depositMapper;


    @Override
    public Collection<ResponseCompletedDepositsDto> getCompleted(String clientId) {

        Optional<Account> account = accountRepository.findByClientId(UUID.fromString(clientId));
        if (account.isPresent()) {

            return depositMapper.accountToResponseCompletedDepositsDto(account.get());
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
            Set<Agreement> agreements = account1.getAgreements();
            agreements.add(agreement);
            account1.setAgreements(agreements);
            accountRepository.save(account1);
            return true;
        }
        throw new InternalServerException("Internal Server Error");
    }

}
