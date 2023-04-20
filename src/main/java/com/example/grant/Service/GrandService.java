package com.example.grant.Service;


import com.example.grant.Entity.Grant;

import java.util.List;

public interface GrandService {
     Grant createGrant(Grant grant);

     Grant getGrantById(Long grantId);

     List<Grant> getAllGrant();

     Grant updateGrant(Grant grant);

     void deleteGrant(Long grantId);
}
