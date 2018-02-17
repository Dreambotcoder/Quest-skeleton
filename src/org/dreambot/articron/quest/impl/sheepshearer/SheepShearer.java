package org.dreambot.articron.quest.impl.sheepshearer;

import org.dreambot.api.methods.quest.Quest;
import org.dreambot.articron.quest.impl.sheepshearer.nodes.ShearSheep;
import org.dreambot.articron.quest.AbstractQuest;

public class SheepShearer extends AbstractQuest<SheepShearerHandler> {

    public SheepShearer(SheepShearerHandler handler) {
        super(handler);
    }

    @Override
    public boolean hasStarted() {
        return getPlayerSetting() == 0; //example
    }

    @Override
    public boolean isFinished() {
        return getPlayerSetting() == 1; //example
    }

    @Override
    public int getPlayerSetting() {
        return getHandler().getDreambot().getPlayerSettings().getConfig(100); //example
    }

    @Override
    protected void loadNodes() {
        addNodes(new ShearSheep());
    }

    @Override
    public Quest getQuest() {
        return Quest.SHEEP_SHEARER;
    }
}
