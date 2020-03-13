package prm.seminar.prm_assignment.task;

public class TaskDTO {
    private String taskID;
    private String taskName;
    private String sourceTaskID;
    private String taskDesc;
    private String taskSolutionType;
    private String taskSolutionDesc;
    private String assigneeID;
    private String reviewDesc;
    private int reviewMark;
    private String reviewDate;
    private String taskStartTime;
    private String taskEndTime;
    private String taskStatus;
    private String statusDesc;
    private String createDate;
    private String createBy;
    private String taskEvd;
    private String lastUpdatedBy;
    private String lastUpdatedDate;

    public TaskDTO() {
    }

    public TaskDTO(String taskID, String taskName, String sourceTaskID, String taskDesc, String taskSolutionType, String taskSolutionDesc, String assigneeID, String reviewDesc, int reviewMark, String reviewDate, String taskStartTime, String taskEndTime, String taskStatus, String statusDesc, String createDate, String createBy, String taskEvd, String lastUpdatedBy, String lastUpdatedDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.sourceTaskID = sourceTaskID;
        this.taskDesc = taskDesc;
        this.taskSolutionType = taskSolutionType;
        this.taskSolutionDesc = taskSolutionDesc;
        this.assigneeID = assigneeID;
        this.reviewDesc = reviewDesc;
        this.reviewMark = reviewMark;
        this.reviewDate = reviewDate;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
        this.taskStatus = taskStatus;
        this.statusDesc = statusDesc;
        this.createDate = createDate;
        this.createBy = createBy;
        this.taskEvd = taskEvd;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSourceTaskID() {
        return sourceTaskID;
    }

    public void setSourceTaskID(String sourceTaskID) {
        this.sourceTaskID = sourceTaskID;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskSolutionType() {
        return taskSolutionType;
    }

    public void setTaskSolutionType(String taskSolutionType) {
        this.taskSolutionType = taskSolutionType;
    }

    public String getTaskSolutionDesc() {
        return taskSolutionDesc;
    }

    public void setTaskSolutionDesc(String taskSolutionDesc) {
        this.taskSolutionDesc = taskSolutionDesc;
    }

    public String getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(String assigneeID) {
        this.assigneeID = assigneeID;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getReviewMark() {
        return reviewMark;
    }

    public void setReviewMark(int reviewMark) {
        this.reviewMark = reviewMark;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public String getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTaskEvd() {
        return taskEvd;
    }

    public void setTaskEvd(String taskEvd) {
        this.taskEvd = taskEvd;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
