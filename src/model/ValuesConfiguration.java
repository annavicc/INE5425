package model;

public class ValuesConfiguration {

	private static ValuesConfiguration rc;
	private double[] tecs = { 0.5, 0.6 };
	private double[] traffic = { 50, 25, 10, 15 };
	private double reception = 0.12;
	private int serverLocal = 3;
	private int serverRemote = 5;
	private double[] status = {
			87, 0.50, 12.50, 96,
			1.5, 2.5, 96, 3,
			1, 90, 1, 9
	};
	private double[] distLLS = { 0.55, 0.05, -1, 0 };
	private double[] distLLF = { 0.02, 0.05, 0.12, 1 };
	private double[] distLLA = { 0.06, 0.15, -1 , 2 };
	private double[] distLRS = { 0.65, 0.04, -1, 0 };
	private double[] distLRF = { 0.16, 0.25, -1, 2 };
	private double[] distLRA = { 0.05, 0.07, 0.1, 1 };
	private double[] distRLS = { 0.09, 0.18, -1, 2 };
	private double[] distRLF = { 0.08, 0.15, -1, 0 };
	private double[] distRLA = { 0.63, 0.04, -1, 0 };
	private double[] distRRS = { 0.46, 0.05, -1, 2 };
	private double[] distRRF = { 0.03, 0.11, 0.22, 1 };
	private double[] distRRA = { 0.72, 0.09, -1, 0 };

	private double maxTime = -1;
	private double expireTime = 0.02;
	private double runSpeed = 500;

	private ValuesConfiguration() {
	}

	public static ValuesConfiguration getInstance() {
		if (rc == null) {
			rc = new ValuesConfiguration();
		}
		return rc;
	}
	
	public void setMaxTime(double t) {
		this.maxTime = t;
	}
	
	public void setExpireTime(double t) {
		if (t > 0) {
			this.expireTime = t;
		}
	}
	public void increaseSpeed() {
		this.runSpeed = runSpeed + 50;
	}
	
	public void decreaseRunSpeed() {
		this.runSpeed = runSpeed - 50;
		if (runSpeed <= 50) {
			runSpeed = 50;
		}
	}

	public void setServerLocal(int s) {
		if (s > 0 ) {
			this.serverLocal = s; 
		}
	}
	
	public void setServerRemote(int s) {
		if (s > 0) {
			this.serverRemote = s;
		}
	}
	
	public void setTecs(double[] tec) {
		int i = 0;
		for (double d : tec) {
			if (d > 0) {
				tecs[i] = d;
			} else if (tecs[i] < 0) {
				tecs[i] = 0.05;
			}
			i++;
		}
	}

	public void setTraffic(double[] traf) {
		int i = 0;
		for (double t: traf) {
			if (t >= 0) {
				traffic[i] = t;
			} else if (traffic[i] < 0) {
				traffic[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRunSpeed(double rSpeed) {
		if (rSpeed > 0)
			this.runSpeed = rSpeed * 100;
	}
	
	public void setReception(double rec) {
		if (rec > 0)
			this.reception = rec;
	}
	
	public void setStatus(double[] st) {

		int i = 0;
		for (double s :st) {
			if (s > 0) {
				this.status[i] = s;
			} else if (status[i] < 0) {
				status[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLLS(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLLS[i] = p;
			} else if (distLLS[i] < 0) {
				distLLS[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLLF(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLLF[i] = p;
			} else if (distLLF[i] < 0) {
				distLLF[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLLA(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLLA[i] = p;
			} else if (distLLA[i] < 0) {
				distLLA[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLRS(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLRS[i] = p;
			} else if (distLRS[i] < 0) {
				distLRS[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLRF(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLRF[i] = p;
			} else if (distLRF[i] < 0) {
				distLRF[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setLRA(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distLRA[i] = p;
			} else if (distLRA[i] < 0) {
				distLRA[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRLS(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRLS[i] = p;
			} else if (distRLS[i] < 0) {
				distRLS[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRLF(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRLF[i] = p;
			} else if (distRLF[i] < 0) {
				distRLF[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRLA(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRLA[i] = p;
			} else if (distRLA[i] < 0) {
				distRLA[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRRS(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRRS[i] = p;
			} else if (distRRS[i] < 0) {
				distRRS[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRRF(double[] d) {
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRRF[i] = p;
			} else if (distRRF[i] < 0) {
				distRRF[i] = 0.05;
			}
			i++;
		}
	}
	
	public void setRRA(double[] d) {
		
		int i = 0;
		for (double p: d) {
			if (p > 0) {
				this.distRRA[i] = p;
			} else if (distRRA[i] < 0) {
				distRRA[i] = 0.05;
			}
			i++;
		}
	}
	
	public double getRunSpeed() {
		return this.runSpeed;
	}
	
	public double getExpireTime() {
		return this.expireTime;
	}
	
	public double[] getTecs() {
		return tecs;
	}

	public double[] getTraffic() {
		return traffic;
	}
	
	public double[] getStatus() {
		
		return this.status;
	}
	
	public double getReception() {
		return reception;
	}
	
	public int getServerLocal() {
		return serverLocal;
	}
	
	public int getServerRemote() {
		return serverRemote;
	}


	public double[] getLLS() {
		return distLLS;
	}
	
	public double[] getLLF() {
		return distLLF;
	}
	
	public double[] getLLA() {
		return distLLA;
	}
	
	public double[] getLRS() {
		return distLRS;
	}
	
	public double[] getLRA() {
		return distLRA;
	}
	
	public double[] getLRF() {
		return distLRF;
	}
	
	public double[] getRLS() {
		return distRLS;
	}
	
	public double[] getRLF() {
		return distRLF;
	}
	
	public double[] getRLA() {
		return distRLA;
	}
	
	public double[] getRRS() {
		return distRRS;
	}
	
	public double[] getRRF() {
		return distRRF;
	}
	
	public double[] getRRA() {
		return distRRA;
	}
	
	public double getMaxTime() {
		return maxTime;
	}

	public void onSetVariablesClicked(double expire, double maxTime, double rSpeed, double[] tecs, double[] trafficVolume, double[] status, double[] distLLS,
			double[] distLLF, double[] distLLA, double[] distLRS, double[] distLRF, double[] distLRA,
			double[] distRLS, double[] distRLF, double[] distRLA, double[] distRRS, double[] distRRF, double[] distRRA, double reception, int server1, int server2) {
	
		setReception(reception);
		setServerLocal(server1);
		setServerRemote(server2);
		
		setTecs(tecs);
		setTraffic(trafficVolume);
		
		setStatus(status);
		setLLS(distLLS);
		setLLF(distLLF);
		setLLA(distLLA);
		
		setLRS(distLRS);
		setLRF(distLRF);
		setLRA(distLRA);
		
		setRLS(distRLS);
		setRLF(distRLF);
		setRLA(distRLA);
		
		setRRS(distRRS);
		setRRF(distRRF);
		
		setRunSpeed(rSpeed);
		setExpireTime(expire);
		setMaxTime(maxTime);
	}



}
