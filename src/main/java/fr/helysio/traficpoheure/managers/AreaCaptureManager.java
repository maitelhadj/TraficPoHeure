package fr.helysio.traficpoheure.managers;

public class AreaCaptureManager {

    private int lvl;
    private double score;
    private int teamId;

    public AreaCaptureManager(int lvl, double score) {
        this.lvl = lvl;
        this.score = score;
        this.teamId = 0;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    private int getLvl() {
        return this.lvl;
    }

    public double getScore() {
        return this.score;
    }

    public int getTeamId() {
        return teamId;
    }
}
