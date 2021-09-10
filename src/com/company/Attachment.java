package com.company;

public class Attachment {

    private int attachment_num_a;
    private int attachment_num_f;
    private int attachment_num_t;

    Attachment(int num_a, int num_f) {
        this.attachment_num_a = num_a;
        this.attachment_num_f = num_f;
    }

    Attachment(int num_t) {
        this.attachment_num_t = num_t;
    }

    public void setAttachment_numA(int attachment_num_a) {
        this.attachment_num_a = attachment_num_a;
    }

    public int getAttachment_numA() {
        return this.attachment_num_a;
    }

    public void setAttachment_numF(int attachment_num_f) {
        this.attachment_num_f = attachment_num_f;
    }

    public int getAttachment_numF() {
        return this.attachment_num_f;
    }

    public void setAttachment_numT(int attachment_num_t) {
        this.attachment_num_t = attachment_num_t;
    }

    public int getAttachment_numT() {
        return this.attachment_num_t;
    }

}
