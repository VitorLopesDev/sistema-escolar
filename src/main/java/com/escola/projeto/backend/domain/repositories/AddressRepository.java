package com.escola.projeto.backend.domain.repositories;

import com.escola.projeto.backend.domain.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
