package co.com.bancolombia.model.user.gateways;

import co.com.bancolombia.model.user.User;

public interface UserRepository {
   User getUserById(String id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String id);

}
