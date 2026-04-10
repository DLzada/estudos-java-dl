package br.com.daniel.spring_api_simple.handler;

public class ResponseError {
    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;

    public Date getTimestamp() {
        return timestamp;
    }

    public ResponseError setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResponseError setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ResponseError setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getError() {
        return error;
    }

    public ResponseError setError(String error) {
        this.error = error;
        return this;
    }

}
