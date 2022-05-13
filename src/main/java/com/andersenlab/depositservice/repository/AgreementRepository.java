package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgreementRepository extends JpaRepository<Agreement, UUID> {
}
