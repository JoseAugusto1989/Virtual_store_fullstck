package com.store.backend.repositories;

import com.store.backend.entities.PersonPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionPersonRepository extends JpaRepository<PersonPermission, Long> {
}
