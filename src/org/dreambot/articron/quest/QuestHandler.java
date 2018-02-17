package org.dreambot.articron.quest;

import org.dreambot.api.methods.MethodContext;

public interface QuestHandler {

    /*
     * the context for using Dreambot's default API
     */
    MethodContext getDreambot();

    /*
     * You could add the abstract fields from AbstractQuest in here too, depending on your needs
     */
}
