package com.example.grant.Service;

import com.example.grant.Entity.Grant;
import com.example.grant.Repository.GrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrantServiceImpl implements GrandService{
    private GrandRepository grandRepository;

    @Override
    public Grant createGrant(Grant grant) {
        return grandRepository.save(grant);
    }

    @Override
    public Grant getGrantById(Long grantId) {
        Optional<Grant> optionalGrant = grandRepository.findById(grantId);
        return optionalGrant.get();
    }

    @Override
    public List<Grant> getAllGrant() {
        return grandRepository.findAll();
    }

    @Override
    public Grant updateGrant(Grant grant) {
        Grant existingGrant = grandRepository.findById(grant.getId()).get();
        existingGrant.setFirstName(grant.getFirstName());
        existingGrant.setLastName(grant.getLastName());
        existingGrant.setEmail(grant.getEmail());
        Grant updateGrant = grandRepository.save(existingGrant);
        return updateGrant;
    }

    @Override
    public void deleteGrant(Long grantId) {
        grandRepository.deleteById(grantId);
    }
}
