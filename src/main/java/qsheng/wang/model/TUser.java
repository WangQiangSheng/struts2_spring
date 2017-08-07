package qsheng.wang.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER", schema = "KLOSE", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class TUser implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String pwd;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String id) {
		this.id = id;
	}

	/** full constructor */
	public TUser(String id, String name, String pwd, Timestamp createdatetime, Timestamp modifydatetime) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PWD", length = 32)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "CREATEDATETIME", length = 7)
	public Timestamp getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "MODIFYDATETIME", length = 7)
	public Timestamp getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Timestamp modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

}