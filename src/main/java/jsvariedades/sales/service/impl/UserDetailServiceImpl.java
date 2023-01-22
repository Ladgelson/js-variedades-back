package jsvariedades.sales.service.impl;

import jsvariedades.sales.model.UserModel;
import jsvariedades.sales.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.info("m=loadUserByUsername stage=error username={}", username);
                    return new UsernameNotFoundException("User not found: " + username);
                });
        return new UserModel()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setRole(user.getRole());
    }
}
