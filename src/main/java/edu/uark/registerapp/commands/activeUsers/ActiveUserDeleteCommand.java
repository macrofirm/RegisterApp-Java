package edu.uark.registerapp.commands.activeUsers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

@Service
public class ActiveUserDeleteCommand implements VoidCommandInterface{
    @Override
    @Transactional
    public void execute() {
        Optional<ActiveUserEntity> activeUserEntity = 
            activeUserRepository.findBySessionKey(this.sessionKey);
        if(activeUserEntity.isPresent()) {
            activeUserRepository.delete(activeUserEntity.get());
        }
    }

    // Properties
    private String sessionKey;
    public ActiveUserDeleteCommand setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }


    @Autowired
    private ActiveUserRepository activeUserRepository;
}