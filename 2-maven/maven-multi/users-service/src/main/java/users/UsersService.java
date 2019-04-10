package users;

import java.math.BigDecimal;
import java.util.Set;

import com.google.common.collect.Sets;

public class UsersService {

    public Set<User> getUsers() {
        Set<User> result = Sets.newConcurrentHashSet();

        result.add(User.builder()
                .name("Ivaylo Kolev")
                .salary(BigDecimal.valueOf(0))
                .build());
        result.add(User.builder()
                .name("Georgy Georgiev")
                .salary(BigDecimal.valueOf(1e9))
                .build());

        return result;
    }

}