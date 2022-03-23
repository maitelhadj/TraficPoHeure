package fr.helysio.traficpoheure.managers;

public class ScoreManager {

    private double score;
    private PlantManager plantManager;

    public ScoreManager(PlantManager plantManager) {
        this.score = 0;
        this.plantManager = plantManager;
    }

    public void updateScore() { this.score += plantManager.getTotalScore(); }

    public double getScore() {
        return this.score;
    }

    public PlantManager getPlantManager() {
        return this.plantManager;
    }
}
