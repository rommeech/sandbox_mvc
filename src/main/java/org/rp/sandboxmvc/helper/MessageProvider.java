package org.rp.sandboxmvc.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageProvider {

    private static final Logger logger  = LogManager.getLogger(MessageProvider.class);
    private Deque<String> infoMessages  = new ArrayDeque<>();
    private Deque<String> warnMessages  = new ArrayDeque<>();
    private Deque<String> errorMessages = new ArrayDeque<>();

    public void addInfoMessage(String msg) {
        infoMessages.offerLast(msg);
    }

    public boolean hasInfoMessages() {
        return !infoMessages.isEmpty();
    }

    public String getInfoMessage() {
        return infoMessages.pollFirst();
    }

    public Deque<String> getAllInfoMessages() {
        Deque<String> messages = ((ArrayDeque)infoMessages).clone();
        infoMessages.clear();
        return messages;
    }

    public void addWarningMessage(String msg) {
        warnMessages.offerLast(msg);
    }

    public boolean hasWarningMessages() {
        return !warnMessages.isEmpty();
    }

    public String getWarningMessage() {
        return warnMessages.pollFirst();
    }

    public Deque<String> getAllWarningMessages() {
        Deque<String> messages = ((ArrayDeque)warnMessages).clone();
        warnMessages.clear();
        return messages;
    }

    public void addErrorMessage(String msg) {
        errorMessages.offerLast(msg);
    }

    public boolean hasErrorMessages() {
        return !errorMessages.isEmpty();
    }

    public String getErrorMessage() {
        return errorMessages.pollFirst();
    }

    public Deque<String> getAllErrorMessages() {
        Deque<String> messages = ((ArrayDeque)errorMessages).clone();
        errorMessages.clear();
        return messages;
    }
}
