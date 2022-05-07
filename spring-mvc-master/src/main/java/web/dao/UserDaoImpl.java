package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
    entityManager.persist(user);
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {return   getListUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void updateUserById(int id,User userLast) {
        User user = getUserById(id);
        user.setPenisSize(userLast.getPenisSize());
        user.setName(userLast.getName());
        user.setDrove(userLast.getDrove());
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.remove(getUserById(id));
    }
}
