package net.migrationcms.loginapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.migrationcms.loginapi.model.AppUser;
import net.migrationcms.loginapi.repository.AppUserRepository;

import lombok.Data;

@Data
@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public Optional<AppUser> getAppUser(final int id) {
        return appUserRepository.findById(id);
    }

    public Iterable<AppUser> getAppUsersList() {
        return appUserRepository.findAll();
    }

    public AppUser saveAppUser(AppUser appUser) {
        AppUser savedAppUser = appUserRepository.save(appUser);

        return savedAppUser;
    }

    public void deleteAppUser(final int id) {
        appUserRepository.deleteById(id);
    }
}
