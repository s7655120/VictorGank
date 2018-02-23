package com.victor.gank.Data.Common;

/**
 * Created by Victor on 2017/8/2.
 */
public class BaseCallModel<T> {

    public boolean error;
    public T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

}
