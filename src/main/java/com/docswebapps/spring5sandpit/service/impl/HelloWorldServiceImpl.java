package com.docswebapps.spring5sandpit.service.impl;

import com.docswebapps.spring5sandpit.domain.TestEntity;
import com.docswebapps.spring5sandpit.repository.TestEntityRepository;
import com.docswebapps.spring5sandpit.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
  private final TestEntityRepository testEntityRepository;

  @Autowired
    public HelloWorldServiceImpl(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }

    public String sayHello() {
        return this.testEntityRepository.findByName("dave")
                .map(TestEntity::getDescription)
                .orElseGet(() -> {return "Nothing found!!";});
    }
}
