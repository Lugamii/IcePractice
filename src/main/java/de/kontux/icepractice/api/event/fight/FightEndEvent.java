package de.kontux.icepractice.api.event.fight;

import de.kontux.icepractice.api.event.IcePracticeEvent;
import de.kontux.icepractice.api.match.IcePracticeFight;
import java.util.Collections;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class FightEndEvent extends IcePracticeEvent {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private final IcePracticeFight fight;
  
  private final List<Player> winners;
  
  private final List<Player> losers;
  
  private int winnerElo;
  
  private int loserElo = 0;
  
  public FightEndEvent(IcePracticeFight fight, List<Player> winners, List<Player> losers) {
    super("FightEndEvent");
    this.fight = fight;
    this.winners = winners;
    this.losers = losers;
  }
  
  public FightEndEvent(IcePracticeFight fight, Player winner, Player loser, int winnerElo, int loserElo) {
    this(fight, Collections.singletonList(winner), Collections.singletonList(loser));
    this.winnerElo = winnerElo;
    this.loserElo = loserElo;
  }
  
  public HandlerList getHandlers() {
    return HANDLERS;
  }
  
  public IcePracticeFight getFight() {
    return this.fight;
  }
  
  public List<Player> getWinners() {
    return this.winners;
  }
  
  public List<Player> getLosers() {
    return this.losers;
  }
  
  public boolean affectsElo() {
    return this.fight.isRanked();
  }
  
  public void setWinnerElo(int winnerElo) {
    this.winnerElo = winnerElo;
  }
  
  public void setLoserElo(int loserElo) {
    this.loserElo = loserElo;
  }
  
  public int getWinnerElo() {
    return this.winnerElo;
  }
  
  public int getLoserElo() {
    return this.loserElo;
  }
  
  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
