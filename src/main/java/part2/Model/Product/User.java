package part2.Model.Product;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1186420022717722774L;

    UUID uuid = UUID.randomUUID();

    String name;

    public User(String name) {
        this.name = name;
    }
}
