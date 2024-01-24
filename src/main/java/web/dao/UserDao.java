package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDao implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public UserDao() {}

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> q=entityManager.createQuery("select u from User u where u.id=:id", User.class);
        q.setParameter("id",id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }
}