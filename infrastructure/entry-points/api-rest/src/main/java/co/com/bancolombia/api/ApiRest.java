package co.com.bancolombia.api;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
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
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final UserUseCase userUseCase;

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        try {
            User user = userUseCase.getUserById(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Handle exceptions appropriately
        }
    }
    @PostMapping(path ="/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User savedUser = userUseCase.saveUser(user);
            return ResponseEntity.status(201).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Handle exceptions appropriately
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        try {
            userUseCase.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); // Handle exceptions appropriately
        }
    }
    @PutMapping(path = "/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User updatedUser = userUseCase.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Handle exceptions appropriately
        }
    }
}
