package co.com.bancolombia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "`user`")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

}
