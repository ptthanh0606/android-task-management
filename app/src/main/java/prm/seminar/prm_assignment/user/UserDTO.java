package prm.seminar.prm_assignment.user;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String userID, userName, fullName, gender, roleID, workTimeFrom, workTimeTo, teamID;

    public UserDTO(String userID, String userName, String fullName, String gender, String roleID, String workTimeFrom, String workTimeTo, String teamID) {
        this.userID = userID;
        this.userName = userName;
        this.fullName = fullName;
        this.gender = gender;
        this.roleID = roleID;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.teamID = teamID;
    }

    public UserDTO() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getWorkTimeFrom() {
        return workTimeFrom;
    }

    public void setWorkTimeFrom(String workTimeFrom) {
        this.workTimeFrom = workTimeFrom;
    }

    public String getWorkTimeTo() {
        return workTimeTo;
    }

    public void setWorkTimeTo(String workTimeTo) {
        this.workTimeTo = workTimeTo;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }
}
