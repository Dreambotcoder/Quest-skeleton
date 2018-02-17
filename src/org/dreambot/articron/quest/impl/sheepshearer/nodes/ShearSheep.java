package org.dreambot.articron.quest.impl.sheepshearer.nodes;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.articron.quest.impl.sheepshearer.SheepShearerHandler;
import org.dreambot.articron.node.NodeTask;

public class ShearSheep extends NodeTask<SheepShearerHandler> {

    @Override
    public boolean isValid(SheepShearerHandler handler) {
        return handler.isSheepAround();
    }

    @Override
    public int execute(SheepShearerHandler handler) {
        if (handler.shearSheep()) {
            MethodProvider.sleep(200);
        }
        return 100;
    }
}
