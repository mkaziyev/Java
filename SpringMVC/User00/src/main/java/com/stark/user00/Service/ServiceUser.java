package com.stark.user00.Service;

/**
 * Created by m on 12/02/2016.
 */
import java.util.List;

import com.stark.user00.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class ServiceUser {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<User> searchUsers(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        //criteria.createAlias("name", "n");
        criteria.add(Restrictions.ilike("name", name+"%"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.list();
    }

    @Transactional
    public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
    }

    @Transactional
    public void updateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
    }

    @Transactional
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        if (null != u) {
            session.delete(u);
        }
    }

    @Transactional
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.get(User.class, new Integer(id));
        return u;
    }

    @Transactional
    public void edit(User user) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();
        // Retrieve existing person via id
        User existingUser = (User) session.get(User.class, user.getId());
        // Assign updated values to this person
        existingUser.setName(user.getName());
        existingUser.setAge(existingUser.getAge());
        existingUser.setAdmin(existingUser.getAdmin());
        // Save updates
        session.save(existingUser);
    }
}
