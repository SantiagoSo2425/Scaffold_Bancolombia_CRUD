package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {
    private UserRepository userRepository;
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userUseCase = new UserUseCase(userRepository);
    }

    @Test
    void getUserById_returnsUser() {
        User user = new User("1", "Juan", "juan@mail.com", "123", "Calle 1");
        when(userRepository.getUserById("1")).thenReturn(user);
        User result = userUseCase.getUserById("1");
        assertNotNull(result);
        assertEquals("Juan", result.getName());
    }

    @Test
    void saveUser_returnsSavedUser() {
        User user = new User("2", "Ana", "ana@mail.com", "456", "Calle 2");
        when(userRepository.saveUser(user)).thenReturn(user);
        User result = userUseCase.saveUser(user);
        assertEquals("Ana", result.getName());
    }

    @Test
    void updateUser_returnsUpdatedUser() {
        User user = new User("3", "Luis", "luis@mail.com", "789", "Calle 3");
        when(userRepository.updateUser(user)).thenReturn(user);
        User result = userUseCase.updateUser(user);
        assertEquals("Luis", result.getName());
    }

    @Test
    void deleteUser_invokesRepository() {
        doNothing().when(userRepository).deleteUser("4");
        userUseCase.deleteUser("4");
        verify(userRepository, times(1)).deleteUser("4");
    }
}

