package cn.bdqn.entity;

import java.util.Date;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String author;
	private String publish;
	private Date publishdate;
	private Integer page;
	private Double price;
	private String content;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String name, String author, String publish, Date publishdate) {
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
	}

	/** full constructor */
	public Book(String name, String author, String publish, Date publishdate,
			Integer page, Double price, String content) {
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
		this.page = page;
		this.price = price;
		this.content = content;
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

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return this.publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public Date getPublishdate() {
		return this.publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public Integer getPage() {
		return this.page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}