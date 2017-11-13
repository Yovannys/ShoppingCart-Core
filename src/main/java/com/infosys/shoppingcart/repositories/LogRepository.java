package com.infosys.shoppingcart.repositories;

import com.infosys.shoppingcart.entities.Log;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface LogRepository.
 */
@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {}
