package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class StageTeam implements Team {

    private final List<Entity> member;
    private int current = -1;

    StageTeam(List<Entity> member) {
        this.member = new ArrayList<>(member);
    }

    private boolean removeDead() {
        return this.member.removeIf(member -> member.getHealth() == 0);
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
    public boolean hasFinished() {
        return this.current == 0;
    }

    @Override
    public void prepareTurn() {
        this.member.forEach(Entity::prepareTurn);
    }

    @Override
    public Entity getTurnEntity() {
        this.current = NumberUtils.getNext(this.current, this.member.size());
        return this.member.get(current);
    }

    @Override
    public Entity[] getMember() {
        return this.member.toArray(Entity[]::new);
    }
}