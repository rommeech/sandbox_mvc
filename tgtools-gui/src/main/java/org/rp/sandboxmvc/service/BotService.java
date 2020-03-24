package org.rp.sandboxmvc.service;

import org.rp.sandboxmvc.model.Bot;

import java.util.List;

public interface BotService {

    Bot getById(Long id);

    void update(Bot entity);

    void insert(Bot entity);

    void delete(Bot entity);

    List<Bot> getAllBots();

    List<Bot> getBots();

    Long countBots();

    Bot getByToken(String token);

    Bot getByUsername(String username);

    boolean isTokenUnique(String token, Long id);

    boolean isUsernameUnique(String username, Long id);

    void doGetMeRequest(Bot bot) throws ServiceException;
}
