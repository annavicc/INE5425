
package model;
public class Message {
	
	public enum Direction {
		LL, LR,
		RL, RR,
		PRec
	}
	public enum UserType {
		Local,
		Remote
	}
	public enum Status {
		Fail,
		Success,
		Postpone
	}
	
	private UserType sender;
	private UserType receiver;
	private Status status;
	private Direction direction;
	private boolean completed;
	private double totalTime;
	private double serviceTime;
	private double arrivalTime;
	private int id;
	private final double limitTime = 2;
	private boolean isAtReception;
	private Distribution dist;
	
	public Message(int dir, double arrivalTime, int id) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		completed = false;
		dist = new Distribution();
		this.arrivalTime = arrivalTime;
		isAtReception = true;
		setSenderReceiver(dir);
		setDirection();
		setMessageStatus();
		setServiceTime();
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public double getArrivalTime() {
		return this.arrivalTime;
	}
	
	public double getServiceTime() {
		return this.serviceTime;
	}
	
	public double getTotalTime() {
		return totalTime;
	}
	
	public double getLimitTime() {
		return this.limitTime;
	}
	
	public void setTotalTime(double t) {
		totalTime = t - arrivalTime;
	}
	
	public void setCompleted() {
		completed = true;
	}
	
	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void outReception() {
		this.isAtReception = false;
	}
	
	public boolean isAtRec() {
		return this.isAtReception;
	}
	private void setSenderReceiver(int dir) {
		switch (dir) {
		case 1: {
			this.sender = UserType.Local;
			this.receiver = UserType.Local;
		}; break;
		case 2: {
			this.sender = UserType.Local;
			this.receiver = UserType.Remote;
		}; break;
		case 3: {
			this.sender = UserType.Remote;
			this.receiver = UserType.Local;
		}; break;
		case 4: {
			this.sender = UserType.Remote;
			this.receiver = UserType.Remote;
		}; break;
		}
	}
	
	public void setMessageStatus() {
		double successRate, failRate, delayRate;
 		double[] rates = ValuesConfiguration.getInstance().getStatus();
		switch(direction) {
		case LL: {
			successRate = rates[0];
			failRate = rates[1];
			delayRate = rates[2];
		}; break;
		case LR: {
			successRate = rates[3];
			failRate = rates[4];
			delayRate = rates[5];
		}; break;
		case RL: {
			successRate = rates[6];
			failRate = rates[7];
			delayRate = rates[8];
		}; break;
		default: {
			successRate = rates[9];
			failRate = rates[10];
			delayRate = rates[11];
		}; break;
		}
		double st = dist.monteCarlo(successRate, failRate, delayRate);
		if (st == 1) {
			this.status = Status.Success;
		} else if (st == 2) {
			this.status = Status.Fail;
		} else {
			this.status = Status.Postpone;
		}
	}
	
	public void setServiceTime() {
		double rates[] = new double[4];
		ValuesConfiguration r = ValuesConfiguration.getInstance();
		switch (direction) {
		case LL: {
			if (this.status == Status.Success) {
				rates = r.getLLS();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
				//get all values
			} else if (this.status == Status.Fail) {
				rates = r.getLLF();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else {
				rates = r.getLLA();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			}
		}; break;
		
		case LR: {
			if (this.status == Status.Success) {
				rates = r.getLRS();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else if (this.status == Status.Fail) {
				rates = r.getLRF();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else {
				rates = r.getLRA();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			}
		}; break;
		case RL: {
			if (this.status == Status.Success) {
				rates = r.getRLS();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else if (this.status == Status.Fail) {
				rates = r.getRLF();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else {
				rates = r.getRLA();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			}
		};
		default: {
			if (this.status == Status.Success) {
				rates = r.getRRS();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else if (this.status == Status.Fail) {
				rates = r.getRRF();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			} else if (this.status == Status.Postpone){
				rates = r.getRRA();
				calculateST(rates[0], rates[1], rates[2], rates[3]);
			}
		};
		}
	}
	
	private void calculateST(double value1, double value2, double value3, double type) {
		double ts;
		if (type == 0.0) {
			ts = dist.calculateNormal(value1, value2);
		} else if (type == 1.0) {
			ts = dist.calculateTriangular(value1, value2, value3);
		} else if (type == 2.0) {
			ts = dist.calculateUniform(value1, value2);
		} else {
			ts = value1 * 0.01;
		}
		
		this.serviceTime = ts;
	}

	
	private void setDirection() {
		if (this.sender == UserType.Local) {
			if (this.receiver == UserType.Local) {
				this.direction = Direction.LL;
			} else {
				this.direction = Direction.LR;
			}
		} else {
			if (this.receiver == UserType.Local) {
				this.direction = Direction.RL;
			} else {
				this.direction = Direction.RR;
			}
		}
	}
	
	
	
	/* Enum to String */
	public String getDirection() {
		switch(direction) {
		case LL: return "LL";
		case LR: return "LR";
		case RL: return "RL";
		default: return "RR";
		}
	}
	
	public String getMessageStatus() {
		switch(status) {
		case Fail: return "Falha";
		case Success: return "Successo";
		default: return "Adiada";
		}
	}
	
	public String getSender() {
		if (this.sender == UserType.Local) {
			return "Local";
		} else {
			return "Remote";
		}
	}
	
	public String getReceiver() {
		if (this.receiver == UserType.Local) {
			return "Local";
		} else {
			return "Remote";
		}
	}
	
	public void setMessageStatus(String s) {
		switch(s) {
		case "Fail":
			this.status = Status.Fail;
			break;
		case "Sucess":
			this.status = Status.Success;
			break;
		case "Postpone":
			this.status = Status.Postpone;
			break;
		}
	}
	
	public void updateStatusStats() {
		switch(direction) {
			case LL: {
				if (this.status.equals(Status.Success)) {
					Statistics.LLS++;
				} else if (this.status.equals(Status.Fail)){
					Statistics.LLF++;
				} else {
					Statistics.LLA++;
				}
			}; break;
			case LR: {
				if (this.status.equals(Status.Success)) {
					Statistics.LRS++;
				} else if (this.status.equals(Status.Fail)){
					Statistics.LRF++;
				} else {
					Statistics.LRA++;
				}
			}; break;
			case RL: {
				if (this.status.equals(Status.Success)) {
					Statistics.RLS++;
				} else if (this.status.equals(Status.Fail)){
					Statistics.RLF++;
				} else {
					Statistics.RLA++;
				}
			}; break;
			default: {
				if (this.status.equals(Status.Success)) {
					Statistics.RRS++;
				} else if (this.status.equals(Status.Fail)){
					Statistics.RRF++;
				} else {
					Statistics.RRA++;
				}
			}; break;
		}
		Statistics.updateTypeCount();
	}

	
	
}
