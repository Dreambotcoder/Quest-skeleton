package org.dreambot.articron.quest;

import org.dreambot.api.methods.quest.Quest;
import org.dreambot.articron.node.NodeTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractQuest<T extends QuestHandler> {

    /**
     */
    private List<NodeTask<T>> nodes;
    private T handler;


    public AbstractQuest(T handler) {
        nodes = new ArrayList<>();
        loadNodes();
        this.handler = handler;
    }

    public void addNodes(NodeTask... tasks) {
        Collections.addAll(nodes,tasks);
    }

    public int onLoop() {
        for (NodeTask<T> task : nodes) {
            if (task.isValid(handler)) {
                return task.execute(handler);
            }
        }
        return 600;
    }

    public T getHandler() {
        return handler;
    }

    /*
     * Returns if we started the quest
     */
    public abstract boolean hasStarted();

    /*
     * Returns if we finished the quest
     */
    public abstract boolean isFinished();

    /*
     * The playersetting used to track our progression
     */
    public abstract int getPlayerSetting();

    /*
     * Load in your nodes
     */
     protected abstract void loadNodes();

    /*
     * The Quest enum constant equivalent
     */
    public abstract Quest getQuest();

}
