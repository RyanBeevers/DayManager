package com.dayManager.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="activities")
public class Activities implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="startTime")
	@NotNull
	private String startTime;
	
	@Column(name="endTime")
	@NotNull
	private String endTime;
	
	@Column(name="dayOfWeek")
	@NotNull
	private String dayOfWeek;
	
	@Column(name="specialActivity")
	@NotNull
	private boolean specialActivity;
	
	@Column(name="activity")
	@NotNull
	private String activity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User addedBy;
	
	public Activities () {}

	public Activities(Integer id, @NotNull String startTime, @NotNull String endTime, @NotNull String dayOfWeek,
			@NotNull boolean specialActivity, @NotNull String activity, User addedBy) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
		this.specialActivity = specialActivity;
		this.activity = activity;
		this.addedBy = addedBy;
	}

	public Activities(@NotNull String startTime, @NotNull String endTime, @NotNull String dayOfWeek,
			@NotNull boolean specialActivity, @NotNull String activity) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
		this.specialActivity = specialActivity;
		this.activity = activity;
	}

	public Activities(Integer id, @NotNull String startTime, @NotNull String endTime, @NotNull String dayOfWeek,
			@NotNull boolean specialActivity, @NotNull String activity) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
		this.specialActivity = specialActivity;
		this.activity = activity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public boolean isSpecialActivity() {
		return specialActivity;
	}

	public void setSpecialActivity(boolean specialActivity) {
		this.specialActivity = specialActivity;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((addedBy == null) ? 0 : addedBy.hashCode());
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (specialActivity ? 1231 : 1237);
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activities other = (Activities) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (addedBy == null) {
			if (other.addedBy != null)
				return false;
		} else if (!addedBy.equals(other.addedBy))
			return false;
		if (dayOfWeek == null) {
			if (other.dayOfWeek != null)
				return false;
		} else if (!dayOfWeek.equals(other.dayOfWeek))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (specialActivity != other.specialActivity)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activities [startTime=" + startTime + ", endTime=" + endTime + ", dayOfWeek=" + dayOfWeek
				+ ", specialActivity=" + specialActivity + ", activity=" + activity + ", addedBy=" + addedBy + "]";
	}

	
	
	
	
}