package net.migrationcms.loginapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.migrationcms.loginapi.model.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer>{

}
