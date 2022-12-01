package kz.narxoz.springpandora2.Service;

import kz.narxoz.springpandora2.Entity.Auth.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users createUser(Users user);
    Users getUserByEmail(String email);
}
