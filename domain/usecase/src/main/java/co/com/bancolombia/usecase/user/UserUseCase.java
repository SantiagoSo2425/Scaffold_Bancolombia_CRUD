package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }
}
