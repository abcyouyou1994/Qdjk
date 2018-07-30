package com.example.administrator.gjdzzpapp.presenter.callback;

public interface CallBack<T> {
    void onSuccess(T response);

    void onError(String t);
}
