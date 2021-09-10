package com.company;

public class Errors {

    private boolean error_a;
    private boolean error_f;
    private boolean error_t;

    Errors() {
        this.error_a = false;
        this.error_f = false;
        this.error_t = false;
    }

    public void setError_a(boolean error_a) {
        this.error_a = error_a;
    }

    public boolean getError_a() {
        return this.error_a;
    }

    public void setError_f(boolean error_f) {
        this.error_f = error_f;
    }

    public boolean getError_f() {
        return this.error_f;
    }

    public void setError_T(boolean error_t) {
        this.error_t = error_t;
    }

    public boolean getError_t() {
        return this.error_t;
    }
}
