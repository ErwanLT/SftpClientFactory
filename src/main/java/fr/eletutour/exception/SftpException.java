package fr.eletutour.exception;

import org.springframework.http.HttpStatus;

public class SftpException extends RuntimeException{

    private final HttpStatus status;

    public SftpException(String msg){
        super(msg);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public SftpException(String msg, HttpStatus status){
        super(msg);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
