package edu.miu.cs590.accountservice.service;

import edu.miu.cs590.accountservice.dto.AppUserResponse;
import edu.miu.cs590.accountservice.model.AppUser;
import edu.miu.cs590.accountservice.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepo appUserRepo;

    public void createUser(AppUser appUser) {
        appUserRepo.save(appUser);
    }
    public List<AppUserResponse> getAllUser() {
        List<AppUser> appUsers = appUserRepo.findAll();
        List<AppUserResponse> appUserResponses = appUsers.stream().map(this::mapToAppUserResponse).toList();
        return appUserResponses;
    }

    public AppUserResponse getUserByEmail(String email) {
        AppUser appUser = appUserRepo.findByEmail(email);
        AppUserResponse appUserResponse = AppUserResponse.builder()
                .Id(appUser.getId())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .email(appUser.getEmail())
                .isActive(appUser.isActive())
                .defaultPaymentMethod(appUser.getDefaultPaymentMethod())
                .shippingAddress(appUser.getShippingAddress())
                .password(appUser.getPassword())
                .build();
        return appUserResponse;
    }

    private AppUserResponse mapToAppUserResponse(AppUser appUser) {
        AppUserResponse appUserResponse = new AppUserResponse();
        appUserResponse.setId(appUser.getId());
        appUserResponse.setEmail(appUser.getEmail());
        appUserResponse.setPassword(appUser.getPassword());
        appUserResponse.setFirstName(appUser.getFirstName());
        appUserResponse.setLastName(appUser.getLastName());
        appUserResponse.setActive(appUser.isActive());
        appUserResponse.setShippingAddress(appUser.getShippingAddress());
        appUserResponse.setDefaultPaymentMethod(appUser.getDefaultPaymentMethod());
        return appUserResponse;
    }

    public Boolean updateUser(Long id, AppUser appUser) {
        Optional<AppUser> appUser1 = appUserRepo.findById(id);
        if (appUser1.isPresent()){
           appUserRepo.save(appUser);
           return true;
        }
        return false;
    }
}
