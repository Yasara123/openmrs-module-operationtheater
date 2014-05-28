package org.openmrs.module.operationtheater;
/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

import org.openmrs.BaseOpenmrsObject;
import org.openmrs.OpenmrsMetadata;
import org.openmrs.User;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * Same class as in {@link org.openmrs.BaseOpenmrsMetadata}, but with JPA annotations
 */
@MappedSuperclass
public abstract class BaseOpenmrsMetadataJPA extends BaseOpenmrsObject implements OpenmrsMetadata {

	//***** Properties *****

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name="creator", nullable = false)
	private User creator;

	@Column(name="date_created", nullable = false)
	private Date dateCreated;

	@ManyToOne
	@JoinColumn(name="changed_by")
	private User changedBy;

	@Column(name="date_changed")
	private Date dateChanged;

	@Column(name = "retired", nullable = false, columnDefinition = "BOOLEAN default FALSE")
	private Boolean retired = Boolean.FALSE;

	@Column(name="date_retired")
	private Date dateRetired;

	@ManyToOne
	@JoinColumn(name="retired_by")
	private User retiredBy;

	@Column(name="retire_reason")
	private String retireReason;

	//***** Constructors *****

	/**
	 * Default Constructor
	 */
	public BaseOpenmrsMetadataJPA() {
	}

	//***** Property Access *****

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see org.openmrs.Auditable#getCreator()
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * @see org.openmrs.Auditable#setCreator(org.openmrs.User)
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/**
	 * @see org.openmrs.Auditable#getDateCreated()
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @see org.openmrs.Auditable#setDateCreated(java.util.Date)
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @see org.openmrs.Auditable#getChangedBy()
	 */
	public User getChangedBy() {
		return changedBy;
	}

	/**
	 * @see org.openmrs.Auditable#setChangedBy(org.openmrs.User)
	 */
	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * @see org.openmrs.Auditable#getDateChanged()
	 */
	public Date getDateChanged() {
		return dateChanged;
	}

	/**
	 * @see org.openmrs.Auditable#setDateChanged(java.util.Date)
	 */
	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	/**
	 * @see org.openmrs.Retireable#isRetired()
	 */
	public Boolean isRetired() {
		return retired;
	}

	/**
	 * This method delegates to {@link #isRetired()}. This is only needed for jstl syntax like
	 * ${fieldType.retired} because the return type is a Boolean object instead of a boolean
	 * primitive type.
	 *
	 * @see org.openmrs.Retireable#isRetired()
	 */
	public Boolean getRetired() {
		return isRetired();
	}

	/**
	 * @see org.openmrs.Retireable#setRetired(java.lang.Boolean)
	 */
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	/**
	 * @see org.openmrs.Retireable#getDateRetired()
	 */
	public Date getDateRetired() {
		return dateRetired;
	}

	/**
	 * @see org.openmrs.Retireable#setDateRetired(java.util.Date)
	 */
	public void setDateRetired(Date dateRetired) {
		this.dateRetired = dateRetired;
	}

	/**
	 * @see org.openmrs.Retireable#getRetiredBy()
	 */
	public User getRetiredBy() {
		return retiredBy;
	}

	/**
	 * @see org.openmrs.Retireable#setRetiredBy(org.openmrs.User)
	 */
	public void setRetiredBy(User retiredBy) {
		this.retiredBy = retiredBy;
	}

	/**
	 * @see org.openmrs.Retireable#getRetireReason()
	 */
	public String getRetireReason() {
		return retireReason;
	}

	/**
	 * @see org.openmrs.Retireable#setRetireReason(java.lang.String)
	 */
	public void setRetireReason(String retireReason) {
		this.retireReason = retireReason;
	}

}
