package org.dreambot.articron;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.articron.quest.impl.sheepshearer.SheepShearerHandler;
import org.dreambot.articron.quest.AbstractQuest;
import org.dreambot.articron.quest.QuestManager;
import org.dreambot.articron.quest.impl.sheepshearer.SheepShearer;

@ScriptManifest(category = Category.QUEST, name = "Quest skeleton", author ="Articron" , version = 1.0D)
public class QuestScript extends AbstractScript {

    /*
     * Add all quests in the below form, AbstractQuest<HandlerName>
     */
    private AbstractQuest<SheepShearerHandler> sheepShearer;

    private QuestManager questManager;

    @Override
    public void onStart() {

        /*
         * We'll need the quest manager
         */
        questManager = new QuestManager();
        /*
         * Make an instance of each quest
         */
        sheepShearer = new SheepShearer(new SheepShearerHandler(this)); //make it a  new object

        /*
         * Then add all the quests you wish to do in the quest manager
         */
        questManager.addQuests(sheepShearer);
    }

    @Override
    public int onLoop() {
        /*
         * Get the first unfinished quest
         */
        AbstractQuest quest = questManager.getFirstUnfinishedQuest();
        if (quest == null)
            return -1; //all quests completed!
        /*
         * return the quest's onLoop!
         */
        return quest.onLoop();
    }
}
