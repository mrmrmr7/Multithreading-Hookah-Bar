package service.builder;

public class InvalidClientException extends Exception {
    InvalidClientException(String invalidClient) {
        super(invalidClient);
    }
}
