package com.sfl.americantutor.repository;

import com.sfl.americantutor.domain.ATUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ATUser, Long> {

    Optional<ATUser> findByEmail(String email);

    List<ATUser> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);
}
