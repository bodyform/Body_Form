package br.com.fourbbit.backend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.fourbbit.backend.enums.ChangedBy;
import br.com.fourbbit.backend.enums.Progress;

@Embeddable
public class Status {

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
	@Column(name = "date")
	private LocalDateTime localDateTime;

	@Type(type = "text")
	@Column(name = "reason", nullable = false)
	private String reason;

	@Column(name = "value", nullable = false, precision = 5, scale = 2)
	private double value;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Progress progress;

	@Column(name = "changed_by", nullable = false)
	@Enumerated(EnumType.STRING)
	private ChangedBy changedBy;

	public Status() {

	}

	public Status(LocalDateTime localDateTime, String reason, double value, Progress progress, ChangedBy changedBy) {
		super();
		this.localDateTime = localDateTime;
		this.reason = reason;
		this.value = value;
		this.progress = progress;
		this.changedBy = changedBy;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	public ChangedBy getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(ChangedBy changedBy) {
		this.changedBy = changedBy;
	}
}