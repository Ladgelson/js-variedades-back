package jsvariedades.sales.service.impl;

import jsvariedades.sales.exceptions.NotFound;
import jsvariedades.sales.model.UserModel;
import jsvariedades.sales.repository.UserRepository;
import jsvariedades.sales.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow( () -> {
            logger.error("m=findById id={} stage=error message=User was not found", id);
            throw new NotFound("User was not found");
        });
    }
}
