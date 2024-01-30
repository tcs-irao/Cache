package com.Cache.Cachedemo.Controller;

import com.Cache.Cachedemo.Bean.State;
import com.Cache.Cachedemo.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class Controller {

    @Autowired
    private StateService eacheService;

    @PostMapping(value = "state/add")
    public ResponseEntity<State> addState(@RequestBody State request){
        State addState = eacheService.addState(request);
        return ResponseEntity.ok().body(addState);
    }
    @GetMapping(value="/state/info")
    public ResponseEntity<Optional<State>> getStateDetail(@RequestParam(required = true) Long Id){
        Optional<State> StateDetails = eacheService.getStateDetails(Id);
        return ResponseEntity.ok().body(StateDetails);
    }

}
