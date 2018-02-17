package org.dreambot.articron.quest;

import org.dreambot.api.methods.quest.Quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuestManager {

    private List<AbstractQuest<? extends QuestHandler>> quests;

    public QuestManager() {
        this.quests = new ArrayList<>();
    }

    public void addQuests(AbstractQuest... quests) {
        Collections.addAll(this.quests,quests);
    }

    public AbstractQuest getFirstUnfinishedQuest() {
        return getQuest(quest -> !quest.isFinished());
    }

    /*
     * All sort of getters to fit your needs
     */

    public List<AbstractQuest> getAllStartedQuests() {
        return quests.stream().filter(AbstractQuest::hasStarted).collect(Collectors.toList());
    }

    public List<AbstractQuest> getAllFinishedQuests() {
        return quests.stream().filter(AbstractQuest::isFinished).collect(Collectors.toList());
    }

    public List<AbstractQuest> getNonStartedQuests() {
        return quests.stream().filter(quest -> !quest.isFinished() && !quest.hasStarted()).collect(Collectors.toList());
    }

    public Quest[] getAddedQuests() {
        List<Quest> quests = new ArrayList<>();
        for (AbstractQuest quest : this.quests) {
            quests.add(quest.getQuest());
        }
        return quests.toArray(new Quest[quests.size()]);
    }

    public AbstractQuest getQuest(Quest constant) {
        return quests.stream().filter(quest -> quest.getQuest() == constant).findFirst().orElse(null);
    }

    public AbstractQuest getQuest(Predicate<AbstractQuest> predicate) {
        return quests.stream().filter(predicate::test).findFirst().orElse(null);
    }

}
