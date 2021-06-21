package objects;

public class MessageSign {
    String sign,date, message;

    public MessageSign(String sign) {
        this.sign = sign;
//        this.date = date;
//        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSign() {
        return sign;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
