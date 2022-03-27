package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.util.SaveIterator;

import java.util.ArrayList;
import java.util.List;

public class StageTeam implements Team {

    private final Stage stage;
    private final List<Entity> member;
    private SaveIterator<Entity> turn;

    StageTeam(Stage stage, List<Entity> member) {
        this.stage = stage;
        this.member = new ArrayList<>(member);
    }

    private boolean removeDead() {
        return this.member.removeIf(member -> member.getHealth() == 0);
    }

    private void prepareTurn() {
        this.member.forEach(Entity::prepareTurn);
    }

    @Override
    public boolean hasMember(Entity entity) {
        return this.member.contains(entity);
    }

    @Override
    public boolean isDead() {
        return this.removeDead() && this.member.size() == 0;
    }

    @Override
    public void next() {
        if (this.turn.isFinished() || this.stage.isOver()) this.stage.next();
        else this.turn.next().turn(this, this.stage.getOpponents(this));
    }

    @Override
    public void turn() {
        this.prepareTurn();
        this.turn = new SaveIterator<>(this.member);
        this.next();
    }

    @Override
    public Entity[] getMember() {
        return this.member.toArray(Entity[]::new);
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }
}