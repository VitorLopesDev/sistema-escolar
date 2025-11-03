package com.escola.projeto.backend.domain.repositories;

import com.escola.projeto.backend.domain.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
