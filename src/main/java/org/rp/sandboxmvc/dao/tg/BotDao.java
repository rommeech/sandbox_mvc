package org.rp.sandboxmvc.dao.tg;

import org.rp.sandboxmvc.dao.AbstractDao;
import org.rp.sandboxmvc.model.tg.Bot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BotDao extends AbstractDao<Bot, Long> {

    public Bot getByToken(String token) {
        List<Bot> bots = this.getEntityManager()
                .createQuery("FROM Bot WHERE token=:token")
                .setParameter("token", token)
                .setMaxResults(1)
                .getResultList();
        return bots.isEmpty() ? null : bots.get(0);
    }

    public Bot getByUsername(String username) {
        List<Bot> bots = this.getEntityManager()
                .createQuery("FROM Bot WHERE username=:username")
                .setParameter("username", username)
                .setMaxResults(1)
                .getResultList();
        return bots.isEmpty() ? null : bots.get(0);
    }
}
