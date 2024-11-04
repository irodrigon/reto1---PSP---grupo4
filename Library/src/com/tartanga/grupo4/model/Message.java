package com.tartanga.grupo4.model;

import java.io.Serializable;

/**
 * Represents a message object used for communication purposes between different parts of the system.
 * <p>
 * The {@code Message} class encapsulates user information and a type indicator, which can be used to
 * determine whether the message pertains to a sign-in or sign-up operation.
 * This class implements {@code Serializable} to allow instances to be easily serialized and transmitted.
 * </p>
 * <p>
 * Example usage:
 * <pre>
 *     Message message = new Message();
 *     message.setUser(new User("email@example.com", "password", "name", "street", true, "city", 12345));
 *     message.setSignInSignUpEnum(SignInSignUpEnum.SIGN_IN);
 * </pre>
 * </p>
 * 
 * @author rabio
 */
public class Message implements Serializable {

    /**
     * Serial version UID for ensuring compatibility during the deserialization process.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The {@code User} object associated with this message.
     */
    private User user;

    /**
     * An {@code Enum} that specifies whether this message pertains to a sign-in or sign-up operation.
     */
    private Enum SignInSignUpEnum;

    /**
     * Default constructor for creating an empty {@code Message} instance.
     */
    public Message() {
    }

    /**
     * Gets the {@code User} object associated with this message.
     * 
     * @return The {@code User} object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the {@code User} object associated with this message.
     * 
     * @param user The {@code User} object to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the {@code Enum} that indicates the type of operation (sign-in or sign-up).
     * 
     * @return The {@code Enum} indicating the type of operation.
     */
    public Enum getSignInSignUpEnum() {
        return SignInSignUpEnum;
    }

    /**
     * Sets the {@code Enum} that indicates the type of operation (sign-in or sign-up).
     * 
     * @param SignInSignUpEnum The {@code Enum} to set.
     */
    public void setSignInSignUpEnum(Enum SignInSignUpEnum) {
        this.SignInSignUpEnum = SignInSignUpEnum;
    }
}
