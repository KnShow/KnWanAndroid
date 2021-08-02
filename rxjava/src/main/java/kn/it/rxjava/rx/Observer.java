package kn.it.rxjava.rx;

public interface Observer<T> {
    void onNext(T t);
    void onError(Throwable e);
    void onComplete();
}
