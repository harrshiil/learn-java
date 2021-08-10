package com.sfl.americantutor.repository;

import com.sfl.americantutor.domain.ATAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<ATAuthority, Long> {
    Optional<ATAuthority> findByName(String authority);
}
