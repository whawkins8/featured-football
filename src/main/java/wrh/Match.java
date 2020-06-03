package wrh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Class for holding information about football match.
 */
public class Match {
	private String homeTeam;
	private String awayTeam;
	private LocalDateTime localMatchTime;
	private static DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm");
	
	public void setLocalMatchTime(String matchTime) {
		localMatchTime = LocalDateTime.parse(matchTime);
	}
	
	public LocalDateTime getLocalMatchTime() {
		return this.localMatchTime;
	}
	
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	@Override
	public String toString() {
		return homeTeam + " vs " + awayTeam + " at " + localMatchTime.format(form);
	}
}
