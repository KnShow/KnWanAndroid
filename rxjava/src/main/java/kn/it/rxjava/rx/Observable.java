package kn.it.rxjava.rx;

public class Observable <T>{

    private final OnObservableSubScribe<T> onSubscribe;

    public Observable(OnObservableSubScribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T>Observable<T> create(OnObservableSubScribe<T> onSubscribe){
        return new Observable(onSubscribe);
    }

    public void subscribe(Observer<? super T> observer){
        onSubscribe.subscribe(observer);
    }
}
