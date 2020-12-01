package com.example.eurekaserver.rate;

public class Space {
    private Long rootId;
    private Long pid;
    private Long id;
    private String spaceName;
    private String spaceType;

    public Space(Long rootId, Long pid, Long id, String spaceName, String spaceType) {
        this.rootId = rootId;
        this.pid = pid;
        this.id = id;
        this.spaceName = spaceName;
        this.spaceType = spaceType;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    @Override
    public String toString() {
        return "Space{" +
                "rootId=" + rootId +
                ", pid=" + pid +
                ", id=" + id +
                ", spaceName='" + spaceName + '\'' +
                ", spaceType='" + spaceType + '\'' +
                '}';
    }
}
