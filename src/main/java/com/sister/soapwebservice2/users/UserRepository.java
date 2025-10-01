package com.sister.soapwebservice2.users;

import com.sister.gen.users.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        // contoh dummy data
        User u1 = new User();
        u1.setNim("L0122142");
        u1.setNama("Rizal Dwi Anggoro");
        u1.setUmur(22);

        User u2 = new User();
        u2.setNim("L0122136");
        u2.setNama("Reni Uswatun Hasanah");
        u2.setUmur(22);

        users.put(u1.getNim(), u1);
        users.put(u2.getNim(), u2);
    }

    // CREATE
    public User create(User user) {
        Assert.notNull(user, "User must not be null");
        users.put(user.getNim(), user);

        return user;
    }

    // READ by id
    public User get(String nim) {
        Assert.notNull(nim, "NIM must not be null");
        return users.get(nim);
    }

    // READ all
    public Map<String, User> getAll() {
        return users;
    }

    // UPDATE
    public User update(String nim, User user) {
        Assert.notNull(nim, "Id must not be null");
        User existing = users.get(nim);
        if (existing != null) {
            existing.setNama(user.getNama());
            existing.setUmur(user.getUmur());
            users.put(nim, existing);

            return existing;
        }
        return null;
    }

    // DELETE
    public String delete(String nim) {
        Assert.notNull(nim, "NIM must not be null");
        return users.remove(nim) != null ? nim : null;
    }
}

