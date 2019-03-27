package projects;

import java.math.BigDecimal;
import java.util.Set;

import com.google.common.collect.Sets;

public class UsersService {

    public Set<User> getUsers() {
        Set<User> result = Sets.newConcurrentHashSet();

        result.add(User.builder()
                .name("Training")
                .salary(BigDecimal.valueOf(0))
                .build());
        result.add(User.builder()
                .name("RBS")
                .salary(BigDecimal.valueOf(1e9))
                .build());

        return result;
    }

}
