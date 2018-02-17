package org.dreambot.articron.node;

import org.dreambot.articron.quest.QuestHandler;

public abstract class NodeTask<T extends QuestHandler> {

    public abstract boolean isValid(T handler);
    public abstract int execute(T handler);

}
