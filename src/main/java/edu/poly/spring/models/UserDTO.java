package edu.poly.spring.models;

public class UserDTO {
	public Long id;
	public String name;
	public Integer age;
	public String userName;
	public String addrest;
	public String urlImage;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long id, String name, Integer age, String userName, String addrest, String urlImage) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.userName = userName;
		this.addrest = addrest;
		this.urlImage = urlImage;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the addrest
	 */
	public String getAddrest() {
		return addrest;
	}

	/**
	 * @param addrest the addrest to set
	 */
	public void setAddrest(String addrest) {
		this.addrest = addrest;
	}

	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
