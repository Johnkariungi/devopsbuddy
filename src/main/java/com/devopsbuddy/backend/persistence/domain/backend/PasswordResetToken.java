package com.devopsbuddy.backend.persistence.domain.backend;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.slf4j.*;

import com.devopsbuddy.backend.persistence.converters.LocalDateTimeAttributeConverter;

@Entity
public class PasswordResetToken implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	/** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(PasswordResetToken.class);
    
    private final static int DEFAULT_TOKEN_LENGTH_IN_MINUTES = 120;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String token;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user; /** FK to user table , eager to want to already have access to the user table*/
	
	@Column(name = "expiry_date")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime expiryDate;
	
	/**
     * Default constructor.
     */
	public PasswordResetToken() {}

	public PasswordResetToken(String token, User user, LocalDateTime creationDateTime, int expirationInMinutes) {
		if ((null == token) || (null == user) || (null == creationDateTime)) {
			throw new IllegalArgumentException("token, user and creation date time can't be null.");
		}
		
		if (expirationInMinutes == 0) {
			LOG.warn("The token expiration length in minutes is zero. Assigning the  default value {} ", DEFAULT_TOKEN_LENGTH_IN_MINUTES);
			expirationInMinutes = DEFAULT_TOKEN_LENGTH_IN_MINUTES;
		}
		this.token = token;
		this.user = user;
		expiryDate = creationDateTime.plusMinutes(expirationInMinutes);
	}

	/** Getters, setters */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	/* Hash methods with id attribute */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PasswordResetToken that = (PasswordResetToken) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
