package co.com.bancolombia.api;
import co.com.bancolombia.api.config.ApiMetrics;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import io.micrometer.core.instrument.Timer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@Tag(name = "User API", description = "Operaciones de usuario")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final UserUseCase userUseCase;
    private final ApiMetrics apiMetrics;

    @Operation(summary = "Obtener usuario por ID")
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        Timer.Sample timer = apiMetrics.startTimer();
        try {
            User user = userUseCase.getUserById(id);
            apiMetrics.incrementCounter("api.users.get.count");
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            apiMetrics.incrementCounter("api.users.error.count");
            return ResponseEntity.status(500).body(null);
        } finally {
            apiMetrics.stopTimer(timer, "api.users.get.time");
        }
    }

    @Operation(summary = "Crear usuario")
    @PostMapping(path ="/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Timer.Sample timer = apiMetrics.startTimer();
        try {
            User savedUser = userUseCase.saveUser(user);
            apiMetrics.incrementCounter("api.users.create.count");
            return ResponseEntity.status(201).body(savedUser);
        } catch (Exception e) {
            apiMetrics.incrementCounter("api.users.error.count");
            return ResponseEntity.status(500).body(null);
        } finally {
            apiMetrics.stopTimer(timer, "api.users.create.time");
        }
    }

    @Operation(summary = "Eliminar usuario")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        Timer.Sample timer = apiMetrics.startTimer();
        try {
            userUseCase.deleteUser(id);
            apiMetrics.incrementCounter("api.users.delete.count");
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            apiMetrics.incrementCounter("api.users.error.count");
            return ResponseEntity.status(500).build();
        } finally {
            apiMetrics.stopTimer(timer, "api.users.delete.time");
        }
    }

    @Operation(summary = "Actualizar usuario")
    @PutMapping(path = "/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Timer.Sample timer = apiMetrics.startTimer();
        try {
            User updatedUser = userUseCase.updateUser(user);
            apiMetrics.incrementCounter("api.users.update.count");
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            apiMetrics.incrementCounter("api.users.error.count");
            return ResponseEntity.status(500).body(null);
        } finally {
            apiMetrics.stopTimer(timer, "api.users.update.time");
        }
    }
}
