package common.util.date;

public class DateInterval {
	
	// ¼ä¸ôµÄÃëÊý
	private long betweenInterval = 0L;
	
	private long dayInterval = 0;
	
	private long  hourInterval = 0;
	
	private long  minuteInterval = 0;
	
	private long  secondInterval = 0;

	public long getBetweenInterval() {
		return betweenInterval;
	}

	public void setBetweenInterval(long betweenInterval) {
		this.betweenInterval = betweenInterval;
	}

	public long getDayInterval() {
		return dayInterval;
	}


	public void setDayInterval(long dayInterval) {
		this.dayInterval = dayInterval;
	}


	public long getHourInterval() {
		return hourInterval;
	}


	public void setHourInterval(long hourInterval) {
		this.hourInterval = hourInterval;
	}


	public long getMinuteInterval() {
		return minuteInterval;
	}


	public void setMinuteInterval(long minuteInterval) {
		this.minuteInterval = minuteInterval;
	}


	public long getSecondInterval() {
		return secondInterval;
	}


	public void setSecondInterval(long secondInterval) {
		this.secondInterval = secondInterval;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
