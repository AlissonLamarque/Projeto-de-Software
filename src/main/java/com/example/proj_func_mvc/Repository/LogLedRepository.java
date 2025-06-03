package com.example.proj_func_mvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proj_func_mvc.Model.logLed;
import org.springframework.stereotype.Repository;

@Repository
public interface LogLedRepository extends JpaRepository<logLed, Long> {
}
