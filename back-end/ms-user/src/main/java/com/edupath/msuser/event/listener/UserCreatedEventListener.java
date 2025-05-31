package com.edupath.msuser.event.listener;

import com.edupath.msuser.event.model.UserCreatedEvent;
import com.edupath.msuser.model.UserProfile;
import com.edupath.msuser.repository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListener {

    private static final Logger logger = LoggerFactory.getLogger(UserCreatedEventListener.class);

    private final UserProfileRepository userProfileRepository;

    public UserCreatedEventListener(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @RabbitListener(queues = "${queue.name}")
    public void handleUserCreated(UserCreatedEvent event) {
        logger.info("Recebido evento de criação de usuário: {}", event);

        UserProfile profile = new UserProfile();
        profile.setUserId(event.getUserId());
        profile.setBio(null);
        profile.setInterestArea(null);
        profile.setExperienceLevel(null);

        userProfileRepository.save(profile);
    }
}

