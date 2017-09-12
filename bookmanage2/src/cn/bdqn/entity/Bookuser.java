package cn.bdqn.entity;

/**
 * Bookuser entity. @author MyEclipse Persistence Tools
 */

public class Bookuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Integer age;
	private Byte sex;
	private String nickname;
	private Byte usertype;

	// Constructors

	/** default constructor */
	public Bookuser() {
	}

	/** minimal constructor */
	public Bookuser(String name, String password, Byte sex, String nickname,
			Byte usertype) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.nickname = nickname;
		this.usertype = usertype;
	}

	/** full constructor */
	public Bookuser(String name, String password, Integer age, Byte sex,
			String nickname, Byte usertype) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.nickname = nickname;
		this.usertype = usertype;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Byte getSex() {
		return this.sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Byte getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Byte usertype) {
		this.usertype = usertype;
	}

}