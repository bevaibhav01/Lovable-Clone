package com.project.lovable_clone.dto.auth;


//record is new class
//all are private and final be default
public record AuthResponse(
        String token,
        UserProfileResponse user

) {

}

//dummy new AuthResponse("",user);

