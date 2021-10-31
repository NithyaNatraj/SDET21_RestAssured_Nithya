package sdet21.POJO.Class;

public class ProjectLibrary {
	
	//create global variables
	String createdBy;
	String projectId;
	String status;
	int teamSize;
//	String createdOn;
//	String projectName;
	
	//initialize all the variables using constructor
	

	public ProjectLibrary(String createdBy, String projectId, String status, int teamSize)
	{
		
		this.createdBy = createdBy;
		this.projectId = projectId;
		
		this.status = status;
		this.teamSize = teamSize;
//		this.createdOn = createdOn;
		//this.projectName = projectName;
		
	}

	//use getters and setters to access the variables
//	
//	public String getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(String createdOn) {
//		this.createdOn = createdOn;
//	}
//
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

//	public String getProjectName() {
//		return projectName;
//	}
//
//	public void setProjectName(String projectName) {
//		this.projectName = projectName;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	


}
