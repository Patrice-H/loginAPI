package net.migrationcms.loginapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.migrationcms.loginapi.model.AppUser;
import net.migrationcms.loginapi.service.AppUserService;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/users")
    public Iterable<AppUser> getUsersList() {
        return appUserService.getAppUsersList();
    }

    @GetMapping("/user/{id}")
	public AppUser getUser(@PathVariable("id") final int id) {
		Optional<AppUser> appUser = appUserService.getAppUser(id);
		if(appUser.isPresent()) {
            
			return appUser.get();
		} else {
			return null;
		}
	}

    @PutMapping("/employee/{id}")
	public AppUser updateUser(@PathVariable("id") final int id, @RequestBody AppUser appUser) {
		Optional<AppUser> optionalUser = appUserService.getAppUser(id);
		if(optionalUser.isPresent()) {
			AppUser currentUser = optionalUser.get();
			
			String firstName = appUser.getFirstName();
			if(firstName != null) {
				currentUser.setFirstName(firstName);
			}
			String lastName = appUser.getLastName();
			if(lastName != null) {
				currentUser.setLastName(lastName);;
			}
			String mail = appUser.getMail();
			if(mail != null) {
				currentUser.setMail(mail);
			}
			String password = appUser.getPassword();
			if(password != null) {
				currentUser.setPassword(password);;
			}
			appUserService.saveAppUser(currentUser);

			return currentUser;
		} else {
			return null;
		}
	}
}
