package model;

public class PassStatus {
    private Integer keywords;
    private Integer authKeys;
    private Integer authingKeys;
    private Integer passedKeys;
    private Integer noPassedKeys;
    private Integer uselessKeys;

    public PassStatus(Integer keywords, Integer authKeys, Integer authingKeys, Integer passedKeys, Integer noPassedKeys, Integer uselessKeys) {
        this.keywords = keywords;
        this.authKeys = authKeys;
        this.authingKeys = authingKeys;
        this.passedKeys = passedKeys;
        this.noPassedKeys = noPassedKeys;
        this.uselessKeys = uselessKeys;
    }

    public Integer getKeywords() {
        return keywords;
    }

    public void setKeywords(Integer keywords) {
        this.keywords = keywords;
    }

    public Integer getAuthKeys() {
        return authKeys;
    }

    public void setAuthKeys(Integer authKeys) {
        this.authKeys = authKeys;
    }

    public Integer getAuthingKeys() {
        return authingKeys;
    }

    public void setAuthingKeys(Integer authingKeys) {
        this.authingKeys = authingKeys;
    }

    public Integer getPassedKeys() {
        return passedKeys;
    }

    public void setPassedKeys(Integer passedKeys) {
        this.passedKeys = passedKeys;
    }

    public Integer getNoPassedKeys() {
        return noPassedKeys;
    }

    public void setNoPassedKeys(Integer noPassedKeys) {
        this.noPassedKeys = noPassedKeys;
    }

    public Integer getUselessKeys() {
        return uselessKeys;
    }

    public void setUselessKeys(Integer uselessKeys) {
        this.uselessKeys = uselessKeys;
    }
}
