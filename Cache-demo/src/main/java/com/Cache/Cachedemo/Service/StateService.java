package com.Cache.Cachedemo.Service;

import com.Cache.Cachedemo.Bean.State;
import com.Cache.Cachedemo.Repo.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class StateService {
    @Autowired
    StateRepo stateRepo;
@Caching(evict ={@CacheEvict(value="customCache",allEntries = true)} , put= {
        @CachePut(value="customCache",key = "#request.Id")
})
    public State addState(State request){
        if(request.getId() == null) {
            return stateRepo.save(request);
        }else {
            Optional<State> stateUpdated =stateRepo.findById(request.getId());
            stateUpdated.get().setStateName(request.getStateName());
            stateUpdated.get().setZone(request.getZone());
            return stateRepo.save(stateUpdated.get());
        }
    }

    @Cacheable(value="customCache",key="#Id")
    public Optional<State> getStateDetails(Long Id){
        System.out.println("Calling Database");
        return stateRepo.findById(Id);
    }

}
