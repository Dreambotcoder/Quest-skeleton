package org.dreambot.articron.quest.impl.sheepshearer;

import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.articron.quest.QuestHandler;

public class SheepShearerHandler implements QuestHandler {

    private MethodContext context;

    public SheepShearerHandler(MethodContext context) {
        this.context = context;
    }

    @Override
    public MethodContext getDreambot() {
        return context;
    }

    public boolean isSheepAround() {
        return getSheep() != null;
    }

    private NPC getSheep() {
        return getDreambot().getNpcs().closest("Sheep");
    }

    public boolean shearSheep() {
        return isSheepAround() && getSheep().interact("Shear");
    }

}
