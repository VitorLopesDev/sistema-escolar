package com.escola.projeto.backend.domain.repositories;

import com.escola.projeto.backend.domain.models.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master,Long> {
}
