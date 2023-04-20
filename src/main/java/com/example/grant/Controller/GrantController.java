package com.example.grant.Controller;

import com.example.grant.Entity.Grant;
import com.example.grant.Service.GrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/grant")
public class GrantController {
    private GrandService grandService;

    //build create Grant REST API
    @PostMapping
    public ResponseEntity<Grant> createGrant(@RequestBody Grant grant){
        Grant savedGrant  =  grandService.createGrant(grant);
        return new ResponseEntity<>(savedGrant, HttpStatus.CREATED);
    }
    //Build Get All Grant REST API
    //http://localhost:8080/api/grants/1
    @GetMapping("{id}")
    public ResponseEntity<Grant> getGrantById(@PathVariable("id") Long grantId){
        Grant grant = grandService.getGrantById(grantId);
        return new ResponseEntity<>(grant, HttpStatus.OK);
    }
    //Build Get All Grant REST API
    //http://localhost:8080/api/grants
    @GetMapping
    public ResponseEntity<List<Grant>> getAllGrants(){
        List<Grant> grants;
        grants = grandService.getAllGrant();
        return new ResponseEntity<>(grants, HttpStatus.OK);
    }
    //Build Update Grant REST API
    @PutMapping("{id}")
    //http://localhost:8080/api/grants/1
    public ResponseEntity<Grant> updateGrant(@PathVariable("id") Long grantId,@RequestBody Grant grant){
        grant.setId(grantId);
        Grant updateGrant = grandService.updateGrant(grant);
        return new ResponseEntity<>(updateGrant, HttpStatus.OK);
    }
    //Build Delete Grant REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGrant(@PathVariable("id") Long grantId){
        grandService.deleteGrant(grantId);
        return new ResponseEntity<>("Grant successfully deleted!", HttpStatus.OK);
    }
}
