package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, UUID> {
}
