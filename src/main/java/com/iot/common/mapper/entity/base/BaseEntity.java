package com.iot.common.mapper.entity.base;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Class Name BasicEntity
 * @since 2019.April.17
 * @see entity对象的必有字段，和数据库表定义的规范中的必须字段对应。
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseEntity {

	private Date createTime;

	private String createUser;

	//private Boolean enableFlag;

	private Date updateTime;

	private String updateUser;

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(final Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(final String createUser) {
		this.createUser = createUser;
	}

	/*public Boolean getEnableFlag() {
		return this.enableFlag;
	}

	public void setEnableFlag(final Boolean enableFlag) {
		this.enableFlag = enableFlag;
	}*/

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(final Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(final String updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public boolean equals(final Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (this.getClass() != that.getClass()) {
			return false;
		}
		BaseEntity other = (BaseEntity) that;
		return (this.getCreateTime() == null ? other.getCreateTime() == null
				: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getCreateUser() == null ? other.getCreateUser() == null
						: this.getCreateUser().equals(other.getCreateUser()))
				/*&& (this.getEnableFlag() == null ? other.getEnableFlag() == null
						: this.getEnableFlag().equals(other.getEnableFlag()))*/
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getUpdateUser() == null ? other.getUpdateUser() == null
						: this.getUpdateUser().equals(other.getUpdateUser()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getCreateTime() == null) ? 0 : this.getCreateTime().hashCode());
		result = prime * result + ((this.getCreateUser() == null) ? 0 : this.getCreateUser().hashCode());
		//result = prime * result + ((this.getEnableFlag() == null) ? 0 : this.getEnableFlag().hashCode());
		result = prime * result + ((this.getUpdateTime() == null) ? 0 : this.getUpdateTime().hashCode());
		result = prime * result + ((this.getUpdateUser() == null) ? 0 : this.getUpdateUser().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(this.hashCode());
		sb.append(", createTime=").append(this.createTime);
		sb.append(", createUser=").append(this.createUser);
		//sb.append(", enableFlag=").append(this.enableFlag);
		sb.append(", updateTime=").append(this.updateTime);
		sb.append(", updateUser=").append(this.updateUser);
		sb.append("]");
		return sb.toString();
	}
}
