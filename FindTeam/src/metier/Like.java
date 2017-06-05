package metier;

import java.io.Serializable;
import java.util.Date;

public class Like  implements Serializable {

	
	private int LikeID;
	private member MemberA;
	private member MemberB;
	private project project;
	private Date date_like;
	private Character IsMatch ;
	private Character InGroup ;
	
	
	
	public Character getInGroup() {
		return InGroup;
	}
	public void setInGroup(Character inGroup) {
		InGroup = inGroup;
	}
	public int getLikeID() {
		return LikeID;
	}
	public void setLikeID(int likeID) {
		LikeID = likeID;
	}
	public member getMemberA() {
		return MemberA;
	}
	public void setMemberA(member memberA) {
		MemberA = memberA;
	}
	public member getMemberB() {
		return MemberB;
	}
	public void setMemberB(member memberB) {
		MemberB = memberB;
	}
	
	public project getProject() {
		return project;
	}
	public void setProject(project project) {
		this.project = project;
	}
	public Date getDate_like() {
		return date_like;
	}
	public void setDate_like(Date date_like) {
		this.date_like = date_like;
	}
	
	public Character getIsMatch() {
		return IsMatch;
	}
	public void setIsMatch(Character isMatch) {
		IsMatch = isMatch;
	}
	
	
	public Like(member memberA, member memberB, metier.project project,
			Date date_like, Character isMatch) {
		super();
		MemberA = memberA;
		MemberB = memberB;
		this.project = project;
		this.date_like = date_like;
		IsMatch = isMatch;
	}
	public Like() {
		super();
	}
	
	
	
	
	
	
	
	
}
