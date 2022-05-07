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
    entityManager.flush();
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {return getListUsers().get(id);
    }

    @Override
    public void updateUserById(int id,User user) {

        User bDUser = getUserById(id);
        bDUser.setPenisSize(user.getPenisSize());
        bDUser.setName(user.getName());
        bDUser.setDrove(user.getDrove());
        entityManager.merge(bDUser);
        entityManager.flush();
    }

    @Override
    public void deleteUserById(int id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
