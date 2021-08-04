package com.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	private Book book;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private BookOrder bookOrder;
	
	public OrderDetailId() {}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookOrder == null) ? 0 : bookOrder.hashCode());
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
		OrderDetailId other = (OrderDetailId) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookOrder == null) {
			if (other.bookOrder != null)
				return false;
		} else if (!bookOrder.equals(other.bookOrder))
			return false;
		return true;
	}
}
