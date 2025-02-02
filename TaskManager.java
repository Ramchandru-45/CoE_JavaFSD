package techm;



import java.util.PriorityQueue;
import java.util.Queue;

class Task implements Comparable<Task>{
	String id;
	String desc;
	int priority;
	public Task(String id, String desc, int priority) {
		super();
		this.id = id;
		this.desc = desc;
		this.priority = priority;
	}
	

	@Override
	public String toString() {
		return "Task [id=" + id + ", desc=" + desc + ", priority=" + priority + "]";
	}


	@Override
	public int compareTo(Task o) {
		if(this.priority==o.priority)return 0;
		else if(this.priority>o.priority)return 1;
		else return -1;
	}
	
}

public class TaskManager{
	
	Queue<Task> t;
	
	public TaskManager() {
		super();
		t=new PriorityQueue<Task>();
	}

	public void addTask(String id,String desc,int priority) {
		t.add(new Task(id,desc,priority));
	}
	
	public String removeTask(String id) {
		if(t.isEmpty()) {
			return "Queue is empty";
		}
		for(Task i:t) {
			if(i.id.equals(id)) {
				t.remove(i);
				break;
			}
		}
		return "Task "+id+" is removed";
	}
	public String getHighestPriorityTask() {
		if(t.isEmpty()) {
			return "empty queue";
		}
		Task temp=t.peek();
		int max=t.peek().priority;
		for(Task i:t) {
			if(i.priority>max) {
				max=i.priority;
				temp=i;
			}
		}
		return temp.toString();
	}

	
	public static void main(String [] args) {
		TaskManager tm=new TaskManager();
		tm.addTask("1", "calculator", 2);
		tm.addTask("3", "game", 10);
		tm.addTask("2", "Steam",4);
		System.out.println(tm.removeTask("1"));
		System.out.println(tm.getHighestPriorityTask());
		
	}
}

