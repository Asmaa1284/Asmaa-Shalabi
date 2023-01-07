import java.util.*;

public final class Worker {

	private final String name;
	private final int id;
	private final Supervisor boss;
	
	
	public Worker(String name, int id, Supervisor boss) {
		this.name = name;
		this.id=id;
		this.boss=boss;
		
	}


	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public Supervisor getBoss() {
		return boss;
	}


	@Override
	public String toString() {
		return "Worker [name=" + name + ", id=" + id + ", supervisor=" + boss + "]";
	}
}