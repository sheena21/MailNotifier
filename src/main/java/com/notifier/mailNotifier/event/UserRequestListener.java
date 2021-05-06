package com.notifier.mailNotifier.event;

import com.notifier.mailNotifier.entity.UserRequest;
import com.notifier.mailNotifier.sequencer.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserRequestListener extends AbstractMongoEventListener<UserRequest> {

    private SequenceGenerator sequenceGenerator;

    @Autowired
    public UserRequestListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<UserRequest> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(UserRequest.SEQUENCE_NAME));
        }
    }

}
