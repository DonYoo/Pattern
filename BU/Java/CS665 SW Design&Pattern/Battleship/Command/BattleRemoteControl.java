package Command;

public class BattleRemoteControl{
	BattleshipCommand[] BattleshipCommands;

	public BattleRemoteControl(){
		BattleshipCommands = new BattleshipCommand[2];
	}
			
	public void setCommand(int i, BattleshipCommand command) {
		BattleshipCommands[i] = command;
	}

	public void AttackButton(int i) {
		BattleshipCommands[i].execute();		
	}

	@Override
	public String toString() {
        return "This is Battleship remoteControl";
    }
}
