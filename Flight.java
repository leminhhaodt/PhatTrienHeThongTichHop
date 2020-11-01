package flight;

import java.io.Serializable;

public class Flight implements Serializable{

	private int Total,Odered;
	private String Flytime,Flydate,Id,From,To;
	
	public String getFlydate() { return Flydate; }
	public void setDate(String x) { this.Flydate = x; }
	
	public String getFlyTime() { return Flytime; }
	public void setFlyTime(String x) { this.Flytime = x; }
	
	public int getTotal() { return Total; }
	public void setTotal(int x) { this.Total = x; }
	
	public int getOdered() { return Odered; }
	public void setOdered(int x) { this.Odered = x; }

	public String getId() { return Id; }
	public void setId(String x) { this.Id = x; }
	
	public String getFrom() { return From; }
	public void setFrom(String x) { this.From = x; }
	
	public String getTo() { return To; }
	public void setTo(String x) { this.To = x; }
	
}

