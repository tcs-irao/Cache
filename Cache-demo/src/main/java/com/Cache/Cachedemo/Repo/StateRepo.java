package com.Cache.Cachedemo.Repo;

import com.Cache.Cachedemo.Bean.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepo extends JpaRepository<State, Long>  {
    Optional<State> findById(Long id);
}
