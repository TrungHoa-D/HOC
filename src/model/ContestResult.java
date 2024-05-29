package model;

public class ContestResult {
    private String contestName;
    private Integer score;

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ContestResult(String contestName, Integer score) {
        this.contestName = contestName;
        this.score = score;
    }

    public ContestResult() {
    }
}
