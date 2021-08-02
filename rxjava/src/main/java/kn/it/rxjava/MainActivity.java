package kn.it.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kn.it.rxjava.rx.Observable;
import kn.it.rxjava.rx.Observer;
import kn.it.rxjava.rx.OnObservableSubScribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable.create(new OnObservableSubScribe<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                observer.onNext("---------");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
