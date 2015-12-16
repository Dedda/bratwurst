package org.dedda.webr;

/**
 * Created by dedda on 15.12.15.
 *
 * @author dedda
 */
public class Response {

    private byte[] content;

    private String filetype;

    private int code = 200;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
