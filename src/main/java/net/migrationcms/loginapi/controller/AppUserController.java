package net.migrationcms.loginapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.migrationcms.loginapi.model.AppUser;
import net.migrationcms.loginapi.service.AppUserService;

@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

	/**
	 * Get users list
	 * @return The list of users
	 */
    @GetMapping("/users")
    public Iterable<AppUser> getUsersList() {
        return appUserService.getAppUsersList();
    }

	/**
	 * Get user by id
	 * @param id - the user's id
	 * @return The user if exists or null
	 */
    @GetMapping("/user/{id}")
	public AppUser getUser(@PathVariable("id") final int id) {
		Optional<AppUser> appUser = appUserService.getAppUser(id);
		if(appUser.isPresent()) {
            
			return appUser.get();
		} else {
			return null;
		}
	}

	@PostMapping("/users")
	public AppUser saveUser(@RequestBody AppUser appUser) {
		AppUser savedAppUser = appUserService.saveAppUser(appUser);
		System.out.println(appUser);
		System.out.println(savedAppUser);

		return savedAppUser;
	}

	/**
	 * Update user's data
	 * @param id - the user's id
	 * @param appUser - the user
	 * @return The user if exists or null
	 */
    @PutMapping("/user/{id}")
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

	/**
	 * Delete user
	 * @param id - The user's id
	 */
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final int id) {
		appUserService.deleteAppUser(id);
	}
}
