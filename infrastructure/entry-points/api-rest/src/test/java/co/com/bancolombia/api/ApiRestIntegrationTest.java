package co.com.bancolombia.api;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {ApiRestApplication.class, ApiRestIntegrationTest.TestConfig.class})
@AutoConfigureMockMvc
@Import(ApiRest.class)
@ActiveProfiles("test")
class ApiRestIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UserUseCase userUseCase() {
            return Mockito.mock(UserUseCase.class);
        }

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }

    @Test
    void getUser_returnsUser_whenExists() throws Exception {
        User user = new User("1", "Juan", "juan@mail.com", "123", "Calle 1");
        Mockito.when(userUseCase.getUserById("1")).thenReturn(user);

        mockMvc.perform(get("/api/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Juan"));
    }

    @Test
    void getUser_returnsNotFound_whenNotExists() throws Exception {
        Mockito.when(userUseCase.getUserById(anyString())).thenReturn(null);

        mockMvc.perform(get("/api/999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void createUser_returnsCreatedUser_whenSuccess() throws Exception {
        User user = new User("2", "Maria", "maria@mail.com", "456", "Calle 2");
        Mockito.when(userUseCase.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.name").value("Maria"));
    }

    @Test
    void updateUser_returnsUpdatedUser_whenSuccess() throws Exception {
        User user = new User("1", "Juan Actualizado", "juan@mail.com", "123", "Calle 1 Nueva");
        Mockito.when(userUseCase.updateUser(any(User.class))).thenReturn(user);

        mockMvc.perform(put("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Juan Actualizado"))
                .andExpect(jsonPath("$.address").value("Calle 1 Nueva"));
    }

    @Test
    void deleteUser_returnsSuccess_whenUserDeleted() throws Exception {
        Mockito.doNothing().when(userUseCase).deleteUser(anyString());

        mockMvc.perform(delete("/api/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully"));
    }

    @Test
    void createUser_returnsServerError_whenException() throws Exception {
        User user = new User("3", "Carlos", "carlos@mail.com", "789", "Calle 3");
        Mockito.when(userUseCase.saveUser(any(User.class))).thenThrow(new RuntimeException("Error al guardar"));

        mockMvc.perform(post("/api/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
