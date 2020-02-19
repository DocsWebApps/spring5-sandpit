package com.docswebapps.spring5sandpit.repository;

import com.docswebapps.spring5sandpit.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    Optional<TestEntity> findByName(String name);
}
