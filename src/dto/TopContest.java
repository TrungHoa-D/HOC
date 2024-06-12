package dto;

public class TopContest {
    private String name;
    private String handle;
    private Integer group;
    private Integer score;

    public TopContest(String name, String handle, Integer group, Integer score) {
        this.name = name;
        this.handle = handle;
        this.group = group;
        this.score = score;
    }

    public TopContest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
