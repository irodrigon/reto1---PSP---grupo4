package com.tartanga.grupo4.model;

/**
 * The {@code SignInSignUpEnum} enum represents various status codes and requests 
 * related to the sign-in and sign-up process in the system. 
 * <p>
 * This enumeration is used to communicate the state or result of an authentication 
 * or registration operation between the client and the server.
 * </p>
 * <ul>
 *   <li>{@code SIGN_IN_REQUEST}: Indicates a request to sign in to the system.</li>
 *   <li>{@code SIGN_UP_REQUEST}: Indicates a request to sign up for a new account.</li>
 *   <li>{@code OK}: Indicates that the sign-in or sign-up request was successful.</li>
 *   <li>{@code USER_PASSWD_ERROR}: Indicates an error with the username or password.</li>
 *   <li>{@code USER_EXIST_IN_DB}: Indicates that the user already exists in the database, preventing sign-up.</li>
 *   <li>{@code SERVER_ERROR}: Indicates an internal server error that occurred during the request.</li>
 *   <li>{@code MAX_CONNECTIONS}: Indicates that the maximum number of connections to the server has been reached.</li>
 * </ul>
 * 
 * Example usage:
 * <pre>
 *     SignInSignUpEnum status = SignInSignUpEnum.SIGN_IN_REQUEST;
 *     switch (status) {
 *         case OK:
 *             // Handle successful login
 *             break;
 *         case USER_PASSWD_ERROR:
 *             // Handle incorrect username or password
 *             break;
 *         // Other cases...
 *     }
 * </pre>
 * 
 * @author Aratz
 */
public enum SignInSignUpEnum {
    /**
     * Represents a request to sign in to the system.
     */
    SIGN_IN_REQUEST,

    /**
     * Represents a request to sign up for a new account.
     */
    SIGN_UP_REQUEST,

    /**
     * Indicates that the sign-in or sign-up operation was successful.
     */
    OK,

    /**
     * Indicates an error with the provided username or password.
     */
    USER_PASSWD_ERROR,

    /**
     * Indicates that the user already exists in the database.
     */
    USER_EXIST_IN_DB,

    /**
     * Indicates an internal server error occurred during the request.
     */
    SERVER_ERROR,

    /**
     * Indicates that the maximum number of allowed connections has been reached.
     */
    MAX_CONNECTIONS;
}
